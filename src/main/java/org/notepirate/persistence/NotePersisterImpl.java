package org.notepirate.persistence;

import io.minio.GetObjectArgs;
import io.minio.GetObjectResponse;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import lombok.RequiredArgsConstructor;
import org.notepirate.domain.Note;
import org.notepirate.usecases.persistence.NotePersister;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@RequiredArgsConstructor
public class NotePersisterImpl implements NotePersister {

    private final MinioClient minioClient;
    private final String bucketName;

    @Override
    public void save(Note note) {
        try {
            byte[] objectBytes = note.getContent().getBytes(StandardCharsets.UTF_8);
            InputStream inputStream = new ByteArrayInputStream(objectBytes);
            minioClient.putObject(
                    PutObjectArgs.builder().bucket(bucketName).object(note.getId()).stream(inputStream, objectBytes.length, -1).build()
            );
        } catch (Exception exception) {
            throw new RuntimeException("Error while writing note", exception);
        }
    }

    @Override
    public Note get(String id) {
        try {
            GetObjectResponse response = minioClient.getObject(GetObjectArgs.builder().bucket(bucketName).object(id).build());
            String noteContent = new String(response.readAllBytes(), StandardCharsets.UTF_8);
            return new Note(id, "name", noteContent);
        } catch (Exception exception) {
            throw new RuntimeException("Error while reading note", exception);
        }
    }
}

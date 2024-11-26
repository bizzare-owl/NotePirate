package org.notepirate.configuration;

import io.minio.MinioClient;
import org.notepirate.configuration.properties.S3ConfigurationProperties;
import org.notepirate.persistence.NotePersisterImpl;
import org.notepirate.usecases.persistence.NotePersister;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(S3ConfigurationProperties.class)
public class PersistenceConfiguration {

    @Bean
    public NotePersister notePersister(MinioClient minioClient, S3ConfigurationProperties s3ConfigurationProperties) {
        return new NotePersisterImpl(minioClient, s3ConfigurationProperties.getBuckets().getNotesBucketName());
    }

}

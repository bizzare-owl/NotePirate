package org.notepirate.configuration;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import org.notepirate.configuration.properties.S3ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(S3ConfigurationProperties.class)
public class S3Configuration {

    @Bean
    public MinioClient minioClient(S3ConfigurationProperties s3ConfigurationProperties) {
        MinioClient minioClient = MinioClient.builder()
                .endpoint(s3ConfigurationProperties.getEndpoint(), s3ConfigurationProperties.getPort(), s3ConfigurationProperties.isSecure())
                .credentials(
                        s3ConfigurationProperties.getCredentials().getAccessKey(),
                        s3ConfigurationProperties.getCredentials().getSecretKey()
                ).build();

        try {
            if (!minioClient.bucketExists(BucketExistsArgs.builder().bucket(s3ConfigurationProperties.getBuckets().getNotesBucketName()).build())) {
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(s3ConfigurationProperties.getBuckets().getNotesBucketName()).build());
            }
        } catch (Exception exception) {
            throw new RuntimeException("Error while initializing buckets", exception);
        }

        return minioClient;
    }

}

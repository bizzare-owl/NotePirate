package org.notepirate.configuration.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("application.s3")
@Getter
@Setter
public final class S3ConfigurationProperties {

    String endpoint;
    int port;
    boolean secure;
    Credentials credentials;
    Buckets buckets;

    @Getter
    @Setter
    public static class Credentials {
        String accessKey;
        String secretKey;
    }

    @Getter
    @Setter
    public static class Buckets {
        String notesBucketName;
    }

}

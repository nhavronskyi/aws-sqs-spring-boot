package com.example.demo.props;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "cloud.aws.credentials")
public record SQSCredentialsProps(String accessKey, String secretKey) {
}

package com.example.demo.props;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "cloud.aws.end-point")
public record SQSEndPointProps(String uri) {
}

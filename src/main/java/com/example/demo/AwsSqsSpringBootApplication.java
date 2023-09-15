package com.example.demo;

import com.example.demo.props.SQSCredentialsProps;
import com.example.demo.props.SQSEndPointProps;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({SQSCredentialsProps.class, SQSEndPointProps.class})
public class AwsSqsSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(AwsSqsSpringBootApplication.class, args);
    }

}

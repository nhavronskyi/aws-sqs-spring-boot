package com.example.demo.service;

import com.example.demo.props.SQSEndPointProps;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpStatus;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageBroker {

    private final QueueMessagingTemplate template;

    private final SQSEndPointProps endPointProps;

    public int sendMessageToQueue(String message) {
        try {
            template.send(endPointProps.uri(), MessageBuilder.withPayload(message)
                    .build());
            return HttpStatus.SC_OK;
        } catch (Exception e) {
            return HttpStatus.SC_METHOD_FAILURE;
        }
    }
}

package com.example.demo.service;

import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.example.demo.props.SQSEndPointProps;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageReceiver {
    private final SQSEndPointProps endPointProps;

    private final AmazonSQSAsync receiver;

    public List<String> loadMessagesFromQueue() {
        List<String> list = new LinkedList<>();

        ReceiveMessageRequest rec = new ReceiveMessageRequest(endPointProps.uri()).withWaitTimeSeconds(0);


        List<Message> messages = receiver.receiveMessage(rec).getMessages();

        while (!messages.isEmpty()) {
            list.addAll(messages.stream().map(Message::getBody).toList());

            messages = receiver.receiveMessage(rec).getMessages();
        }

        return list;
    }
}

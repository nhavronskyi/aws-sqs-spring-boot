package com.example.demo.controller;

import com.example.demo.service.MessageBroker;
import com.example.demo.service.MessageReceiver;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class SQSController {
    private final MessageBroker broker;
    private final MessageReceiver receiver;

    @PostMapping("send")
    public int send(@RequestParam String message) {
        return broker.sendMessageToQueue(message);
    }

    @GetMapping("get")
    public List<String> get() {
        return receiver.loadMessagesFromQueue();
    }

    @SqsListener("demo-queue")
    public void loadMessagesFromQueue(String message) {
        System.out.println("Queue Messages: " + message);
    }
}

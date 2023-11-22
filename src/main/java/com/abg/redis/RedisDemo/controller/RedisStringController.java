package com.abg.redis.RedisDemo.controller;

import com.abg.redis.RedisDemo.model.redis.Message;
import com.abg.redis.RedisDemo.payload.MessagePayload;
import com.abg.redis.RedisDemo.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Creator: azizul.islam
 * Date: 11/22/2023
 */
@RestController
@RequestMapping("/api")
public class RedisStringController {
    @Autowired
    private RedisService redisService;
    private final String jwtToken = "jwt";

    @PostMapping("/token")
    public String setToken(@RequestBody String jwt) {
        System.out.println(jwt);
        redisService.setStringValue(jwtToken, jwt);
        return "Jwt is set in redis";
    }

    @GetMapping("/token")
    public String getJwtToken() {
        String jwt = redisService.getStringValue(jwtToken);
        System.out.println(jwt);
        return jwt;
    }

    @PostMapping("/msg")
    public ResponseEntity<MessagePayload> save(@RequestBody MessagePayload messagePayload) {
        Message message = new Message();
        message.setMsg(messagePayload.getMsg());
        message.setSender(messagePayload.getSender());
        message = redisService.saveMessage(message);
        return new ResponseEntity<>(new MessagePayload(message.getId(), message.getMsg(), message.getSender()), HttpStatus.OK);
    }

    @GetMapping("/msg")
    public ResponseEntity<List<MessagePayload>> getAllMessage() {
        List<Message> msgList = redisService.getAllMessage();
        List<MessagePayload> resList = new ArrayList<>();
        msgList.forEach(message -> resList.add(new MessagePayload(message.getId(), message.getMsg(), message.getSender())));
        return new ResponseEntity<>(resList, HttpStatus.OK);
    }
}

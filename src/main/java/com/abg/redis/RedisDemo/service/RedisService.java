package com.abg.redis.RedisDemo.service;

import com.abg.redis.RedisDemo.model.redis.Message;
import com.abg.redis.RedisDemo.repository.redis.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 * Creator: azizul.islam
 * Date: 11/22/2023
 */
@Service
@RequiredArgsConstructor
public class RedisService {

    private final RedisTemplate<String, String> redisTemplate;

    private final MessageRepository messageRepository;

    public void setStringValue(String key, String value) {
        // Using RedisTemplate's opsForValue() to operate on string values
        redisTemplate.opsForValue().set(key, value);
    }

    public String getStringValue(String key) {
        // Using RedisTemplate's opsForValue() to retrieve a string value
        return redisTemplate.opsForValue().get(key);
    }

    public Message saveMessage(Message message){
        return messageRepository.save(message);
    }

    public List<Message> getAllMessage(){
       return (List<Message>) messageRepository.findAll();
    }

}

package com.abg.redis.RedisDemo.model.redis;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

/**
 * Description:
 * Creator: azizul.islam
 * Date: 11/22/2023
 */
@Getter
@Setter
@RedisHash("message")
public class Message {
    @Id
    private String id;
    @Indexed
    private String msg;

    private String sender;
}

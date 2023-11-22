package com.abg.redis.RedisDemo.payload;

import lombok.*;

import java.io.Serializable;

/**
 * Description:
 * Creator: azizul.islam
 * Date: 11/22/2023
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MessagePayload implements Serializable {
    private String id;
    private String msg;
    private String sender;
}

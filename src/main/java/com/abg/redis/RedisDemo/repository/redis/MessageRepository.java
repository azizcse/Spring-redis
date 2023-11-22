package com.abg.redis.RedisDemo.repository.redis;

import com.abg.redis.RedisDemo.model.redis.Message;
import org.springframework.data.repository.CrudRepository;

/**
 * Description:
 * Creator: azizul.islam
 * Date: 11/22/2023
 */
public interface MessageRepository extends CrudRepository<Message, String> {

}
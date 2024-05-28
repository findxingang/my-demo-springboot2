package pers.xingang.demo;

import java.util.*;
import io.lettuce.core.*;
import io.lettuce.core.api.reactive.RedisReactiveCommands;
import io.lettuce.core.api.StatefulRedisConnection;

public class Main2 {
    public static void main(String[] args) {
        RedisClient redisClient = RedisClient.create("redis://localhost:6379");

        try (StatefulRedisConnection<String, String> connection = redisClient.connect()) {
            RedisReactiveCommands<String, String> reactiveCommands = connection.reactive();

            // Reactively store & retrieve a simple string
            reactiveCommands.set("foo", "bar").block();
            reactiveCommands.get("foo").doOnNext(System.out::println).block(); // prints bar

            // Reactively store key-value pairs in a hash directly
            Map<String, String> hash = new HashMap<>();
            hash.put("name", "John");
            hash.put("surname", "Smith");
            hash.put("company", "Redis");
            hash.put("age", "29");

            reactiveCommands.hset("user-session:124", hash).then(
                            reactiveCommands.hgetall("user-session:124")
                                    .collectMap(KeyValue::getKey, KeyValue::getValue).doOnNext(System.out::println))
                    .block();
            // Prints: {surname=Smith, name=John, company=Redis, age=29}

        } finally {
            redisClient.shutdown();
        }
    }
}

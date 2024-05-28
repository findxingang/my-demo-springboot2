import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPooled;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xingang
 * @since 2024/05/27 19:59
 */
public class Main2 {
    public static void main(String[] args) {
        JedisPooled jedis = new JedisPooled("localhost", 6379);
        // Store & Retrieve a simple string
        jedis.set("foo", "bar");
        System.out.println(jedis.get("foo")); // prints bar

        // Store & Retrieve a HashMap
        Map<String, String> hash = new HashMap<>();
        hash.put("name", "John");
        hash.put("surname", "Smith");
        hash.put("company", "Redis");
        hash.put("age", "29");
        jedis.hset("user-session:123", hash);
        System.out.println(jedis.hgetAll("user-session:123"));
        // Prints: {name=John, surname=Smith, company=Redis, age=29}
    }
}
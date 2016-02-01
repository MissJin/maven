package com.hcj.spring.core.feature.redis;

import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * Created by HCJ on 2016/1/18.
 */
@Component(value="RedisCache")
public class RedisCache {
    private static  int port = 6379;
    private static String host = "127.0.0.1";
    private static Jedis jedis = new Jedis(host,port);

    public static Jedis getJedis(){
        return  jedis;
    }

    public String cahe(String key, String value, int seconds ){
        String result = jedis.set(key, value);
        /*键值的有效时间*/
        jedis.expire(key, seconds);
        return  result;
    }

    public String get(String key){
        return  jedis.get(key);
    }

}

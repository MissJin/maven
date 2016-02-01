package com.hcj.spring.cache_redis;

import com.hcj.spring.core.feature.redis.RedisCache;
import com.hcj.spring.core.feature.test.TestSupport;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.List;

/**
 * 使用redis ,需要安装redis,并把server启动，建议安装服务器版本的
 * Created by HCJ on 2016/1/18.
 */
public class RedisTest extends TestSupport {

/*    private int port = 6379;
    private String host = "127.0.0.1";
    private Jedis jedis = new Jedis(host,port);

    public String cahe(String key, String value, int seconds ){
        String result = jedis.set(key, value);
        *//*键值的有效时间*//*
        jedis.expire(key, seconds);
        return  result;
    }

    public String get(String key){
        return  jedis.get(key);
    }*/

    @Resource
    private RedisCache redisCache;

    @Test
    public void testSet(){
        redisCache.cahe("hcj", "1476932600", 1);
    }

    @Test
    public void testGet(){
        System.err.println("hcj:" + redisCache.get("hcj"));
    }

    @Test
    public void testList(){
        Jedis jedis = redisCache.getJedis();
        jedis.lpush("hcj1", new String[]{"test1", "test2"});
        List<String> list = jedis.lrange("hcj1",0,-1);

        for(int i=0;i<list.size();i++){
            System.err.println(list.get(i));
        }

        for (String str: list){
            System.err.println(str.toString());
        }
    }


}

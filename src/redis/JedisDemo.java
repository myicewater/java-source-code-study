package redis;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;

public class JedisDemo {

	private static final String url = "localhost";
	
	public static Jedis getJedis(String host,Integer port){
		Jedis jedis = new Jedis(host, port);
		return jedis;
	}
	
	public static Jedis getJedis(String host){
		Jedis jedis = new Jedis(host);
		return jedis;
	}
	
	
	
	public static void main(String[] args) {

		Jedis jedis = getJedis(url);
		System.out.println("jedis run :"+jedis.ping());
		
		//add string
		jedis.set("firstHit", "hello world");
		
		System.out.println("firstHit:"+jedis.get("firstHit"));
		
		
		
		//list 
		jedis.del("say");
		jedis.lpush("say", "Hello");
		jedis.lpush("say", "World");
		
		List<String> say = jedis.lrange("say", 0,2);
		System.out.println("size:"+say.size());
		for(int i=0;i<say.size();i++){
			System.out.println("say["+i+"]:"+say.get(i));
		}
		
		Set<String> keys = jedis.keys("*");
		System.out.println("all keys:");
		for(String k : keys){
			System.out.println(""+k);
		}
		
	}

}

package edu.keith.mvc.goods.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;

import edu.keith.mvc.dao.redis.AbstractRedisDao;
import edu.keith.mvc.goods.entity.Goods;

@Component
public class RedisGoodsDao extends AbstractRedisDao<String, Goods> {

	public Goods get(final int keyId){
		return this.redisTemplate.execute(new RedisCallback<Goods>(){

			@Override
			public Goods doInRedis(RedisConnection connection)
					throws DataAccessException {
				// TODO Auto-generated method stub
				RedisSerializer<String> serializer = getRedisSerializer();
				byte[] key = serializer.serialize(Goods.class.getName()+"#"+keyId);
				byte[] values = connection.get(key);
				if(values == null)
					return null;
				String value = serializer.deserialize(values);
				return new Goods(value);
			}
			
		});
	}
	
	public boolean put(final Goods goods){
		return this.redisTemplate.execute(new RedisCallback<Boolean>(){

			@Override
			public Boolean doInRedis(RedisConnection paramRedisConnection)
					throws DataAccessException {
				// TODO Auto-generated method stub
				RedisSerializer<String> serializer = getRedisSerializer();
				byte[] key = serializer.serialize(Goods.class.getName()+"#"+goods.getSid());
				byte[] value = serializer.serialize(goods.toString());
				return paramRedisConnection.setNX(key, value);
			}
			
		});
	}
}

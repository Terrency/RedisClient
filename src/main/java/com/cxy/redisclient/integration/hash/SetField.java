package com.cxy.redisclient.integration.hash;

import com.cxy.redisclient.domain.RedisVersion;
import com.cxy.redisclient.integration.JedisCommand;

public class SetField extends JedisCommand {
	private String db;
	private String key;
	private String field;
	private String value;
	
	public SetField(int id, String db, String key, String field, String value) {
		super(id);
		this.db = db;
		this.key = key;
		this.field = field;
		this.value = value;
	}

	@Override
	protected void command() {
		jedis.hset(key, field, value);
		
	}

	@Override
	public RedisVersion getSupportVersion() {
		return RedisVersion.REDIS_2_0;
	}

}

package com.cxy.redisclient.integration.key;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import com.cxy.redisclient.domain.Node;
import com.cxy.redisclient.domain.NodeType;
import com.cxy.redisclient.domain.RedisVersion;
import com.cxy.redisclient.integration.JedisCommand;

public class ListKeys extends JedisCommand {
	private String index;
	private Set<Node> nodes = new TreeSet<Node>();

	public Set<Node> getNodes() {
		return nodes;
	}

	public ListKeys(int id, String index) {
		super(id);
		this.index = index;
	}

	@Override
	public void command() {
		Set<String> nodekeys = jedis.keys("*");
		Iterator<String> it = nodekeys.iterator();
		while (it.hasNext()) {
			String key = (String)it.next();
			NodeType nodeType = getValueType(key);
			
			Node node = new Node(String.valueOf(id), index, key, nodeType);
			nodes.add(node);
		}
	}

	@Override
	public RedisVersion getSupportVersion() {
		return RedisVersion.REDIS_1_0;
	}

	

}

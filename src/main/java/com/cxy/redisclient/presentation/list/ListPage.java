package com.cxy.redisclient.presentation.list;

import java.util.List;

import com.cxy.redisclient.presentation.component.Page;
import com.cxy.redisclient.service.ListService;


public class ListPage extends Page {
	private ListService service = new ListService();
	private int start;
	private List<String> page;
	
	public ListPage(int id, String index, String key) {
		super(id, index, key);
	}

	public void initPage(int start, int end) {
		this.start = start;
		page = service.getPage(id, index, key, start, end);
	}

	public String[] getText(int row) {
		String[] values = new String[]{""};
		int index = row-start;
		if(index < page.size())
			values = new String[]{page.get(index)};
		return values;
	}

	
}

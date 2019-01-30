package com.html.dto;

import java.util.HashMap;

public class CommUpOnceVO
{
	private HashMap<String, Integer> data = new HashMap<String, Integer>();
	
	public void put(String ipNum, int boardNum)
	{
		data.put(ipNum, boardNum);
	}
	public int get(String ipNum)
	{
		int r = data.get(ipNum) == null ? 0 : data.get(ipNum);
		return r;
	}
}

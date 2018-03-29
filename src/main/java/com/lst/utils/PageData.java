package com.lst.utils;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class PageData extends ConcurrentHashMap implements Map{
	
	private static final long serialVersionUID = 1L;
	
	Map map = null;
	HttpServletRequest request;

	public PageData(HttpServletRequest request){
		this.request = request;
		Map properties = request.getParameterMap();
		Map returnMap = new HashMap<>();
		Iterator entries = properties.entrySet().iterator();
		Entry entry;
		String name = "";
		String value = "";
		while (entries.hasNext()) {
			entry = (Entry) entries.next();
			name = (String) entry.getKey();
			Object valueObj = entry.getValue();
			if(null == valueObj){
				value = "";
			}else if(valueObj instanceof String[]){
				String[] values = (String[])valueObj;
				for(int i=0;i<values.length;i++){
					value = values[i] + ",";
				}
				value = value.substring(0, value.length()-1);
			}else{
				value = valueObj.toString();
			}
			returnMap.put(name, value);
		}
		map = returnMap;
	}

	public PageData(HttpServletRequest request, boolean needHeaders){
		String userid = request.getHeader("userid");
		this.request = request;
		Map properties = request.getParameterMap();
		Map returnMap = new HashMap<>();
		Iterator entries = properties.entrySet().iterator();
		Entry entry;
		String name = "";
		String value = "";
		while (entries.hasNext()) {
			entry = (Entry) entries.next();
			name = (String) entry.getKey();
			Object valueObj = entry.getValue();
			if(null == valueObj){
				value = "";
			}else if(valueObj instanceof String[]){
				String[] values = (String[])valueObj;
				for(int i=0;i<values.length;i++){
					value = values[i] + ",";
				}
				value = value.substring(0, value.length()-1);
			}else{
				value = valueObj.toString();
			}
			returnMap.put(name, value);
		}

		if (needHeaders){
			Enumeration<String> headerNames = request.getHeaderNames();
			while (headerNames.hasMoreElements()){
				String s = headerNames.nextElement();
				String header = request.getHeader(s);
				returnMap.put(s,header);
			}
		}
		map = returnMap;
	}
	public PageData(HttpServletRequest request, String header){
		this.request = request;
		Map properties = request.getParameterMap();
		Map returnMap = new HashMap<>();
		Iterator entries = properties.entrySet().iterator();
		Entry entry;
		String name = "";
		String value = "";
		while (entries.hasNext()) {
			entry = (Entry) entries.next();
			name = (String) entry.getKey();
			Object valueObj = entry.getValue();
			if(null == valueObj){
				value = "";
			}else if(valueObj instanceof String[]){
				String[] values = (String[])valueObj;
				for(int i=0;i<values.length;i++){
					value = values[i] + ",";
				}
				value = value.substring(0, value.length()-1);
			}else{
				value = valueObj.toString();
			}
			returnMap.put(name, value);
		}

		String val = request.getHeader(header);
		returnMap.put(header,val);
		map = returnMap;
	}
	
	public PageData() {
		map = new HashMap();
	}

	public PageData(Map hashMap) {
		map = hashMap;
	}
	
	@Override
	public Object get(Object key) {
		Object obj = null;
		if(map.get(key) instanceof Object[]) {
			Object[] arr = (Object[])map.get(key);
			obj = request == null ? arr:(request.getParameter((String)key) == null ? arr:arr[0]);
		} else {
			obj = map.get(key);
		}
		return obj;
	}
	
	public String getString(Object key) {
		return (String)get(key);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Object put(Object key, Object value) {
		return map.put(key, value);
	}
	
	@Override
	public Object remove(Object key) {
		return map.remove(key);
	}


	
}

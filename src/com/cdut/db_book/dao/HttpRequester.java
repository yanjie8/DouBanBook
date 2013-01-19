package com.cdut.db_book.dao;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class HttpRequester {

	
	public HttpRequester(){
	}
	
	public static HttpRequester getInstance() {
		if (instance == null) {
			instance = new HttpRequester();
		}
		return instance;
	}
	private static HttpRequester instance = null;
	private List<Map<String, String>> callParam = new ArrayList<Map<String, String>>();
	private String url;;
	
	public void setCallParam(String key, String value) {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put(key, value);
		callParam.add(paramMap);
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@SuppressWarnings("deprecation")
	public String executing() {
		HttpClient httpclient = new DefaultHttpClient();
		String result = null;
		String params="?";
		try {
			HttpResponse response;
			if (callParam != null && callParam.size() > 0) {
				for (Map<String, String> pm : callParam) {
					Set<String> keys = pm.keySet();
					Iterator<String> its = keys.iterator();
					while (its.hasNext()) {
						String key = its.next();
						params+=key+"="+URLEncoder.encode(pm.get(key));
					}
				}
			System.out.println(url+params);
			}
			
			HttpGet httpget = new HttpGet(url+params);
			response = httpclient.execute(httpget);
			System.out.println(response.getStatusLine());
			HttpEntity entity = response.getEntity();
			if (entity != null)
				result = EntityUtils.toString(entity, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
		// 关闭连接,释放资源
		httpclient.getConnectionManager().shutdown();
		callParam.clear();
		}
		return result;
	}
}

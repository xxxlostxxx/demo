package com.lst.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class MobileUtil {

	private static String MOBILE_CARRIER_URL1="https://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel=";
	private static String MOBILE_CARRIER_URL2="http://life.tenpay.com/cgi-bin/mobile/MobileQueryAttribution.cgi?chgmobile=";
	private static String MOBILE_CARRIER_URL3="http://www.ip138.com:8080/search.asp?action=mobile&mobile=";

	public static String getMobileCarrier(String mobile) {
		HttpClientUtil.HttpResponse httpResponse = HttpClientUtil.executeGet(null, MOBILE_CARRIER_URL1+mobile, "utf-8");
		String reponseResult = httpResponse.getReponseResult();
		String[] split = reponseResult.split("=");
		JSONObject jsonObject = JSON.parseObject(split[1]);
		Object carrier = jsonObject.get("carrier");
		return carrier.toString();
	}
	public static String getMobileCarrier2(String mobile) {
		HttpClientUtil.HttpResponse httpResponse = HttpClientUtil.executeGet(null, MOBILE_CARRIER_URL2+mobile, "utf-8");
		System.out.println(JSON.toJSONString(httpResponse));
		String reponseResult = httpResponse.getReponseResult();
		String[] split = reponseResult.split("=");
		JSONObject jsonObject = JSON.parseObject(split[1]);
		Object carrier = jsonObject.get("carrier");
		return carrier.toString();
	}
	public static String getMobileCarrier3(String mobile) {
		HttpClientUtil.HttpResponse httpResponse = HttpClientUtil.executeGet(null, MOBILE_CARRIER_URL3+mobile, "gb2312");
		  // System.out.println(JSON.toJSONString(httpResponse));
		String reponseResult = httpResponse.getReponseResult();
		String[] split = reponseResult.split("市");
		String s = split[0];
		String substring = s.substring(s.length() - 10, s.length());
		System.out.println(substring);
		// System.out.println(split[0]);
		/*System.out.println(split[1]);*/
	/*	JSONObject jsonObject = JSON.parseObject(split[1]);
		Object carrier = jsonObject.get("carrier");
		return carrier.toString();*/
	return null;
	}

	public static void main(String[] args) {
		String mobileCarrier = getMobileCarrier3("15757124182");
		System.out.println(mobileCarrier);
	}
}

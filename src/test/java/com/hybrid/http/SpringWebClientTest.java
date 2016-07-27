package com.hybrid.http;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

public class SpringWebClientTest {

	public static void main(String[] args) {
	GET();
	System.out.println("##############");
	POST();
	}
	static void GET(){
		
		System.out.println("START SPRING...");
		RestTemplate rest = new RestTemplate();
		
		String body = rest.getForObject("http://localhost:8080Hello.jsp?name={name}&address={address}", String.class, "홍길동", "서울 마포구");
		System.out.println(body);
		
		System.out.println("END SPRING...");
	}
	static void POST(){
		System.out.println("START SPRING...");
		RestTemplate rest = new RestTemplate();
		
		LinkedMultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("name", "홍순이");
		params.add("address","부산 강서구");
		
		String body = rest.postForObject("http://localhost:8080Hello.jsp", params, String.class, "홍길동", "서울 마포구");
		System.out.println(body);
		
		System.out.println("END SPRING...");
		
	}
	

}

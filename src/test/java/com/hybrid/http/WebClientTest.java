package com.hybrid.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.Scanner;


public class WebClientTest {

	public static void main(String[] args) throws UnknownHostException, IOException {
		GET();
		System.out.println("#############################");
		POST();
	}
		
		static void POST() throws UnknownHostException, IOException{
			System.out.println("START POST..");
			
			Socket sok = new Socket("localhost", 8080);
			PrintWriter request = new PrintWriter(sok.getOutputStream());
			Scanner response = new Scanner(sok.getInputStream());
			
			/*
			 * request 전문 송신
			 */
			String body = "name=" + URLEncoder.encode("홍길동", "utf-8")
					      +"&address=" + URLEncoder.encode("서울 마포구", "utf-8");
			System.out.println("body="+body);
			System.out.println("body lenght="+body.length());
			
			request.println("POST /Hello.jsp HTTP/1.1");
			request.println("Host:localhost:8080");
			request.println("Content-Type:application/x-www-form-urlencoded");
			request.println("Content-Length:"+ body.length());
			request.println();
			request.println(body);
			request.flush();
			
			/*
			 * response 전문 수신
			 */
			while (response.hasNextLine()) {
				String line = response.nextLine();
				System.out.println(line);
				if (line.toLowerCase().lastIndexOf("</html>") != -1) {
					break;
				}
			}
			sok.close();
			
			System.out.println("END..");
		}
		
		
		static void GET() throws UnknownHostException, IOException{
		
		System.out.println("START GET...");
	
		Socket sok = new Socket("localhost", 8080); 
		InputStream in = sok.getInputStream();
		OutputStream out = sok.getOutputStream();
		
		PrintWriter request = new PrintWriter(out);
		Scanner response = new Scanner(in);
		
		String name = "홍 길동";
		name = URLEncoder.encode(name);
		System.out.println("name= " + name);
		
		//request.println("GET /Hello.jsp?name="+name+"&address=seoul HTTP/1.1");
		request.println("GET /Hello.jsp?name=dfddfdfd&address=seoul HTTP/1.1");
		request.println("Host:localhost:8080");
		request.println();
		request.println();
		request.flush();
		
		/*
		 * response 전문 수신
		 */
		while(response.hasNextLine()) {
			String line = response.nextLine();
			System.out.println(line);
			if (line.toLowerCase().lastIndexOf("</html>") != -1) {
				break;
			}
		}
		sok.close();
		
		System.out.println("END...");
		}
	

}

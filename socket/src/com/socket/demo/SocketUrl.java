package com.socket.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class SocketUrl {

	public static void main(String[] args) {
//		try {
//			URL imooc = new URL("http://www.imooc.com");
//			URL url = new URL(imooc,"/index.html?username=tom#test");
//			
//			System.out.println("协议："+url.getProtocol());
//			System.out.println("host: "+url.getHost());
//			System.out.println("port： "+url.getPort());
//			System.out.println("path: "+url.getPath());
//			System.out.println("  "+url.getUserInfo()+" "+url.getFile());
//		} catch (MalformedURLException e) {
//			// TODO 自动生成的 catch 块
//			e.printStackTrace();
//		}
		
		URL url;
		try {
			url = new URL("http://www.baidu.com");
			//字节输入流
			InputStream is = url.openStream();
			//字节输入流转成字符输入流
			InputStreamReader isr = new InputStreamReader(is);
			//字符输入流。。缓冲
			BufferedReader br = new BufferedReader(isr);
			String data = br.readLine();
			while(data!=null){
				System.out.println(data);
				data = br.readLine();
			}
			br.close();
			isr.close();
			is.close();
		} catch (MalformedURLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}

}

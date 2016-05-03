package com.socketdemo.message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args){
		try {
			Socket socket = new Socket("localhost",8888);
			//输出流
			OutputStream os = socket.getOutputStream();
			//输出流转成打印流
			PrintWriter pw = new PrintWriter(os);
			pw.write("username:admin;password:123");
//			pw.write("username:Tom;password:456");
			pw.flush();
			
			socket.shutdownOutput();
			
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			String info = null;
			while((info=br.readLine())!=null){
				System.out.println("我是客户端 ，服务器说："+info);
			}
			
			br.close();
			isr.close();
			is.close();
			
			pw.close();
			os.close();
			socket.close();
			
		} catch (UnknownHostException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}

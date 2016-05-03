package com.socketdemo.message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread extends Thread {
	
	Socket socket = null;
	
	public ServerThread(Socket socket){
		this.socket = socket;
	}
	
	public void run(){
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		OutputStream os = null;
		PrintWriter pw = null;
		
		try {
			
			is = socket.getInputStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			
			String info = null;
			
			while((info=br.readLine())!=null){
				System.out.println("我是服务器，客户端说： "+info);
			}
			socket.shutdownInput();
			
			//输出流
			os = socket.getOutputStream();
			//打印流
			pw = new PrintWriter(os);
			pw.write("您好!欢迎你");
			pw.flush();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally{
			try {
				if(pw!=null){
					pw.close();
				}
				if(os!=null){
					os.close();
				}
				if(br!=null){
					br.close();
				}
				if(isr!=null){
					isr.close();
				}
				if(is!=null){
					is.close();
				}
				if(socket!=null){
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

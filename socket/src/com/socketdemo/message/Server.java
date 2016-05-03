package com.socketdemo.message;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * 服务器端
 *
 */
public class Server {
	public static void main(String[] args){
		int count = 0;
		try {
			ServerSocket serverSocket = new ServerSocket(8888);
			System.out.println("******服务器即将启动，wait客户端的连接*******");
			
			while(true){
				Socket socket = serverSocket.accept();
				ServerThread serverThread = new ServerThread(socket);
				serverThread.start();
				
				count++;
				System.out.println("客户端的连接数量： "+count);
				InetAddress address = socket.getInetAddress();
				System.out.println("客户端的IP: "+address.getHostAddress());
				System.out.println("客户端的Name: "+address.getHostName());
			}
			
			/*
			 * 转到ServerThread中
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			String info = null;
			
			while((info=br.readLine())!=null){
				System.out.println("我是服务器，客户端说： "+info);
			}
			socket.shutdownInput();
			
			//输出流
			OutputStream os = socket.getOutputStream();
			//打印流
			PrintWriter pw = new PrintWriter(os);
			pw.write("您好!欢迎你");
			pw.flush();
			
			pw.close();
			os.close();
			
			br.close();
			isr.close();
			is.close();
			socket.close();
			*/
//			serverSocket.close();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
}

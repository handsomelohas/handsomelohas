package com.datagrampacket.demo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServerThread extends Thread {
	
	private DatagramSocket socket = null;
	
	public ServerThread(DatagramSocket socket){
		this.socket = socket;
	}
	
	public void run(){
		
		byte[] data = new byte[1024];
		
		DatagramPacket packet = new DatagramPacket(data, data.length);
		
		try {
			socket.receive(packet);
			String info = new String(data, 0, packet.getLength());
			
			System.out.println("我是服务器，客户端说: "+info);
			
			//向客户端发送请求
			InetAddress address = packet.getAddress();
			
			int port = packet.getPort();
			
			byte[] data2 = "您好，欢迎你".getBytes();
			
			DatagramPacket packet2 = new DatagramPacket(data2, data2.length, address, port);
			
			DatagramSocket socket2 = new DatagramSocket();
			
			socket2.send(packet2);
			
			socket.close();
			
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		
		
	}
	
	
}

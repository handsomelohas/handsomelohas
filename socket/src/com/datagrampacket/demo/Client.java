package com.datagrampacket.demo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {

	public static void main(String[] args) throws IOException {
		
		//向服务器发送请求
		InetAddress address = InetAddress.getByName("localhost");
		
		int port = 8800;
		byte[] data = "username:admin;password:123".getBytes();
		
		DatagramPacket packet = new DatagramPacket(data, data.length, address, port);
		
		DatagramSocket socket = new DatagramSocket();
		
		System.out.println("Client start");
		
		socket.send(packet);
		
		//响应服务器
		byte[] data2 = new byte[1024];
		
		DatagramPacket packet2 = new DatagramPacket(data2, data2.length);
		
		socket.receive(packet2);
		
		String reply = new String(data2, 0, packet2.getLength());
		
		System.out.println("我是客户端，服务器说: "+reply);
		
		socket.close();

	}

}

package com.socket.demo;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class SocketTest {

	public static void main(String[] args) throws UnknownHostException {
		InetAddress address = InetAddress.getLocalHost();
		
		System.out.println("计算名： "+address.getHostName());
		System.out.println("IP: "+address.getHostAddress());
		byte[] bytes = address.getAddress();
		System.out.println("byte IP "+Arrays.toString(bytes));
		System.out.println(address);
		System.out.println("********************************");
		//根据计算机的名称获取
		InetAddress address2 = InetAddress.getByName("LS--20150814FHM");
		System.out.println("计算名： "+address2.getHostName());
		System.out.println("IP: "+address2.getHostAddress());
		System.out.println("********************************");
		//根据计算机的IP获取
		InetAddress address3 = InetAddress.getByName("10.10.10.133");
		System.out.println("计算名： "+address3.getHostName());
		System.out.println("IP: "+address3.getHostAddress());
		
	}

}

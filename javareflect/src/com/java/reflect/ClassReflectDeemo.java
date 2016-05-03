package com.java.reflect;

public class ClassReflectDeemo {
	public static void main(String[] args){
		
		Class c1 = int.class;
		Class c2 = double.class;
		Class c3 = Double.class;
		Class c4 = void.class;
		Class c5 = String.class;
		
		System.out.println("int: "+c1.getName());
		System.out.println("double: "+c2.getName());
		System.out.println("Double: "+c3.getName());
		System.out.println("void: "+c4.getName());
		System.out.println("String: "+c5.getName());
		
		System.out.println("int: "+c3.getSimpleName());
	}
}

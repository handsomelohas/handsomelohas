package com.java.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassUtil {
	
	public static void printClassMethodMessage(Object obj){
		Class c = obj.getClass();
		System.out.println("类的名称是："+c.getName());
		
		Method[] ms = c.getMethods();
		for(int i = 0; i < ms.length; i++){
			Class returnType = ms[i].getReturnType();
			System.out.println(returnType.getName());
			System.out.println(ms[i].getName()+"(");
			Class[] paramType = ms[i].getParameterTypes();
					for(Class class1 : paramType){
						System.out.println(class1.getName()+",");
					}
					System.out.println(")");
		}
		
	}
	
	public static void printFieldMessage(Object obj){
		Class c = obj.getClass();
		Field[] fs = c.getDeclaredFields();
		for(Field field :fs){
			Class fieldType = field.getType();
			String typeName = fieldType.getName();
			String fieldName = field.getName();
			System.out.println(typeName+" "+fieldName);
		}
	}
	
	public static void printConMessage(Object obj){
		Class c = obj.getClass();
		Constructor[] cs = c.getDeclaredConstructors();
		for (Constructor constructor : cs){
			System.out.println(constructor.getName()+"(");
			Class[] paramType = constructor.getParameterTypes();
			for (Class class1 : paramType){
				System.out.println(class1.getName()+",");
			}
			System.out.println(")");
		}
		
	}
	
}

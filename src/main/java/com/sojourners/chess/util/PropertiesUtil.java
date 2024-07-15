//package com.sojourners.chess.util;
//
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.util.Enumeration;
//import java.util.Properties;
//
///**
// * 
// */
//public class PropertiesUtil
//{
//	public void getPropertiesReader()
//	{
//		Properties properties = new Properties();// 获取Properties实例
//		InputStream inStream = getClass().getResourceAsStream("config.properties");// 获取配置文件输入流
//		try
//		{
//			properties.load(inStream);// 载入输入流
//			Enumeration enumeration = properties.propertyNames();// 取得配置文件里所有的key值
//			while (enumeration.hasMoreElements())
//			{
//				String key = (String) enumeration.nextElement();
//				System.out.println("配置文件里的key值：" + key + "=====>配置文件里的value值：" + properties.getProperty(key));// 输出key值
//			}
//
//		}
//		catch (IOException e)
//		{
//			e.printStackTrace();
//		}
//	}
//
//	// 写入资源文件信息
//	public void writeProperties()
//	{
//		Properties properties = new Properties();
//		try
//		{
//			OutputStream outputStream = new FileOutputStream("config.properties");
//			properties.setProperty("number", "2015");
//			properties.setProperty("song", "手写的从前");
//			properties.store(outputStream, "rabbit");
//			outputStream.close();
//		}
//		catch (FileNotFoundException e)
//		{
//			e.printStackTrace();
//		}
//		catch (IOException e)
//		{
//			e.printStackTrace();
//		}
//	}
//
//	/**
//	 * 测试类
//	 */
//	public static void main(String[] args)
//	{
//		PropertiesReader propertiesReader = new PropertiesReader();
//		propertiesReader.getPropertiesReader();
//	}
//
//}

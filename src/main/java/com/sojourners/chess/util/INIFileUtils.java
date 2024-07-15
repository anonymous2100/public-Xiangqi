//package com.sojourners.chess.util;
//
//import java.io.File;
//import java.io.IOException;
//import java.lang.reflect.Field;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Map;
//
//import org.ini4j.Ini;
//import org.ini4j.Profile.Section;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
///**
// * 
// */
//public class INIFileUtils
//{
//	@Data
//	@AllArgsConstructor
//	@NoArgsConstructor
//	public class IniFileEntity
//	{
//		private String section;
//		private String key;
//		private String value;
//	}
//
//	public static boolean creatIniFile(String filePath, List<IniFileEntity> filecontent) throws IOException
//	{
//		File file = new File(filePath);
//		if (file.exists())
//		{
//			return false;
//		}
//		file.createNewFile();
//		Ini ini = new Ini();
//		ini.load(file);
//		// 将文件内容保存到ini对象中
//		filecontent.stream().forEach((entity) -> {
//			ini.add(entity.getSection(), entity.getKey(), entity.getValue() == null ? "" : entity.getValue());
//		});
//		// 将文件内容保存到文件中
//		ini.store(file);
//		return true;
//	}
//
//	/**
//	 * 读取ini文件的内容
//	 * 
//	 * @param iniFile ini文件
//	 * @param fileContent ini文件中的key对应文件中的section，value对应i你文件section下的一个或多个key值
//	 * @return
//	 * @throws IOException
//	 * @throws NoSuchFieldException
//	 * @throws IllegalAccessException
//	 */
//	public static Object readIniFile(File iniFile, Map<String, List<String>> fileContent, Object object)
//			throws IOException, NoSuchFieldException, IllegalAccessException
//	{
//		Ini ini = new Ini();
//		ini.load(iniFile);
//		Section section = null;
//		Field field = null;
//		for (String key : fileContent.keySet())
//		{
//			section = ini.get(key);
//			for (String value : fileContent.get(key))
//			{
//				field = object.getClass().getDeclaredField(value);
//				field.setAccessible(true);
//				field.set(object, section.get(value));
//			}
//		}
//		return object;
//	}
//
//	public static void main(String[] args) throws IOException
//	{
//		List<IniFileEntity> list = Arrays.asList(new IniFileEntity("ldap", "ip", "1.1.1.1"),
//				new IniFileEntity("ldap", "ipPort", "8567"), new IniFileEntity("test", "isUsed", "true"));
//		System.out.println(creatIniFile("D:\\abc\\test.ini", list));
//	}
//}

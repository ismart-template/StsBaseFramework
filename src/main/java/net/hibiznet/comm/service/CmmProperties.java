package net.hibiznet.comm.service;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.hibiznet.comm.WebUtil;
import net.hibiznet.comm.util.StringUtil;

/**
 *  Class Name : CmmProperties.java
 *  Description : properties������ ���Ϸκ��� �о��   GlobalsŬ������ ���������� �ε�����ִ� Ŭ������
 *   ���ڿ� ���� �������� ����� ���������� �ý��� ��������� �ݿ��� �� �ֵ��� �Ѵ�.
 *  Modification Information
 *
 *   ������              ������          ��������
 *   ----------  --------  ---------------------------
 *   2009.01.19  ������          ���� ����
 *	 2011.07.20    ���ؽ� 	   Globals������ ����θ� ���� �޼��� �߰�
 *	 2014.10.13    �̱��� 	   Globals.properties ���� null�� ��� ����ó��
 *   2019.04.26    �ſ�ȣ 	   RELATIVE_PATH_PREFIX Path ���� ��� ����
 *   2022.01.21    ����ȣ 	   Try-catch-resource ��ġ �� Method Refactoring
 *
 *  @author ���� ���� ������ ������
 *  @since 2009. 01. 19
 *  @version 1.0
 *  @see
 *
 */
public class CmmProperties {

	private static final Logger LOGGER = LoggerFactory.getLogger(CmmProperties.class);

	//���ϱ�����
	final static String FILE_SEPARATOR = System.getProperty("file.separator");

	//������Ƽ ������ ������ ��ġ
	//public static final String GLOBALS_PROPERTIES_FILE = System.getProperty("user.home") + FILE_SEPARATOR + "egovProps" +FILE_SEPARATOR + "globals.properties";

	public static final String RELATIVE_PATH_PREFIX = CmmProperties.class.getResource("") == null ? ""
		: CmmProperties.class.getResource("").getPath().substring(0,
			CmmProperties.class.getResource("").getPath().lastIndexOf("com"));
	//public static final String RELATIVE_PATH_PREFIX = CmmProperties.class.getProtectionDomain().getCodeSource().getLocation().getPath().substring(0,CmmProperties.class.getProtectionDomain().getCodeSource().getLocation().getPath().indexOf("WEB-INF/classes/")+"WEB-INF/classes/".length())+"egovframework/";

	public static final String GLOBALS_PROPERTIES_FILE = RELATIVE_PATH_PREFIX + "egovProps" + FILE_SEPARATOR
		+ "globals.properties";

	/**
	 * ���ڷ� �־��� ���ڿ��� Key������ �ϴ� ������Ƽ ���� ��ȯ�Ѵ�(Globals.java ����)
	 * @param keyName String
	 * @return String
	 */
	public static String getProperty(String keyName) {
		LOGGER.debug("===>>> getProperty" + CmmProperties.class.getProtectionDomain().getCodeSource() == null ? ""
			: StringUtil
				.isNullToString(CmmProperties.class.getProtectionDomain().getCodeSource().getLocation().getPath()));
		LOGGER.debug("getProperty : {} = {}", GLOBALS_PROPERTIES_FILE, keyName);

		return getPropertyValueByKey(keyName);
	}

	/**
	 * ���ڷ� �־��� ���ڿ��� Key������ �ϴ� ����� ������Ƽ ���� �����η� ��ȯ�Ѵ�(Globals.java ����)
	 * @param keyName String
	 * @return String
	 */
	public static String getPathProperty(String keyName) {
		LOGGER.debug("getPathProperty : {} = {}", GLOBALS_PROPERTIES_FILE, keyName);

		return RELATIVE_PATH_PREFIX + "egovProps" + FILE_SEPARATOR + getProperty(keyName);
	}

	/**
	 * �־��� ���Ͽ��� ���ڷ� �־��� ���ڿ��� Key������ �ϴ� ������Ƽ ���� ��ȯ�Ѵ�
	 * @param fileName String
	 * @param key String
	 * @return String
	 */
	public static String getProperty(String fileName, String keyName) {
		return getPropertyValueByKey(fileName, keyName);
	}

	/**
	 * �־��� ���Ͽ��� ���ڷ� �־��� ���ڿ��� Key������ �ϴ� ������Ƽ ��� ��ΰ��� ���� ��ΰ����� ��ȯ�Ѵ�
	 * @param fileName String
	 * @param key String
	 * @return String
	 */
	public static String getPathProperty(String fileName, String keyName) {
		return RELATIVE_PATH_PREFIX + "egovProps" + FILE_SEPARATOR + getProperty(fileName, keyName);
	}

	/**
	 * �־��� ���������� ������ �Ľ��Ͽ� (key-value) ������ ����ü �迭�� ��ȯ�Ѵ�.
	 * @param property String
	 * @return ArrayList
	 */
	public static ArrayList<Map<String, String>> loadPropertyFile(String property) {

		// key - value ���·� �� �迭 ���
		ArrayList<Map<String, String>> keyList = new ArrayList<Map<String, String>>();

		String src = property.replace('\\', File.separatorChar).replace('/', File.separatorChar);

		if (Files.exists(Paths.get(WebUtil.filePathBlackList(src)))) { //2022.01 Potential Path Traversal
			Properties props = loadPropertiesFromFile(src);

			Enumeration<?> plist = props.propertyNames();
			if (plist != null) {
				while (plist.hasMoreElements()) {
					Map<String, String> map = new HashMap<String, String>();
					String key = (String)plist.nextElement();
					map.put(key, props.getProperty(key));
					keyList.add(map);
				}
			}
		}

		return keyList;
	}

	/**
	 * �⺻ Property ���� Property Key�� Property value �޾ƿ´�.
	 * @param keyName
	 * @return
	 */
	public static String getPropertyValueByKey(String keyName) {
		return getPropertyValueByKey(GLOBALS_PROPERTIES_FILE, keyName);
	}

	/**
	 * Property ������ �����Ͽ� Property Key�� Property value �޾ƿ´�.
	 * @param fileName
	 * @param keyName
	 * @return
	 */
	public static String getPropertyValueByKey(String fileName, String keyName) {
		String propertyValue = "";
		Properties props = loadPropertiesFromFile(fileName);

		if (props.containsKey(keyName)) {
			propertyValue = props.getProperty(keyName).trim();
		}

		return propertyValue;
	}

	/**
	 * Property �����н��� Properties ��ü�� �����Ѵ�.
	 * @param fileName
	 * @return
	 */
	private static Properties loadPropertiesFromFile(String fileName) {
		Properties props = new Properties();

		try (
			FileInputStream fis = new FileInputStream(WebUtil.filePathBlackList(fileName));
			BufferedInputStream bis = new BufferedInputStream(fis);) {
			props.load(bis);
		} catch (FileNotFoundException fne) {
			LOGGER.debug("Property file not found.", fne);
			throw new RuntimeException("Property file not found", fne);
		} catch (IOException ioe) {
			LOGGER.debug("Property file IO exception", ioe);
			throw new RuntimeException("Property file IO exception", ioe);
		}

		return props;
	}
}


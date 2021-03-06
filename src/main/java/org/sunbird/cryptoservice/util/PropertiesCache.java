package org.sunbird.cryptoservice.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesCache {
	private final String fileName = "configuration.properties";
	private final Properties configProp = new Properties();

	/** private default constructor */
	private PropertiesCache() {
		InputStream in = this.getClass().getClassLoader().getResourceAsStream(fileName);
		try {
			configProp.load(in);
		} catch (IOException e) {
		}
	}

	private static class LazyHolder {
		private static final PropertiesCache INSTANCE = new PropertiesCache();
	}

	public static PropertiesCache getInstance() {
		return LazyHolder.INSTANCE;
	}

	/**
	 * Method to read value from resource file and if key not found then by default
	 * return key values itself.
	 *
	 * @param key
	 * @return
	 */
	public String getProperty(String key) {
		return configProp.getProperty(key) != null ? configProp.getProperty(key) : null;
	}

	/**
	 * Method to read value from resource file .
	 *
	 * @param key
	 * @return
	 */
	public String readProperty(String key) {
		return configProp.getProperty(key);
	}

}
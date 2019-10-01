/**
 * 
 */
package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author hangkala
 *
 */
public class PropertyFile {
	public static String readProperty(String propName) {
		Properties properties = new Properties();
		FileInputStream in = null;
		String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		String configPath = rootPath + "config.properties";
		try {
			in = new FileInputStream(configPath);
			properties.load(in);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(in != null) {
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return (String) properties.get(propName);
	}
}

package com.game.configuration;

import java.awt.Dimension;
import java.awt.Toolkit;


public class RuntimeConfiguration {
	
	private static RuntimeConfiguration _instance = null;

	public int screenWidth;
	public int screenHeight;
	public String workingDir;
	private RuntimeConfiguration() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		screenWidth = (int) screenSize.getWidth();
		screenHeight = (int) screenSize.getHeight();
		
		workingDir = System.getProperty("user.dir");
	}
	
	public static RuntimeConfiguration getRuntimeConfiguration() {
		if (_instance != null)
			return _instance;
		
		_instance = new RuntimeConfiguration();
		
		return _instance;
	}
	
}

package com.ryum.accountbook;

import java.awt.Desktop;
import java.net.URI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main Class
 * @author crpark
 */
@SpringBootApplication
public class Main {

  public static String URL = "http://127.0.0.1:8080/";
  public static String env;

	public static void main(String[] args) {
	  env = System.getProperty("spring.profiles.active");
	  if (null == env) {
	    env = "dev";
	    System.setProperty("spring.profiles.active", env);
	  }
	  
		try {
			SpringApplication.run(Main.class, args);
		} catch (Exception e) {
			System.out.println("The program is already running or conflicts with another program.");
		}
		
		if (env.equals("prod")) {
		  visitUrl(URL);
		  System.out.println("Please visit " + URL);
		}
	}

	/**
	 * URL 방문
	 * @param url
	 */
	public static void visitUrl(String url) {
	  try {
	    if (Desktop.isDesktopSupported()) {
	      Desktop.getDesktop().browse(new URI(url));
	    } else {
	      Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
	    }
	  } catch (Exception e) {
	    e.printStackTrace();
	  }
	}
}

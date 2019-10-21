package com.ryum.accountbook;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main Class
 * @author crpark
 */
@SpringBootApplication
public class Main {

	private static String URL = "http://127.0.0.1:8080/";
	
	public static void main(String[] args) {
		try {
			SpringApplication.run(Main.class, args);
		} catch (Exception e) {
			System.out.println("The program is already running or conflicts with another program.");
		} finally {
			visitUrl(URL);
			System.out.println("Please visit " + URL);
		}
	}

	/**
	 * URL 방문
	 * @param url
	 */
	public static void visitUrl(String url) {
		if (Desktop.isDesktopSupported()) {
			Desktop desktop = Desktop.getDesktop();
			try {
				desktop.browse(new URI(url));
			} catch (IOException | URISyntaxException e) {
				e.printStackTrace();
			}
		} else {
			Runtime runtime = Runtime.getRuntime();
			try {
				runtime.exec("rundll32 url.dll,FileProtocolHandler " + url);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

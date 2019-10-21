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

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
		visitUrl("http://127.0.0.1:8080");
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

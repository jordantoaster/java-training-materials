package networking.http;

import java.io.*;
import java.net.*;


public class LoadingViaURL {

	public static void main(String[] args) throws IOException {

		//System.getProperties().put("proxySet","true");
		//System.getProperties().put("proxyHost","192.168.101.253");
		//System.getProperties().put("proxyPort","8080");

		URL url = new URL("http://www.java.sun.com/index.html");

		InputStream is = url.openStream();
		BufferedReader input = new BufferedReader(new InputStreamReader(is));

		String currentLine;
		while((currentLine = input.readLine()) != null) {
			System.out.println(currentLine);
		}
	}
}

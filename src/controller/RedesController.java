package controller;

import java.io.IOException;

public class RedesController {
	public RedesController() {
		super();
	}
	
	private String getOS() {
		return System.getProperty("os.name");
	}
	
	public void ip() {
		if(getOS().contains("Windows")) {
			try {
				Process p = Runtime.getRuntime().exec("");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			
		}
	}
	
	public void ping() {
		
	}
}

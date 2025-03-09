package view;

import controller.RedesController;

public class Principal {
	public static void main(String[] args) {
		RedesController control = new RedesController();
		
		control.ip();
		control.ping();
	}
}

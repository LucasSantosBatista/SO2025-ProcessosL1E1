package view;

import javax.swing.JOptionPane;

import controller.RedesController;

public class Principal {
	public static void main(String[] args) {
		RedesController control = new RedesController();

		while (true) {
			String[] options = { "IP", "Ping", "Sair" };
			int opt = JOptionPane.showOptionDialog(null, "Escolha um processo para executar: ", "Chamada de Processos",
					JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

			switch (opt) {
			case 0: 
				control.ip();
				break;
			case 1: 
				control.ping();
				break;
			case 2: 
				System.exit(0);
				break;
			}
		}
	}
}

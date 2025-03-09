package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RedesController {
	public RedesController() {
		super();
	}

	// Retorna sistema operacional
	private String getOS() {
		return System.getProperty("os.name");
	}

	public void ip() {
		// Inicia buffer para a escrita do processo
		String process = "";
		StringBuffer buffer = new StringBuffer();
		

		// Valida sistema operacional
		if (getOS().contains("Windows")) {
			buffer.append("cmd /c ");
			process = "ipconfig";
			buffer.append(process);

		} else {
			process = "ip addr";
			buffer.append(process);
		}

		// Utiliza buffer.toString().split() para converter em String e vetor
		try {
			Process p = Runtime.getRuntime().exec(buffer.toString().split(" "));
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

			String line = "";
			
			if (getOS().contains("Windows")) { // No Windows: exibe ipv4 e adaptador
				while ((line = reader.readLine()) != null) {
					if (line.contains("IPv4") || line.contains("Adaptador"))
						System.out.println(line + "\n");
				}
			} else { // No Linux: exibe número do adaptador e inet(ipv4)
				while ((line = reader.readLine()) != null) {
					if (line.contains("1:") || line.contains("2:") || line.contains("inet "))
						System.out.println(line);
				}
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

	public void ping() {
		// Inicia buffer para a escrita do processo
				String process = "";
				StringBuffer buffer = new StringBuffer();
				

				// Valida sistema operacional
				if (getOS().contains("Windows")) {
					buffer.append("cmd /c ");
					process = "ping -4 -n 10 www.google.com.br";
					buffer.append(process);

				} else {
					process = "ping -4 -c 10 www.google.com.br";
					buffer.append(process);
				}

				// Utiliza buffer.toString().split() para converter em String e vetor
				try {
					Process p = Runtime.getRuntime().exec(buffer.toString().split(" "));
					BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

					String line = "";
					
					while ((line = reader.readLine()) != null) {
						if (line.contains("google") || line.contains("dia") || line.contains("avg"))
							System.out.println(line);
					}
				} catch (IOException e) {
					System.err.println(e.getMessage());
				}
	}
}

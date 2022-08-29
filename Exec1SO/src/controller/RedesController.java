package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {

	public RedesController() {
		super();
	}

	private String os() {
		String os = System.getProperty("os.name");
		return os;
	}

	public void ip(String processo) {
		String so = os();
		if (so.contains("Windows")) {
			try {
				Process p = Runtime.getRuntime().exec(processo);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				
				String line = buffer.readLine();
				String titulo = "";
				while (line != null) {
					
					if(line.contains("Adaptador")) {
						titulo = line;
					}
					if (line.contains("IPv4")) {
						System.out.println(titulo);
						System.out.println(line);
					}
					line = buffer.readLine();
				}
				buffer.close();
				leitor.close();
				fluxo.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			} 
				
			} if (so.contains("Linux"));{
				processo = "ifconfig";
				try {
					Process p = Runtime.getRuntime().exec(processo);
					InputStream fluxo = p.getInputStream();
					InputStreamReader leitor = new InputStreamReader(fluxo);
					BufferedReader buffer = new BufferedReader(leitor);
					
					String line = buffer.readLine();
					String titulo = "";
					while (line != null) {
						
						if(line.contains("Adaptador")) {
							titulo = line;
						}
						if (line.contains("IPv4")) {
							System.out.println(titulo);
							System.out.println(line);
						}
						line = buffer.readLine();
					}
					buffer.close();
					leitor.close();
					fluxo.close();
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
	}
	


	public void ping (String pong) {
		String so = os();
		if (so.contains("Windows")) {
			try {
				Process p = Runtime.getRuntime().exec(pong);
			
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
			
				String line = buffer.readLine();
				while (line != null) {
					if(line.contains("Aproximar")) {
						line = buffer.readLine();
						String [] linha = line.split(",");
						System.out.println(linha[2]);
					}
					line = buffer.readLine();
				}
				buffer.close();
				leitor.close();
				fluxo.close();
			
			} catch(IOException e) {
				e.printStackTrace();
			} 		
		} if (so.contains("Linux")) {
			pong = "PING -4 -c 10 www.google.com.br";
			try {
				Process p = Runtime.getRuntime().exec(pong);
			
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
			
				String line = buffer.readLine();
				while (line != null) {
					if(line.contains("pacotes")) {
						line = buffer.readLine();
						String [] linha = line.split("/");
						System.out.println(linha[5]);
					}
					line = buffer.readLine();
				}
				buffer.close();
				leitor.close();
				fluxo.close();
			
			} catch(IOException e) {
				e.printStackTrace();
			} 
		}
	}	
}


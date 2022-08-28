package view;

import javax.swing.JOptionPane;
import controller.RedesController;


public class Main {

	public static void main(String[] args) {
		RedesController processControl = new RedesController();
		
		String so = processControl.os();
		System.out.println(so);
		String processo = "IPCONFIG";
		String pong =  "PING -4 -n 10 www.google.com.br";
		
		int opc = 0;
		while (opc != 9) {
			opc = Integer.parseInt(JOptionPane.showInputDialog("Sistema de Processos \n1-Metodo Ip\n2-Metodo Ping \n9-Finaliza"));
			
			switch (opc){
				case 1: 
					processControl.ip(so, processo);
					break;
				case 2: 
					processControl.ping(pong, so);
					break;
				case 9: 
					JOptionPane.showMessageDialog(null, "Programa Finalizado");
					break;
				default: JOptionPane.showMessageDialog(null, "Opção invalida");
			}
				
		}
	}

}

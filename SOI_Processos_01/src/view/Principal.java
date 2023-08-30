package view;

import javax.swing.JOptionPane;

import controller.RedesController;

public class Principal {

	public static void main(String[] args) {
		RedesController rc = new RedesController();
		int c = 0;
		
		do {
			c = Integer.parseInt(JOptionPane.showInputDialog("Digite 1 para descobrir o seu IP. Digite 2 para descobrir o seu ping. Digite 9 para sair"));
			switch(c) {
			case 1:
				rc.ip_teste();
				break;
			case 2:
				rc.ping_teste();
				break;
			case 9:
				JOptionPane.showMessageDialog(null,"Encerrando");
				break;
			default:
				JOptionPane.showMessageDialog(null,"Opção Inválida");
			}
			
		}while(c != 9);

	}

}

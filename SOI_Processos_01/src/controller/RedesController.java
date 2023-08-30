package controller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {

	public RedesController() {
		super();
	}
	

		
	private String SO_teste () {
		String os  = System.getProperty("os.name");
		return os;
	}

	public void ip_teste() {
		String SO = SO_teste();
		String adaptador;
		System.out.println(SO);
		
		if (SO.contains("Windows ") ) {
			try {
				Process p = Runtime.getRuntime().exec("ipconfig");
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				
					while(linha != null) {
						if(linha.contains("*")) {
						}else{
							if(linha.contains("Adaptador Ethernet Ethernet:")){
						}else {
							if(linha.contains("Adaptador")) {
								String[]vlinha = linha.split(": ");
								adaptador = vlinha[0];
								System.out.println(adaptador);
								String ipv4 = " ";
								do {
									linha = buffer.readLine();
									if(linha.contains("IPv4")) {
										String[]vlinha2 = linha.split(" : ");
										ipv4 = vlinha2[1];
									}
									}while(ipv4 == " ");
								System.out.println(ipv4);
							}
						}	
					}
				linha = buffer.readLine();	
				}
						
					buffer.close();
					leitor.close();
					fluxo.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public void ping_teste() {
		String OS = SO_teste();
		String ping = "";
		
		if(OS.contains("Windows ")) {
			try {
				Process p = Runtime.getRuntime().exec("ping -4 -n 10 www.google.com.br");
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				
				while(linha != null) {
					if(linha.contains("dia")) {
						String[]vlinha = linha.split("= ");
						ping = vlinha[3];
					}
			linha = buffer.readLine();	
			}
				System.out.println("O tempo médio por ping é "+ping);
				buffer.close();
				leitor.close();
				fluxo.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
}


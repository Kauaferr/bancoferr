package bancoferr;
 import java.util.Scanner;
import java.util.Random;

public class interfaceUso {

	public static void main(String[] args) {
		
		
		
		
		
		Scanner scan = new Scanner ( System.in);
		Scanner senha = new Scanner(System.in);
		Scanner r1 = new Scanner(System.in);                             
		Random 	n1 = new Random();
		Scanner nome = new Scanner(System.in);
		Scanner cpf = new Scanner(System.in);
		Scanner novoNome = new Scanner(System.in);
		
		
		
		System.out.println("-----------------------------------------");
		System.out.println("QUAL CONTA VOC� DESEJA CRIAR?");
		System.out.println("1 - CONTA CORRENTE");
		System.out.println("2 - CONTA POUPAN�A");
		System.out.println("-----------------------------------------");

		int resposta0 = scan.nextInt();
		
		if (resposta0 == 1) {
			System.out.println("-----------------------------------------");

			System.out.println("DIGITE O SEU NOME e CPF, NESSA ORDEM!!");
			
			Cliente Titular = new Cliente ( nome.nextLine() , cpf.nextLine());
			System.out.println("-----------------------------------------");

			boolean validaNome = Titular.NumerosnoNome(Titular.getNome());
			boolean validaNomeeCpf = Titular.validaNomeeCpf();
			
			if (validaNome == true && validaNomeeCpf == true ) { 
				
			System.out.println("-----------------------------------------");
	
			contaCorrente contaCorrente1 = new contaCorrente ( n1.nextInt(4000), n1.nextInt(4000));
			
			contaCorrente1.setTitular(Titular); 
			
			System.out.println("-----------------------------------------");

				
			System.out.println("O N�MERO DA SUA CONTA �: " + contaCorrente1.getNumero());
			System.out.println("O N�MERO DA SUA AG�NCIA �: " + contaCorrente1.getAgencia());
			System.out.println("O TITULAR DA CONTA �: " + contaCorrente1.getTitular().getNome());
			System.out.println("O CPF INFORMADO �: " + Titular.getCpf());
			
			System.out.println("-----------------------------------------");

		
		
		
			System.out.println("DIGITE O N�MERO DA SUA AG�NCIA E O N�MERO DA SUA CONTA ");
			System.out.println("AG�NCIA: ");
			boolean validaAgencia = contaCorrente1.validaAgencia(scan.nextInt());
			System.out.println("N�MERO: ");
			boolean validaNumero = contaCorrente1.validaNumero(scan.nextInt());
			
			System.out.println("-----------------------------------------");

			
		if ( validaAgencia == true && validaNumero == true ) {
			
			System.out.println("CRIE UMA SENHA PARA A SUA CONTA: ");
		
			contaCorrente1.setSenha(senha.nextInt());
		
		
	
			System.out.println("SENHA: ");
			contaCorrente1.validaSenha(r1.nextInt());
			int cont = 10;
			
		while ( cont >= 0) {
			
			System.out.println("-----------------------------------------");
			System.out.println("O QUE VOC� DESEJA FAZER ?");
			System.out.println("1 - DEPOSITAR");
			System.out.println("2 - SACAR");
			System.out.println("3 - TRANSFERIR");
			System.out.println("4 - MUDAR SENHA");
			System.out.println("5 - MUDAR NOME DO TITULAR");
			System.out.println("6 - CANCELAR OPERA��O");
			System.out.println("7 - CONSULTAR SALDO");
			System.out.println("VOC� POSSUI: " + cont-- + " OPERA��ES RESTANTES");

			System.out.println("-----------------------------------------");

			int  resposta = scan.nextInt();
		
		switch(resposta){
		
			case 1: 
			System.out.println("QUANTO VOC� DESEJA DEPOSITAR?:");
			contaCorrente1.depositar(scan.nextDouble());
			contaCorrente1.cobrarTaxa();
			
		break;
		
			case 2: 
			System.out.println("QUANTO VOC� DESEJA SACAR?:");
			boolean validaSaque = contaCorrente1.sacar(scan.nextDouble());
			if ( validaSaque == true) {
			contaCorrente1.cobrarTaxa();
			}
			
		break;
			
			case 3:
				System.out.println("DIGITE O N�MERO E A AG�NCIA DA CONTA DE DESTINO?: ");
				Conta contaDestino = new contaCorrente(scan.nextInt(), scan.nextInt());
					
				int confereNumeroDestino = contaDestino.getNumero();
				int confereNumeroAgencia = contaDestino.getAgencia();
				int pegarNumeroRemetente = contaCorrente1.getNumero();
				int pegarAgenciaRemetente = contaCorrente1.getAgencia();
					
				if( confereNumeroDestino == pegarNumeroRemetente && confereNumeroAgencia == pegarAgenciaRemetente) {
					System.out.println("A CONTA DE DESTINO E CONTA REMETENTE S�O IGUAIS!! TRANSFER�NCIA IMPOSS�VEL DE SER REALIZADA");
				}
				else {
					
					System.out.println("QUANTO VOC� DESEJA TRASNFERIR?:");
					boolean validaTransferencia = contaCorrente1.transferir(r1.nextDouble(), contaDestino);
					if ( validaTransferencia == true) {
					contaCorrente1.cobrarTaxa();
					}
				}
		break;	
			
			case 4:
			System.out.println("DIGITE A SUA SENHA ATUAL: ");
			boolean validaSenha = contaCorrente1.validaSenha(scan.nextInt());
						
				if ( validaSenha == true) {
							
					System.out.println("DEGITE A SENHA QUE DESEJA CRIAR: ");
					contaCorrente1.setSenha(scan.nextInt());
					System.out.println("SENHA ALTERADA COM SUCESSO!!");
						}
		break;
						
			case 5:
			System.out.println("QUAL O NOVO NOME: ");
			Titular.setNome(novoNome.nextLine());
			System.out.println("NOME ALTERADO COM SUCESSO! ");
			System.out.println("O NOVO NOME �: " + Titular.getNome());
			
		break;
		
			case 6:
							
			System.out.println("OPERA��O CANCELADA");
			return;
						
			
		
		
			case 7:
			System.out.println("SEU SALDO �: "  + contaCorrente1.getSaldo());
									
									
		break;	
		
			case 8:
			System.out.println("SEU NOME �: " + contaCorrente1.getTitular().getNome());
		}
		}
		
		}
		else {
			System.out.println("N�MERO DA CONTA E/OU AG�NCIA INCORRETOS!!");
		}
			}
		}
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//AQUI SE FAZ A CONTA POUPAN�A 
		else {
			if ( resposta0 == 2) {
				
				System.out.println("-----------------------------------------");

				System.out.println("DIGITE O SEU NOME e CPF, NESSA ORDEM!!");
				
				Cliente Titular = new Cliente ( nome.nextLine() , cpf.nextLine());
				System.out.println("-----------------------------------------");

				boolean validaNome = Titular.NumerosnoNome(Titular.getNome());
				boolean validaNomeeCpf = Titular.validaNomeeCpf();
				
				if (validaNome == true && validaNomeeCpf == true) { 
				System.out.println("-----------------------------------------");
		
				contaPoupanca contaPoupanca1 = new contaPoupanca ( n1.nextInt(4000), n1.nextInt(4000));
				
				contaPoupanca1.setTitular(Titular); 
				
				System.out.println("-----------------------------------------");

					
				System.out.println("O N�MERO DA SUA CONTA �: " + contaPoupanca1.getNumero());
				System.out.println("O N�MERO DA SUA AG�NCIA �: " + contaPoupanca1.getAgencia());
				System.out.println("O TITULAR DA CONTA �: " + contaPoupanca1.getTitular().getNome());
				System.out.println("O CPF INFORMADO �: " + Titular.getCpf());
				
				System.out.println("-----------------------------------------");

			
			
			
				System.out.println("DIGITE O N�MERO DA SUA AG�NCIA E O N�MERO DA SUA CONTA ");
				System.out.println("AG�NCIA: ");
				boolean validaAgencia = contaPoupanca1.validaAgencia(scan.nextInt());
				System.out.println("N�MERO: ");
				boolean validaNumero = contaPoupanca1.validaNumero(scan.nextInt());
				
				System.out.println("-----------------------------------------");

				
			if ( validaAgencia == true && validaNumero == true ) {
				
				System.out.println("CRIE UMA SENHA PARA A SUA CONTA: ");
			
				contaPoupanca1.setSenha(senha.nextInt());
			
			
				System.out.println("SENHA: ");
				boolean validaSenha1 = contaPoupanca1.validaSenha(r1.nextInt());
				if( validaSenha1 == true) {
			
				int cont = 10;
		while (  cont >= 0) {
				
				System.out.println("-----------------------------------------");

				System.out.println("O QUE VOC� DESEJA FAZER ?");
				System.out.println("1 - DEPOSITAR");
				System.out.println("2 - SACAR");
				System.out.println("3 - TRANSFERIR");
				System.out.println("4 - MUDAR SENHA");
				System.out.println("5 - MUDAR NOME DO TITULAR");
				System.out.println("6 - CANCELAR OPERA��O");
				System.out.println("7 - CONSULTAR SALDO");
				System.out.println("VOC� POSSUI: " + cont-- + " OPERA��ES RESTANTES");

				System.out.println("-----------------------------------------");

				int  resposta = scan.nextInt();
			
			switch(resposta){
			
				case 1: 
				System.out.println("QUANTO VOC� DESEJA DEPOSITAR?:");
				contaPoupanca1.depositar(scan.nextDouble());
				contaPoupanca1.somarBonus();

				
			break;
			
				case 2: 
				System.out.println("QUANTO VOC� DESEJA SACAR?:");
				boolean validaBonus = contaPoupanca1.sacar(scan.nextDouble());
				if( validaBonus == true) {
				contaPoupanca1.somarBonus();
				}

				

			break;
				
				case 3:
					System.out.println("DIGITE O N�MERO E A AG�NCIA DA CONTA DE DESTINO?: ");
					Conta contaDestino = new Conta (scan.nextInt(), scan.nextInt());
						
					int confereNumeroDestino = contaDestino.getNumero();
					int confereNumeroAgencia = contaDestino.getAgencia();
					int pegarNumeroRemetente = contaPoupanca1.getNumero();
					int pegarAgenciaRemetente = contaPoupanca1.getAgencia();
						
					if( confereNumeroDestino == pegarNumeroRemetente && confereNumeroAgencia == pegarAgenciaRemetente) {
						System.out.println("A CONTA DE DESTINO E CONTA REMETENTE S�O IGUAIS!! TRANSFER�NCIA IMPOSS�VEL DE SER REALIZADA");
					}
					else {
						
						System.out.println("QUANTO VOC� DESEJA TRASNFERIR?:");
						contaPoupanca1.transferir(r1.nextDouble(), contaDestino);
						contaPoupanca1.somarBonus();


					}
			break;	
				
				case 4:
				System.out.println("DIGITE A SUA SENHA ATUAL: ");
				boolean validaSenha2 = contaPoupanca1.validaSenha(scan.nextInt());
							
					if ( validaSenha2 == true) {
								
						System.out.println("DEGITE A SENHA QUE DESEJA CRIAR: ");
						contaPoupanca1.setSenha(scan.nextInt());
						System.out.println("SENHA ALTERADA COM SUCESSO!!");
							}
			break;
							
				case 5:
				System.out.println("QUAL O NOVO NOME: ");
				Titular.setNome(novoNome.nextLine());
				System.out.println("NOME ALTERADO COM SUCESSO! ");
				System.out.println("O NOVO NOME �: " + Titular.getNome());
				
			break;
			
				case 6:
								
				System.out.println("OPERA��O CANCELADA");
				return;
							
				
			
			
				case 7:
				System.out.println("SEU SALDO �: "  + contaPoupanca1.getSaldo());
										
										
			break;	
			
			}
			}
			
				}
			}
			else {
				
				System.out.println("N�MERO DA CONTA E/OU AG�NCIA INCORRETOS!!");
			}
				}
				
			}
		}
	}
}


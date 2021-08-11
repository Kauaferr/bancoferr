package bancoferr;
 import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class interfaceUso {
	public static void main(String[] args) {
		
		
		
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//AQUI SE FAZ A CONTA CORRENTE
		
		Scanner scan = new Scanner ( System.in);
		Scanner senha = new Scanner(System.in);
		Scanner r1 = new Scanner(System.in);                             
		Random 	n1 = new Random();
		Scanner nome = new Scanner(System.in);
		Scanner cpf = new Scanner(System.in);
		Scanner novoNome = new Scanner(System.in);
		
		ArrayList<Conta> Contas = new ArrayList<Conta>();

		for (int cont4 = 0; cont4<=5; cont4++) {

			
		
		System.out.println("-----------------------------------------");
		System.out.println("QUAL CONTA VOCÊ DESEJA CRIAR?");
		System.out.println("1 - CONTA CORRENTE");
		System.out.println("2 - CONTA POUPANÇA");
		System.out.println("-----------------------------------------");

		int resposta0 = scan.nextInt();
		
		if (resposta0 == 1) {
			System.out.println("-----------------------------------------");

			System.out.println("DIGITE O SEU NOME e CPF, NESSA ORDEM!!");
			ArrayList<Cliente> Clientes = new ArrayList<Cliente>();

			Clientes.add( new Cliente ( nome.nextLine() , cpf.nextLine()));
			System.out.println(Clientes.get(0).getNome());
			System.out.println("-----------------------------------------");

			boolean validaNome = Clientes.get(0).NumerosnoNome(Clientes.get(0).getNome());
			boolean validaNomeeCpf = Clientes.get(0).validaNomeeCpf();
			
			if (validaNome == true && validaNomeeCpf == true ) { 
				
			System.out.println("-----------------------------------------");
	

			Contas.add(new contaCorrente ( n1.nextInt(4000), n1.nextInt(4000)));
			
			Contas.get(0).setTitular(Clientes.get(0)); 
			
			System.out.println("-----------------------------------------");

				
			System.out.println("O NÚMERO DA SUA CONTA É: " + Contas.get(0).getNumero());
			System.out.println("O NÚMERO DA SUA AGÊNCIA É: " + Contas.get(0).getAgencia());
			System.out.println("O TITULAR DA CONTA É: " + Contas.get(0).getTitular().getNome());
			System.out.println("O CPF INFORMADO É: " + Clientes.get(0).getCpf());
			
			System.out.println("-----------------------------------------");

		
			
			System.out.println("DIGITE O NÚMERO DA SUA AGÊNCIA E O NÚMERO DA SUA CONTA ");
			System.out.println("AGÊNCIA: ");
			boolean validaAgencia = Contas.get(0).validaAgencia(scan.nextInt());
			System.out.println("NÚMERO: ");
			boolean validaNumero = Contas.get(0).validaNumero(scan.nextInt());
			
			System.out.println("-----------------------------------------");

			
		if ( validaAgencia == true && validaNumero == true ) {
			
			System.out.println("CRIE UMA SENHA PARA A SUA CONTA: ");
		
			Contas.get(0).setSenha(senha.nextInt());
		
		
	
			System.out.println("SENHA: ");
			Contas.get(0).validaSenha(r1.nextInt());
			int cont = 10;
			
		while ( cont >= 0) {
			
			System.out.println("-----------------------------------------");
			System.out.println("O QUE VOCÊ DESEJA FAZER ?");
			System.out.println("1 - DEPOSITAR");
			System.out.println("2 - SACAR");
			System.out.println("3 - TRANSFERIR");
			System.out.println("4 - MUDAR SENHA");
			System.out.println("5 - MUDAR NOME DO TITULAR");
			System.out.println("6 - CANCELAR OPERAÇÃO");
			System.out.println("7 - CONSULTAR SALDO");
			System.out.println("VOCÊ PODE FAZER MAIS: " + cont-- + " OPERAÇÕES");

			System.out.println("-----------------------------------------");

			int  resposta = scan.nextInt();
			
			
			
//----------------------------------------------------------------------------------------------------------------
	//AQUI COMEÇA O SWITCH DA CONTA CORRENTE
		switch(resposta){
		
			case 1: 
			System.out.println("QUANTO VOCÊ DESEJA DEPOSITAR?:");
			boolean validaDeposito = Contas.get(0).depositar(scan.nextDouble());
			if (validaDeposito == true) {
				Contas.get(0).cobrarTaxa();
			}
		break;
		
			case 2: 
			System.out.println("QUANTO VOCÊ DESEJA SACAR?:");
			boolean validaSaque = Contas.get(0).sacar(scan.nextDouble());
			if ( validaSaque == true) {
				Contas.get(0).cobrarTaxa();
			}
			
		break;
			
			case 3:
				System.out.println("DIGITE O NÚMERO E A AGÊNCIA DA CONTA DE DESTINO?: ");
				Conta contaDestino = new Conta (scan.nextInt(), scan.nextInt());
					
				int confereNumeroDestino = contaDestino.getNumero();
				int confereNumeroAgencia = contaDestino.getAgencia();
				int pegarNumeroRemetente = contaDestino.getNumero();
				int pegarAgenciaRemetente = contaDestino.getAgencia();
					
				if( confereNumeroDestino == pegarNumeroRemetente && confereNumeroAgencia == pegarAgenciaRemetente) {
					System.out.println("A CONTA DE DESTINO E CONTA REMETENTE SÃO IGUAIS!! TRANSFERÊNCIA IMPOSSÍVEL DE SER REALIZADA");
				}
				else {
					
					System.out.println("QUANTO VOCÊ DESEJA TRANSFERIR?:");
					boolean validaTransferencia = Contas.get(0).transferir(r1.nextDouble(), contaDestino);
					if ( validaTransferencia == true) {
						Contas.get(0).cobrarTaxa();
					}
				}
		break;	
			
			case 4:
			System.out.println("DIGITE A SUA SENHA ATUAL: ");
			boolean validaSenha = Contas.get(0).validaSenha(scan.nextInt());
						
				if ( validaSenha == true) {
							
					System.out.println("DEGITE A SENHA QUE DESEJA CRIAR: ");
					Contas.get(0).setSenha(scan.nextInt());
					System.out.println("SENHA ALTERADA COM SUCESSO!!");
						}
		break;
						
			case 5:
			System.out.println("QUAL O NOVO NOME: ");
			Clientes.get(0).setNome(novoNome.nextLine());
			System.out.println("NOME ALTERADO COM SUCESSO! ");
			System.out.println("O NOVO NOME É: " + Clientes.get(0).getNome());
			
		break;
		
			case 6:
							
			System.out.println("OPERAÇÃO CANCELADA");
			return;
						
			
		
		
			case 7:
			System.out.println("SEU SALDO É: "  + Contas.get(0).getSaldo());
									
									
		break;	
		
			
		}
		}
		
		}
		else {
			System.out.println("NÚMERO DA CONTA E/OU AGÊNCIA INCORRETOS!!");
		}
			}

		}
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//AQUI SE FAZ A CONTA POUPANÇA
		else {
			if ( resposta0 == 2) {
				
				System.out.println("-----------------------------------------");
				ArrayList<Cliente> ClientesPoupanca = new ArrayList<Cliente>();

				System.out.println("DIGITE O SEU NOME e CPF, NESSA ORDEM!!");
				ClientesPoupanca.add(new Cliente ( nome.nextLine() , cpf.nextLine()));
				System.out.println("-----------------------------------------");

				boolean validaNome = ClientesPoupanca.get(0).NumerosnoNome(ClientesPoupanca.get(0).getNome());
				boolean validaNomeeCpf = ClientesPoupanca.get(0).validaNomeeCpf();
				
				if (validaNome == true && validaNomeeCpf == true) { 
				System.out.println("-----------------------------------------");

				Contas.add( new contaPoupanca ( n1.nextInt(4000), n1.nextInt(4000)));
				
				Contas.get(1).setTitular(ClientesPoupanca.get(0)); 
				
				System.out.println("-----------------------------------------");

					
				System.out.println("O NÚMERO DA SUA CONTA É: " + Contas.get(1).getNumero());
				System.out.println("O NÚMERO DA SUA AGÊNCIA: " + Contas.get(1).getAgencia());
				System.out.println("TITULAR DA CONTA: " + Contas.get(1).getTitular().getNome());
				System.out.println("O CPF INFORMADO É: " + Contas.get(1).getTitular().getCpf());
				
				System.out.println("-----------------------------------------");

			
			
			
				System.out.println("DIGITE O NÚMERO DA AGÊNCIA E O NÚMERO DA SUA CONTA ");
				System.out.println("AGÊNCIA: ");
				boolean validaAgencia = Contas.get(1).validaAgencia(scan.nextInt());
				System.out.println("NÚMERO: ");
				boolean validaNumero = Contas.get(1).validaNumero(scan.nextInt());
				
				System.out.println("-----------------------------------------");

				
			if ( validaAgencia == true && validaNumero == true ) {
				
				System.out.println("CRIE UMA SENHA PARA A SUA CONTA: ");
			
				Contas.get(1).setSenha(senha.nextInt());
			
			
				System.out.println("SENHA: ");
				boolean validaSenha1 = Contas.get(1).validaSenha(r1.nextInt());
				if( validaSenha1 == true) {
			
				int cont = 10;
		while (  cont >= 0) {
				
				System.out.println("-----------------------------------------");

				System.out.println("O QUE VOCÊ DESEJA FAZER ?");
				System.out.println("1 - DEPOSITAR");
				System.out.println("2 - SACAR");
				System.out.println("3 - TRANSFERIR");
				System.out.println("4 - MUDAR SENHA");
				System.out.println("5 - MUDAR NOME DO TITULAR");
				System.out.println("6 - CANCELAR OPERAÇÃO");
				System.out.println("7 - CONSULTAR SALDO");
				
				System.out.println("VOCÃŠ POODE FAZER MAIS: " + cont-- + " OPERACÕES");

				System.out.println("-----------------------------------------");

				int  resposta = scan.nextInt();

//-------------------------------------------------------------------------------------------------------------------------
// AQUI COMEÇA O SWITCH DA CONTA POUPANÇA
			switch(resposta){
			
				case 1: 
				System.out.println("QUANTO VOCÊ DESEJA DEPOSITAR?:");
				boolean validaDeposito = Contas.get(1).depositar(scan.nextDouble());
				if ( validaDeposito == true) {
					Contas.get(1).somarBonus();

				}

				
			break;
			
				case 2: 
				System.out.println("QUANTO VOCÊ DESEJA SACAR?:");
				boolean validaBonus = Contas.get(1).sacar(scan.nextDouble());
				if( validaBonus == true) {
					Contas.get(1).somarBonus();
				}

				

			break;
				
				case 3:
					System.out.println("DIGITE O NÚMERO E A AGÊNCIA DA CONTA DE DESTINO?: ");

					Conta contaDestino =  new Conta (scan.nextInt(), scan.nextInt());
						
					int confereNumeroDestino = contaDestino.getNumero();
					int confereNumeroAgencia = contaDestino.getAgencia();
					int pegarNumeroRemetente = contaDestino.getNumero();
					int pegarAgenciaRemetente = contaDestino.getAgencia();
						
					if( confereNumeroDestino == pegarNumeroRemetente && confereNumeroAgencia == pegarAgenciaRemetente) {
						System.out.println("A CONTA DE DESTINO E CONTA REMETENTE SÃO IGUAIS!! TRANSFERENCIA IMPOSSÍVEL DE SER REALIZADA");
					}
					else {
						
						System.out.println("QUANTO VOCÊ DESEJA TRANSFERIR?:");
						Contas.get(1).transferir(r1.nextDouble(), contaDestino);
						Contas.get(1).somarBonus();


					}
			break;	
				
				case 4:
				System.out.println("DIGITE A SUA SENHA ATUAL: ");
				boolean validaSenha2 = Contas.get(2).validaSenha(scan.nextInt());
							
					if ( validaSenha2 == true) {
								
						System.out.println("DEGITE A SENHA QUE DESEJA CRIAR: ");
						Contas.get(1).setSenha(scan.nextInt());
						System.out.println("SENHA ALTERADA COM SUCESSO!!");
							}
			break;
							
				case 5:
				System.out.println("QUAL O NOVO NOME: ");
				ClientesPoupanca.get(0).setNome(novoNome.nextLine());
				System.out.println("NOME ALTERADO COM SUCESSO! ");
				System.out.println("O NOVO NOME É: " + ClientesPoupanca.get(0).getNome());
				
			break;
			
				case 6:
								
				System.out.println("OPERAÇÃO CANCELADA");
				return;
							
				
			
			
				case 7:
				System.out.println("SEU SALDO É: "  + Contas.get(1).getSaldo());
										
										
			break;	
			
			}
			}
			
				}

			}
			else {
				
				System.out.println("NÚMERO DA CONTA E/OU AGÊNCIA INCORRETOS!!");
			}
				}

				
			}
		}

	}

		System.out.println("CONTAS CRIADAS: " + Contas.toString());

}
}
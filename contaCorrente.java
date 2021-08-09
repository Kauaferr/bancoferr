package bancoferr;

public class contaCorrente extends Conta {
 private double taxa = 0.02;
	
	public contaCorrente ( int numero , int agencia) {
		super(numero, agencia);
		
	}
	
	
		public void cobrarTaxa() {
			this.saldo -= this.saldo * this.taxa;
			System.out.println("FOI DESCONTADO A TAXA DE ATUAÇÃO DE 0,02% DO BANCO SOBRE CONTAS CORRENTES");
			System.out.println("SEU SALDO AGORA É: " + getSaldo() + "R$");

		}
	
	}
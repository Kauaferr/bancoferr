package bancoferr;

public class contaCorrente extends Conta implements InterfaceContas {
 private double taxa = 0.02;
 
	public contaCorrente ( int numero , int agencia) {
		super(numero, agencia);
		
	}
	
	
		public void cobrarTaxa() {
			this.saldo -= this.saldo * this.taxa;
			System.out.println("FOI DESCONTADO A TAXA DE ATUAÇÃO DE 0,02% DO BANCO SOBRE CONTAS CORRENTES");
			System.out.println("SEU SALDO AGORA É: " + getSaldo() + "R$");

		}
		
		public void somarBonus() {
		
			this.saldo += this.saldo * this.bonus;
			System.out.println("VOCÊ GANHOU UM BÔNUS DO NOSSO BANCO DE EXATOS 0,03% SOBRE SEU SALDO");
			System.out.println("SEU SALDO AGORA É: " + getSaldo() + "R$");
		}
	}
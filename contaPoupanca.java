package bancoferr;

public class contaPoupanca extends 	contaCorrente{

	private double bonus = 0.03;
	
	public contaPoupanca ( int numero, int agencia) {
		super(numero, agencia);
	}
	
	
	
	public void somarBonus() {
			
		this.saldo += this.saldo * this.bonus;
		System.out.println("VOC� GANHOU UM B�NUS DO NOSSO BANCO DE EXATOS 0,03% SOBRE SEU SALDO");
		System.out.println("SEU SALDO AGORA �: " + getSaldo() + "R$");
	
	}
	
}
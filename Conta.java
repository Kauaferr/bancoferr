package bancoferr;


public class Conta implements InterfaceContas{ 
	protected double bonus = 0.03;
	protected double saldo;
	protected int numero;
	protected int agencia;
	protected int senha;
	protected Cliente Titular;
	protected double taxa;
	
	
	public Conta ( int numero , int agencia) {this.numero = numero; this.agencia = agencia;}
	
	
	public void criarSenha ( int senha) {

	if ( this.senha <= 0 ) { System.out.println("SENHA CRIADA COM SUCESSO!");}
	}
	
	
	public boolean validaSenha(int senha) {
		if ( this.senha == senha) {
			System.out.println("ACESSO PERMITIDO");
			return true;
		}
		else { 
			System.out.println("ACESSO NEGADO. SENHA INCORRETA!!");
			return false;
		}
	}
	
	
	
	public boolean validaNumero(int numero) {
		if ( this.numero == numero) {
			return true;
		}
		else { 
			return false;
		}
	}
	
	public boolean validaAgencia(int agencia) {
		if ( this.agencia == agencia) {
		
			return true;
			
		}
		else { 
			
			return false;
		}
	}
	
	
	public boolean depositar(double valor ) {
	if (  valor > 0) {	
	this.saldo += valor;
	System.out.println("FOI DEPOSITADO: " + valor + "R$");
	return true;
	
	}else {
		
	if ( valor <= 0 ) {
		System.out.println("NÃO É POSSÍVEL DEPOSITAR VALORES MENORES OU IGUAL A ZERO");
		return false;
}
	else {
		return false;

	}
}
	}

	public boolean sacar(double valor) {
		
		if (this.saldo >= valor && valor > 0) {
			this.saldo -= valor;
			System.out.println("FOI SACADO: " + valor + "R$");
			return true;
		}
		else {
			if ( valor <= 0 ) {
				System.out.println("NÃO É POSSÍVEL SACAR VALOR MENOR OU IGUAL A ZERO");
				return false;	
			}
			else {
				
				if( this.saldo < valor) {
					System.out.println("SALDO INSUFICIENTE!!");
					return false;
				}
			}
		}
		return false;
		}
		
	
	public boolean transferir (double valor , Conta destino) {
		if ( this.saldo >= valor && valor > 0 ) {
			this.saldo -= valor;
			destino.saldo += valor;
			System.out.println("FOI TRANSFERIDO: " + valor + "R$" + "PARA A CONTA : " + destino.numero);
			return true;
		}
		else { 
			if ( valor <= 0 ) {
			System.out.println("NÃO É POSSÍVEL TRANSFERIR VALORES MENORES OU IGUAIS A ZERO");
			return false;
			
		}else {
			if( this.saldo < valor) {
		
			System.out.println("SALDO INSUFICIENTE PARA A TRANSFERÊNCIA!");
			return false; 
		}
		}
		}
		return false;
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
//------------------------------------------------------------------------------------------------
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getAgencia() {
		return agencia;
	}
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}


	public void setSenha(int senha) {
		
		this.senha = senha;
		System.out.println("SENHA ALTERADA COM SUCESSO!!");
		}
	
	public int getSenha() {
		return senha;
	}

	public void setTitular(Cliente titular) {
		Titular = titular;
	}

	public Cliente getTitular() {
		return Titular;
	}
		
	
	
	
	
}
package bancoferr;

public class Cliente {
	private String nome; 
	private String cpf;
	private String profissao;
	
	
	public Cliente( String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
		
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getProfissao() {
		return profissao;
	}
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
	
	public boolean validaNomeeCpf() {
		
		if( this.nome.isEmpty()) {
			
			System.out.println("O CAMPO NOME E/OU CPF ESTÃO VAZIO!!");

			return false;
		}else {
			if( this.cpf.isEmpty()) {
				System.out.println("O CAMPO NOME E/OU CPF ESTÃO VAZIO!!");

				return false;
			}else {                                
				return true;
			}
		}
	}
	public boolean NumerosnoNome (String nome) {
		
		if( nome.contains("0")) {
			System.out.println("NÃO PODE HAVER NÚMERO NO SEU NOME");
			return false;
		}else {
			if( nome.contains("1")) {
				System.out.println("NÃO PODE HAVER NÚMERO NO SEU NOME");
				return false;
			}else {
				if( nome.contains("2")) {
					System.out.println("NÃO PODE HAVER NÚMERO NO SEU NOME");
					return false;
				}else {
					if( nome.contains("3")) {
						System.out.println("NÃO PODE HAVER NÚMERO NO SEU NOME");
						return false;
					}else {
						if( nome.contains("4")) {
							System.out.println("NÃO PODE HAVER NÚMERO NO SEU NOME");
							return false;
						}else {
							if( nome.contains("5")) {
								System.out.println("NÃO PODE HAVER NÚMERO NO SEU NOME");
								return false;
							}else {
								if( nome.contains("6")) {
									System.out.println("NÃO PODE HAVER NÚMERO NO SEU NOME");
									return false;
								}else {
									if( nome.contains("7")) {
										System.out.println("NÃO PODE HAVER NÚMERO NO SEU NOME");
										return false;
									}else {
										if( nome.contains("8")) {
											System.out.println("NÃO PODE HAVER NÚMERO NO SEU NOME");
											return false;
										}else {
											if( nome.contains("9")) {
												System.out.println("----------------------------------------");
												System.out.println("NÃO PODE HAVER NÚMERO NO SEU NOME");
												return false;
												
											}else{
												
											this.nome = nome;
											return true;
										}
									}
								}
							}
						}
					}	
				}	
			}
		}
	}
}
} 
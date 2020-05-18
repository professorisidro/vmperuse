# Readme.MD

## Uma pequena explicacao Teorica

- Objetivo da explicacao
	- Query by Method Names
	- Relacoes 1:N (início)

- O que fizemos
	- criamos um novo projeto (tema: projeto final)
		com configuração de conexao com o banco
		DDL Auto pra criar as tabelas
	- Criamos 2 classes Model (Usuario e Solicitacao)
		tudo anotado bonitinho
	- Criamos os respectivos DAO
	- Criamos um controller para Login

	- Alteramos o UsuarioDAO para ter um método específico
		findByEmailAndSenha - ele cria um SELECT customizado baseado nos atributos
	- Relacionamos Usuário e Solicitação
		Um Usuario faz varias solicitações
		Classe Usuario (@OneToMany para Solicitacao)
		Classe Solicitacao (@ManyToOne para Usuario)

	- Problema: LOOP INFINITO!!!!
		Recupera Usuario, que recupera solicitacao, que recupera usuaro, que recupera solicitação.....

	- Como Consertar?
		@JsonIgnoreProperties em cada classe	
		- Usuario @JsonIgnoreProperties no atributo de Solicitação que referencia o usuario (solicitante)
		- Solicitacao @JsonIgnoreProperties no atributo de Usuario que referencia as Solicitacoes (pedidos)

	- Pra fechar com chave de ouro: Formatamos a Data
	@JsonFormat(JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
 













	
	





package main;

import java.util.List;

import model.Jogo;

public class ImpressoraJogos {
	
	public void imprimirMenu() {
		System.out.println("- - - Bem vindo - - -");
		System.out.println("- - - Menu - - - ");
		System.out.println("1. Cadastrar");
		System.out.println("2. Listar jogos");
		System.out.println("3. Excluir jogo");
		System.out.println("4. Sair");
		System.out.printf("Selecione a opção correspondente: ");
	}
	
	public void imprimirJogos(List<Jogo> jogos) {
		System.out.println(" - - - Lista de jogos - - - ");				
		for (Jogo jogo : jogos) {
			System.out.println("Nome: " + jogo.getNome() + ".");
			System.out.println("Gênero: " + jogo.getGenero() + ".");
			System.out.println("Data de lançamento: " + jogo.getDataLancamento() + ".");
			System.out.println("Nota: " + jogo.getNota() + ".");
		}
	}
		
	public void despedida() {
		for (int i = 3; i > 0 ; i--) {
			try {
				Thread.sleep(1000);
				System.out.println("Saindo em " + i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Sistema encerrado, até a próxima!");
	}

	public void cadastroRealizado() {
		System.out.println("Seu jogo foi cadastrado com sucesso.");		
	}

	public void erroCadastro() {
		System.out.println("Erro ao cadastrar jogo. Tente novamente.");				
	}
}

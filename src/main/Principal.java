package main;

import java.util.List;
import java.util.Scanner;

import dao.JogoDao;
import model.Jogo;

public class Principal {
	public static void main (String[] args) {
		Scanner scanner = new Scanner(System.in);
		JogoDao dao = new JogoDao();
		ImpressoraJogos impressora = new ImpressoraJogos();
		EntradaDados entrada = new EntradaDados();
		
		impressora.imprimirMenu();
		
		while (true) {
			int opcao = entrada.solicitarOpcao(scanner);
			
			switch (opcao) {
			case 1:
				Jogo jogo = entrada.solicitarJogo(scanner);
				try {
					jogo = dao.inserirJogo(jogo);
					impressora.cadastroRealizado();
				} catch (Exception e) {
					impressora.erroCadastro();
				}
			case 2:
				List<Jogo> jogos = dao.listarJogos();
				impressora.imprimirJogos(jogos);
				break;
			case 3:
				System.out.println("Case 3 'Excluir Jogo' funcionando");
				break;
			case 4:
				impressora.despedida();
				scanner.close();
				System.exit(0);
				break;
			default:
				System.out.println("Selecione uma opção válida (deve ser um número de 1 a 4.");
				break;
			}	
		}
	}
}

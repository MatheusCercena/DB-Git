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
		
		boolean continuarExecutando = true;
		
		while (continuarExecutando) {
			int opcao = entrada.solicitarOpcao(scanner);
			
			switch (opcao) {	
				case 1:
					Jogo jogo = entrada.solicitarJogo(scanner);
					System.out.println(jogo.getGenero());
					try {
						jogo = dao.inserirJogo(jogo);
						impressora.cadastroRealizado();
					} catch (Exception e) {
						impressora.erroCadastro();
					}
					break;
				case 2:
					List<Jogo> jogos = dao.listarJogos();
					impressora.imprimirJogos(jogos);
					break;
				case 3:
					dao.listarJogos();
					int id_jogo = entrada.solicitarIdJogo(scanner);
					Jogo jogo_excluido = dao.buscarPorId(id_jogo);
					boolean resultado = dao.excluirJogo(jogo_excluido);
					if (resultado == false) {impressora.jogoExcluido();}
					break;
				case 4:
					impressora.despedida();
					continuarExecutando = false;
					break;
				default:
					impressora.opcaoInvalida();
					break;
			}
		}
		scanner.close();
	}
}

package principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
	public static void main (String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		List<String> opcoes = new ArrayList<>();
		opcoes.add("Cadastrar");
		opcoes.add("Listar jogos");
		opcoes.add("Excluir jogo");
		opcoes.add("Sair");
		
		System.out.println("- - - Bem vindo - - -");
		System.out.println("- - - Menu - - - ");
		for (int i = 0; i < opcoes.size() ; i++) {
			System.out.println(i+1 + ". "+ opcoes.get(i));
		}		
		System.out.printf("Selecione a opção correspondente: ");
		
		while (true) {
			int opcao = scanner.nextInt();
			
			switch (opcao) {
			case 1:
				System.out.println("Case 1 " + opcoes.get(0) + " funcionando");
				break;
			case 2:
				System.out.println("Case 2 " + opcoes.get(1) + " funcionando");
				break;
			case 3:
				System.out.println("Case 3 " + opcoes.get(2) + " funcionando");
				break;
			case 4:
				System.out.println("Case 4 " + opcoes.get(3) + " funcionando");
				for (int i = 3; i > 0 ; i--) {
					try {
						Thread.sleep(1000);
						System.out.println("Saindo em " + i);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("Sistema encerrado, até a próxima!");
				scanner.close();
				System.exit(0);
				
				break;
			default:
				System.out.println("Selecione uma opção válida (deve ser um número de 1 a " + opcoes.size() + ".");
				break;
			}	
		}
	}
}

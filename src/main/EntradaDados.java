package main;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import model.Jogo;

public class EntradaDados {

	public int solicitarOpcao(Scanner scanner) {
		while (true) {
			try {
				System.out.println("");
				System.out.printf("Selecione a opção correspondente: ");
				int opcao = scanner.nextInt();
				scanner.nextLine();
				return opcao;
			} catch (InputMismatchException e) {
				System.out.println("Por favor, digite um número");
			}	
		}
	}

	
	public Jogo solicitarJogo(Scanner scanner) {
		System.out.println("- - - Insira abaixo os dados do jogo que deseja cadastrar - - -");
		
		String nome = solicitarNome(scanner);
		String genero = solicitarGenero(scanner);	
		Date data = solicitarData(scanner);
		double nota = solicitarNota(scanner);
				
		Jogo livro = new Jogo(nome, genero, data, nota);
		
		return livro;
	}
	
	public String solicitarNome(Scanner scanner) {
		String nome = "";

		while (true) {
    		System.out.print("Nome: ");
    		try {
    			nome = scanner.nextLine();    
        		break;
    		} catch (NoSuchElementException e) {
    			System.out.println("Por favor, insira algum nome para o seu jogo.");
    		}
    		if (nome.length() > 100) { 
	    		System.out.println("O nome não deve conter mais de 100 caracteres, tente novamente.");
    		}
		}
		return nome;
	}

	public String solicitarGenero(Scanner scanner) {
		String genero = "";

		while (true) {
    		System.out.print("Gênero: ");
    		try {
    			genero = scanner.nextLine();    
        		break;
    		} catch (NoSuchElementException e) {
    			System.out.println("Por favor, insira algum genero para o seu jogo.");
    		}
    		if (genero.length() > 50) { 
	    		System.out.println("O genero não deve conter mais de 50 caracteres, tente novamente.");
    		}
		}
		return genero;		
	}
	
	public double solicitarNota(Scanner scanner) {
		double nota = 0;

		while (true) {
    		System.out.print("Nota (0,0 a 10,0): ");
    		try {
        		nota = scanner.nextDouble();    
        		break;
    		} catch (InputMismatchException e) {
    			System.out.println("Por favor, digite apenas números.");
    		}
    		if (nota > 10 || nota < 0) { 
	    		System.out.println("Por favor, digite um numero de 0,0 a 10,0.");
    		}
		}
		return nota;
	}
	
	public Date solicitarData(Scanner scanner) {
        List<String> formatos = List.of("dd/MM/yyyy", "dd-MM-yyyy", "dd.MM.yyyy", "ddMMyyyy");
        
        while (true) {
    		System.out.print("Data de lançamento (dd/mm/yyyy): ");
    		String entrada = scanner.nextLine();

        	for (String formato : formatos) {
    	        try {
    				DateTimeFormatter pattern = DateTimeFormatter.ofPattern(formato);			
    				LocalDate localDate = LocalDate.parse(entrada, pattern);
    				Date data = Date.valueOf(localDate);
    				return data;
    	        } catch (Exception e) {			
    	        	e.printStackTrace();
    	        }
    		}		        	
			System.out.println("Data inválida. Por favor, assegure-se de estar usando um dos seguintes padrões: dd/mm/yyyy, dd-MM-yyyy, dd.MM.yyyy, ddMMyyyy.");
        }
	}


	public int solicitarIdJogo(Scanner scanner) {
		System.out.println("Digite o ID do jogo que deseja excluir: ");
		int id_jogo = scanner.nextInt();
		return id_jogo;
	}
	

}

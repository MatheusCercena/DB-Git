package main;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import model.Jogo;

public class EntradaDados {

	public int solicitarOpcao(Scanner scanner) {
		while (true) {
			try {
				int opcao = scanner.nextInt();
				return opcao;
			} catch (InputMismatchException e) {
				System.out.println("Por favor, digite um número");
			}	
		}
	}

	
	public Jogo solicitarJogo(Scanner scanner) {
		System.out.println("- - - Insira abaixo os dados do jogo que deseja cadastrar - - -");
		
		System.out.print("Nome: ");
		String nome = scanner.nextLine();
		
		System.out.print("Gênero: ");
		String genero = scanner.nextLine();		
		

		Date data = solicitarData(scanner);
		double nota = solicitarNota(scanner);
		
		Jogo jogo = new Jogo(nome, genero, data, nota);
		
		return jogo;
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
    	        } catch (IllegalArgumentException e) {			
    	        	// continua.
    	        }
    		}		        	
			System.out.println("Data inválida. Por favor, assegure-se de estar usando um dos seguintes padrões: dd/mm/yyyy, dd-MM-yyyy, dd.MM.yyyy, ddMMyyyy.");
        }
	}
	

}

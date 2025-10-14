package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import model.Jogo;

public class JogoDao {
	public Connection getConexao() {
		String driver = "com.mysql.cj.jdbc.Driver";
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String url = "jdbc:mysql://localhost:3306/ies"; // 3306 = porta padrao mysql, pesquisar especificas, alterar tambem o nome do SGBD
		String senha = "1234";
		String user = "root";
		
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(url, user, senha);
			System.out.println("Banco de dados conectado.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
		
		
	}
	
	public List<Jogo> listarJogos(){
		return null;
	}
	
	public boolean inserirJogo() {
		return true;
	}
	
	public Jogo inserirJogo(Jogo novoJogo) {
		return null;
	}

	public Jogo alterarrJogo(Jogo jogoAlterado) {
		return null;
	}
	
	public boolean excluirJogo() {
		return true;
	}
	

	
	
	


}

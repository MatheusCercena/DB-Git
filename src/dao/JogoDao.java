package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
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

		String url = "jdbc:mysql://localhost:3306/ies";
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
		List<Jogo> jogos = new ArrayList<>();
		String consulta = "SELECT * from jogo";
		try {
			Connection conn = getConexao();
			PreparedStatement pst = conn.prepareStatement(consulta);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt(0);
				String nome = rs.getString(1);
				String genero = rs.getString(1);
				Date dataLancamento = rs.getDate(1);
				double nota = rs.getDouble(1);

				Jogo jogo = new Jogo(id, nome, genero, dataLancamento, nota);
				jogos.add(jogo);
			}
			rs.close();
			pst.close();
			conn.close();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jogos;
	}
	
	public Jogo inserirJogo(Jogo jogoNovo) {
		String consulta = "INSERT into " +
				"jogo(id, nome, genero, data_lancamento, nota) " +
				"values(?, ?, ?, ?, ?)";
		
		try {
			Connection conn = getConexao();
			PreparedStatement pst = conn.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, jogoNovo.getNome());
			pst.setString(2, jogoNovo.getGenero());
			pst.setDate(3, jogoNovo.getDataLancamento());
			pst.setDouble(4, jogoNovo.getNota());
			
			pst.executeUpdate();
			
			ResultSet rs = pst.getGeneratedKeys();
			
			pst.setInt(0, jogoNovo.getId());
			
			if (rs.next()) {
				int id = rs.getInt(1);
				jogoNovo.setId(id);
			}
			
			rs.close();
			pst.close();
			rs.close();

			return jogoNovo;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public boolean excluirJogo(Jogo novoJogo) {
		return true;
	}

	public Jogo alterarJogo(Jogo jogoAlterado) {
		return null;
	}
	
	

	
	
	


}

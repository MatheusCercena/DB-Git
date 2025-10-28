package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public Jogo buscarPorId(int id) {
		Jogo jogo = null;
		
		String consulta = "Select * from jogo Where id = ?";
		
		try (Connection conn = getConexao();
			PreparedStatement pst = conn.prepareStatement(consulta);){
			
			pst.setInt(1, id);
			
			ResultSet rs = pst.executeQuery();
					
			while (rs.next()) {
				int identificador = rs.getInt(1);
				String nome = rs.getString(2);
				String genero = rs.getString(3);
				Date dataLancamento = rs.getDate(4);
				double nota = rs.getDouble(5);

				jogo = new Jogo(identificador, nome, genero, dataLancamento, nota);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return jogo;
	}
	
	public List<Jogo> listarJogos(){
		List<Jogo> jogos = new ArrayList<>();
		String consulta = "SELECT * from jogo";
		try (Connection conn = getConexao();
			PreparedStatement pst = conn.prepareStatement(consulta);
			ResultSet rs = pst.executeQuery();) {
			
			while (rs.next()) {
				int id = rs.getInt(1);
				String nome = rs.getString(2);
				String genero = rs.getString(3);
				Date dataLancamento = rs.getDate(4);
				double nota = rs.getDouble(5);

				Jogo jogo = new Jogo(id, nome, genero, dataLancamento, nota);
				jogos.add(jogo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return jogos;
	}
	
	public Jogo inserirJogo(Jogo jogoNovo) {
		String consulta = "INSERT into " +
				"jogo(nome, genero, data_lancamento, nota) " +
				"values(?, ?, ?, ?)";
		
		try (Connection conn = getConexao();
			PreparedStatement pst = conn.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);){
			
			pst.setString(1, jogoNovo.getNome());
			pst.setString(2, jogoNovo.getGenero());
			pst.setDate(3, jogoNovo.getDataLancamento());
			pst.setDouble(4, jogoNovo.getNota());
			pst.executeUpdate();
			
			ResultSet rs = pst.getGeneratedKeys();
			if (rs.next()) {
				int id = rs.getInt(1);
				jogoNovo.setId(id);
			}	
			rs.close();
			return jogoNovo;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public boolean excluirJogo(Jogo jogoParaExcluir) {
		String consulta = "Delete from jogo where id = ?";
		
		try (Connection conn = getConexao();
			PreparedStatement pst = conn.prepareStatement(consulta); ) {
			
			pst.setInt(1, jogoParaExcluir.getId());
			pst.executeUpdate();
			
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Não foi possível excluir o jogo.");
		}

		return false;
	}

	public void alterarJogo(Jogo jogoParaAlterar) {
		String consulta = "UPDATE jogo set nome = ?, genero = ?, data_lancamento = ?, nota = ? where id = ?";
		
		try (Connection conn = getConexao();
			PreparedStatement pst = conn.prepareStatement(consulta);) {
			
			pst.setString(1, jogoParaAlterar.getNome());
			pst.setString(2, jogoParaAlterar.getGenero());
			pst.setDate(3, jogoParaAlterar.getDataLancamento());
			pst.setDouble(4, jogoParaAlterar.getNota());
			
			pst.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}

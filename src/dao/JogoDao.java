package dao;

import java.util.Date;

public class JogoDao {
	private int id;
	private String nome;
	private Date dataLancamento;
	private double nota;
	
	public JogoDao(String nome, Date dataLancamento, double nota) {
		super();
		this.nome = nome;
		this.dataLancamento = dataLancamento;
		this.nota = nota;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}


	
}

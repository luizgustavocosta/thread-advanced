package br.com.thread.vo;

public class Comando {
	private String tipo;
	private int prioridade;
	private String params;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public Comando(String tipo, int prioridade, String params) {
		super();
		this.tipo = tipo;
		this.prioridade = prioridade;
		this.params = params;
	}
}

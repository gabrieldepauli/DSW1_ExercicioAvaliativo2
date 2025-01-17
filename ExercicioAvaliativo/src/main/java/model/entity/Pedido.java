package model.entity;

public class Pedido {
	private int id;
	private String nome;
	private String endereco;
	private double valor;
	private String descricao;
	
	public Pedido() {
	}

	public Pedido(int id, String nome, String endereco, double valor, String descricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.valor = valor;
		this.descricao = descricao;
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}

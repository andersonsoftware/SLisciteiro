package model;

import java.sql.Date;
import java.util.List;

public class Licitacao {
	private int id;
	private String descricao;
	private float valor_estimado;
	private Funcionario funcionario;
	private List<ProdutoLicitacao> produtos;
	private Date dataInicio;
	private Date dataFim;
	private Fornecedor fornecedor;
	private boolean estado;
	private boolean lancado;
	private Categoria categoria;
	
	public Licitacao(){
		super();
	}
	
	public Licitacao(String descricao, float valor_estimado, Funcionario funcionario, List<ProdutoLicitacao> produtos,
			Date dataInicio, Date dataFim, Fornecedor fornecedor, boolean estado, boolean lancado,
			Categoria categoria) {
		super();
		this.descricao = descricao;
		this.valor_estimado = valor_estimado;
		this.funcionario = funcionario;
		this.produtos = produtos;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.fornecedor = fornecedor;
		this.estado = estado;
		this.lancado = lancado;
		this.categoria = categoria;
	}

	
	public Licitacao(String descricao, float valor_estimado, Funcionario funcionario, List<ProdutoLicitacao> produtos,
			Date dataInicio, Date dataFim, Categoria categoria) {
		this.descricao = descricao;
		this.valor_estimado = valor_estimado;
		this.funcionario = funcionario;
		this.produtos = produtos;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.categoria = categoria;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getValor_estimado() {
		return valor_estimado;
	}

	public void setValor_estimado(float valor_estimado) {
		this.valor_estimado = valor_estimado;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public List<ProdutoLicitacao> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoLicitacao> produtos) {
		this.produtos = produtos;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public boolean isLancado() {
		return lancado;
	}

	public void setLancado(boolean lancado) {
		this.lancado = lancado;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	
	
}

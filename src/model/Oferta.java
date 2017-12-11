/**
 * 
 */
package model;

/**
 * @author matheus
 *
 */
public class Oferta {
	private int id;
	private Licitacao licitacao;
	private Fornecedor fornecedor;
	private float valor;
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the licitacao
	 */
	public Licitacao getLicitacao() {
		return licitacao;
	}
	/**
	 * @param licitacao the licitacao to set
	 */
	public void setLicitacao(Licitacao licitacao) {
		this.licitacao = licitacao;
	}
	/**
	 * @return the fornecedor
	 */
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	/**
	 * @param fornecedor the fornecedor to set
	 */
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	/**
	 * @return the valor
	 */
	public float getValor() {
		return valor;
	}
	/**
	 * @param valor the valor to set
	 */
	public void setValor(float valor) {
		this.valor = valor;
	}
	
}

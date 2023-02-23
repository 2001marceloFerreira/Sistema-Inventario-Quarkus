package br.com.models;


import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@NamedQuery(name = "Produto.getByValor", query = "from Produto where valor = ?1")
@Table(name = "tb_produto")
public class Produto extends PanacheEntityBase{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@NotNull
	private String patrimonio;
	
	@Size(min=3, max = 30)
	@Column(nullable = false)
	private String descricao;
	
	@NotEmpty
	@NotNull
	private String situacao;
	
	@NotEmpty
	@NotNull
	private String codigo;
	
//	@JsonbDateFormat(value="yyyy-MM-dd'T' HH:mm:ss.SSSXXX")
	@Column(name="dt_cadastro")
	private Date dtCadastro;
	
	private Double valor;
	
	@NotEmpty
	@NotNull
	private String propriedade;
	
	@ManyToOne
	@Fetch(FetchMode.SELECT)
    @JoinColumn(name = "tipo_id", referencedColumnName = "id")
	private Tipo tipo;
	
	@ManyToOne
	@Fetch(FetchMode.SELECT)
    @JoinColumn(name = "pessoa_id", referencedColumnName = "id")
	private Pessoa pessoa;
	
	@ManyToOne
	@Fetch(FetchMode.SELECT)
	@JoinColumn(name = "ambiente_id")
	private Ambiente ambiente;
	
//	@Enumerated(EnumType.STRING)
//	@Column(name = "propriedade")
//	private Propriedade propriedade;
	
	
	
	
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	

	public Date getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public String getPatrimonio() {
		return patrimonio;
	}
	public void setPatrimonio(String patrimonio) {
		this.patrimonio = patrimonio;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Ambiente getAmbiente() {
		return ambiente;
	}

	public void setAmbiente(Ambiente ambiente) {
		this.ambiente = ambiente;
	}
	
	public String getPropriedade() {
		return propriedade;
	}

	public void setPropriedade(String propriedade) {
		this.propriedade = propriedade;
	}
	
	 // setar a data de cadastro da tarefa para cadastrar data automático assim que
    // for salvo
//    @PrePersist
//    public void beforeSave() {
//        setDtCadastro(Date.now());
//    }
	
    
//	public static List<Produto> obterPorCodigo(String codigo) {
//		return Produto.find("codigo", codigo).list();
//	}
	
//	public static List<Produto> obterPorAmbiente(Ambiente ambiente) {
//		return Produto.find("ambiente", ambiente).list();
//	}
	
//	public static Produto findByValor(String valor){
//        return find("#Produto.getByValor", valor).firstResult();
//    }
	
}

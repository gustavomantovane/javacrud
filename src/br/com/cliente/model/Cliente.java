package br.com.cliente.model;

import java.util.Date;

public class Cliente {
	
	private int id;
	private String nome;
	private String sexo;
	private Date dataNascimento;
	private String RG;
	private String CPF;
	private String email;
	private String telefone;
	private String endereco;
	private String bairro;
	private String municipio;
	private String UF;
	
	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", sexo=" + sexo + ", dataNascimento=" + dataNascimento + ", RG=" + RG
				+ ", CPF=" + CPF + ", email=" + email + ", telefone=" + telefone + ", endereco=" + endereco
				+ ", bairro=" + bairro + ", municipio=" + municipio + ", UF=" + UF + "]";
	}

	public Cliente(String nome, String sexo, Date dataNascimento, String RG, String CPF, String email, String telefone,
		String endereco, String bairro, String municipio, String UF) {
		
		this.nome = nome;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.RG = RG;
		this.CPF = CPF;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
		this.bairro = bairro;
		this.municipio = municipio;
		this.UF = UF;
		
	}
	
	public Cliente() {
			
		
			
	}
	
	public int getID() {
		
		return id;
		
	}
	
	public void setID(int id) {
		
		this.id = id;
		
	}

	public String getNome() {
	
		return nome;
	
	}
	
	public void setNome(String nome) {
	
		this.nome = nome;
	
	}
	
	public String getSexo() {
	
		return sexo;
	
	}
	
	public void setSexo(String sexo) {
	
		this.sexo = sexo;
	
	}
	
	public Date getDataNascimento() {
	
		return dataNascimento;
	
	}
	
	public void setDataNascimento(Date dataNascimento) {
	
		this.dataNascimento = dataNascimento;
	
	}
	
	public String getRG() {
	
		return RG;
	
	}
	
	public void setRG(String rG) {
	
		RG = rG;
	
	}
	
	public String getCPF() {
	
		return CPF;
	
	}
	
	public void setCPF(String CPF) {
		
		this.CPF = CPF;
	
	}
	
	public String getEmail() {
	
		return email;
	
	}
	
	public void setEmail(String email) {
	
		this.email = email;
	
	}
	
	public String getTelefone() {
	
		return telefone;
	
	}
	
	public void setTelefone(String telefone) {
	
		this.telefone = telefone;
	
	}
	
	public String getEndereco() {
	
		return endereco;
	
	}
	
	public void setEndereco(String endereco) {
	
		this.endereco = endereco;
	
	}
	
	public String getBairro() {
	
		return bairro;
	
	}
	
	public void setBairro(String bairro) {
	
		this.bairro = bairro;
	}
	
	public String getMunicipio() {
	
		return municipio;
	}
	
	public void setMunicipio(String municipio) {
	
		this.municipio = municipio;
	}
	
	public String getUF() {
	
		return UF;
	}
	
	public void setUF(String UF) {
	
		this.UF = UF;
	
	}
	
	
	
}

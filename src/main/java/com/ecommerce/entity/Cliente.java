package com.ecommerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 100)
	private String nombres;
	@Column(length = 100)
	private String apellidoPaterno;
	@Column(length = 100)
	private String apellidoMaterno;
	@Column(length = 20)
	private String tipoDoc;
	@Column(length = 11)
	private String numDoc;
	@Column(length = 250)
	private String direccionEnvio;
	@Column(length = 100)
	private String departamento;
	@Column(length = 100)
	private String provincia;
	@Column(length = 100)
	private String distrito;
	@Column(length = 9)
	private String telefono;
	@OneToOne
	private DocumentoAlmacenado foto;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	public String getNumDoc() {
		return numDoc;
	}

	public void setNumDoc(String numDoc) {
		this.numDoc = numDoc;
	}

	public String getDireccionEnvio() {
		return direccionEnvio;
	}

	public void setDireccionEnvio(String direccionEnvio) {
		this.direccionEnvio = direccionEnvio;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public DocumentoAlmacenado getFoto() {
		return foto;
	}

	public void setFoto(DocumentoAlmacenado foto) {
		this.foto = foto;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
}

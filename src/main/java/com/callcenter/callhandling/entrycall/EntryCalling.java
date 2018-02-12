package com.callcenter.callhandling.entrycall;

public class EntryCalling {
	private long duracion;
	private int numero;
	private String estado;
	private User usuario;

	public EntryCalling(long initialTime, int numero, String estado, User usuario) {
		this.duracion = initialTime;
		this.numero = numero;
		this.estado = estado;
		this.usuario = usuario;
	}

	public long getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "LlamadaEntrante [duracion=" + duracion + ", numero=" + numero + ", estado=" + estado + ", usuario="
				+ usuario + "]";
	}

}

package com.svalero.pc.loginbusiness.datos;


import com.svalero.pc.loginbusiness.beans.Cliente;

public class GrouponData {
	private static Cliente cliente;

	public static Cliente getCliente() {
		return cliente;
	}

	public static void setCliente(Cliente cliente) {
		GrouponData.cliente = cliente;
	}
	
}

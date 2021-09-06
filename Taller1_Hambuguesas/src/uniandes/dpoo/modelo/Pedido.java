package uniandes.dpoo.modelo;

import java.util.ArrayList;

public class Pedido {
	
	private int numeroPedido;
	
	private int idPedido;
	
	private String nombreCliente;
	
	private String direccionCliente;
	
	public ArrayList<Producto> itemsPedido;
	
	public boolean activo;
	
	public Pedido(String nombreCliente, String direccionCliente) {
		this.nombreCliente = nombreCliente;
		this.direccionCliente = direccionCliente;
	}
	
	public int getIdPedido() {
		return idPedido;
	}
	
	public void agregarProducto(Producto nuevoItem) {
		itemsPedido.add(nuevoItem);
	}
	

	private double getPrecioTotalPedido() {
		double precioNetoPedido = getPrecioNetoPedido();
		double precioIVAPedido = getPrecioIVAPedido(precioNetoPedido);
		var precioTotalPedido = precioNetoPedido + precioIVAPedido;
		return precioTotalPedido; 
		
	}
	
	
	private double getPrecioNetoPedido() {
		double precioNetoPedido = 0;
		for (int i = 0; i < itemsPedido.size(); i++){
			var elItem = itemsPedido.get(i);
			precioNetoPedido = precioNetoPedido + elItem.getPrecio();
		}
		return precioNetoPedido;
	}
	
	
	private double getPrecioIVAPedido(double precioNetoPedido) {
		double precioIVAPedido = 0.19*precioNetoPedido;
		return precioIVAPedido;
		
	}
	
	private String generarTextoFactura() {
		String textoFactura = "";
		for (int i = 0; i < itemsPedido.size(); i++){
			var elItem = itemsPedido.get(i);
			var texto = elItem.generarTextoFactura();
			textoFactura = textoFactura + "%n" + texto;
		}
		
		textoFactura = textoFactura + "%n" + "Precio Neto: " + getPrecioNetoPedido() + "%n" + "IVA: " + getPrecioIVAPedido(getPrecioNetoPedido()) + "%n" +"Precio Total: " + getPrecioTotalPedido();
		textoFactura = textoFactura + "%n" + "Calorias totales: " + getCaloriasTotales();
		return textoFactura;
	}
	
	public int getCaloriasTotales() {
		int caloriasTotales = 0;
		for (int i = 0; i < itemsPedido.size(); i++){
			var item = itemsPedido.get(i);
			var cal = item.getCalorias(); 
			caloriasTotales = caloriasTotales + cal;
		}
		return caloriasTotales;
	}


}

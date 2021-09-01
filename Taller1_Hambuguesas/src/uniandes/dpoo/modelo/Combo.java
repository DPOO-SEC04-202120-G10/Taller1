package uniandes.dpoo.modelo;


import uniandes.dpoo.taller0.modelo.Pais;

public class Combo implements Producto{

	private double descuento;
	private String nombre; 
	
	public Combo(double descuento, String nombre) {
		this.descuento = descuento;
		this.nombre = nombre;
	}
	
	public void agregarItemACombo() {
		
	}
	
	public double getPrecio() {
		return precio;
	}
	
	
	public String generarTextoFactura() {
		return factura
	}
	
	public String getNombre() {
		return nombre;
	}
	
}

package uniandes.dpoo.modelo;


import java.util.ArrayList;


public class Combo implements Producto{

	private double descuento;
	private String nombre; 
	private ArrayList<Producto> itemsCombo; 
	
	public Combo(String nombre, double descuento) {
		this.descuento = descuento;
		this.nombre = nombre;
		this.itemsCombo = new ArrayList<Producto>();   
	}
	
	public void agregarItemACombo(Producto productoCombo) {
		this.itemsCombo.add(productoCombo);
	}
	
	
	public double getPrecio() {
		double precio = 0;
		
		for (int i = 0; i < itemsCombo.size(); i++){
			var elProducto = itemsCombo.get(i);
			precio = precio + elProducto.getPrecio();
		}
		
		precio = precio * (1-descuento);
		
		return precio;
	}
	
	
	public String generarTextoFactura() {
		String textoFactura;
		textoFactura = getNombre() + ": " + getPrecio();
		return textoFactura;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getCalorias() {
		int caloriasTotales = 0;
		for (int i = 0; i < itemsCombo.size(); i++){
			var item = itemsCombo.get(i);
			var cal = item.getCalorias(); 
			caloriasTotales = caloriasTotales + cal;
		}
		return caloriasTotales;
	}
	
}

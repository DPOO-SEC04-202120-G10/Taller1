package uniandes.dpoo.modelo;

import java.util.ArrayList;

public class ProductoAjustado implements Producto {
	private ProductoMenu base; 
	private String nombre;
	private ArrayList<Ingrediente> agregados;
	private ArrayList<Ingrediente> eliminados; 
	
	public ProductoAjustado(ProductoMenu base)
	{
		this.base = base; 
		this.nombre = base.getNombre() + " ajustado";
		
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public double getPrecio()
	{
		double precioBase = base.getPrecio();
		double precioExtra = 0; 
		double precioTotal;
		
		for (int i = 0; i < agregados.size(); i++){
			var elIngrediente = agregados.get(i);
			precioExtra = precioExtra + elIngrediente.getCostoAdicional();
		}
		
		precioTotal = precioExtra + precioBase;
		
		return precioTotal;
	}
	
	public  void añadirIngrediente(Ingrediente elIngrediente)
	{
		agregados.add(elIngrediente);
	}
	public void eliminarIngrediente(Ingrediente elIngrediente)
	{
		eliminados.add(elIngrediente);
	}
	public String generarTextoFactura()
	{
		String textoFactura;
		textoFactura = base.getNombre() + ": " + base.getPrecio() + "%n";
		
		for (int i = 0; i < agregados.size(); i++){
			var elIngrediente = agregados.get(i);
			textoFactura = textoFactura + "%n" + "+ " + elIngrediente.getNombre() + ": " + elIngrediente.getCostoAdicional();
 		}
		
		for (int i = 0; i < eliminados.size(); i++){
			var elIngrediente = agregados.get(i);
			textoFactura = textoFactura + "%n" + "- " + elIngrediente.getNombre() + ": " + "0";
		}
		
		return textoFactura;
		 
	}

}

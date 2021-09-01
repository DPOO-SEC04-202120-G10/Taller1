package uniandes.dpoo.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileReader;

public class Restaurante {
	public Restaurante()
	{
		
	}
public void iniciarPedido(String nombreCliente, String direcciónCliente)
{
	
}
public  void cerrarYGuardarPedido()
{
	
}
public getPedidoEnCurso() 
{
	return Pedido
		
}
public getMenuBase()
{ return ArrayList&lt;Producto&gt;

}
public void cargarInformacionRestaurante(File archivoIngredientes, File archivoMenu, File archivoCombos)
{
	archivoIngredientes.cargarIngrediente();
	archivoMenu.cargarMenu();
	archivoCombos.cargarCombos();
}
private void cargarIngredientes(File archivoIngredientes)
{
	Map<String, Ingrediente> ingredientes = new HashMap<>();
	BufferedReader br = new BufferedReader(new FileReader(archivoIngredientes));
	String linea = br.readLine();
	linea = br.readLine();
	while (linea != null) 
	{
		String[] partes = linea.split(",");
		String nombreIngrediente = partes[0];
		int precio= Integer.parseInt(partes[1]);
		Ingrediente elIngrediente= new Ingrediente(nombreIngrediente, precio);
		ingredientes.put(nombreIngrediente, elIngrediente);
	}
	
}
private void cargarMenu(File archivoMenu)
{
	Map<String, ProductoMenu> menu = new HashMap<>();
	BufferedReader br = new BufferedReader(new FileReader(archivoMenu));
	String linea = br.readLine();
	linea = br.readLine();
	while (linea != null) 
	{
		String[] partes = linea.split(",");
		String nombreProductoMenu= partes[0];
		int precio= Integer.parseInt(partes[1]);
		ProductoMenu elProductoMenu= new ProductoMenu(nombreProductoMenu, precio);
		menu.put(nombreProductoMenu, elProductoMenu);
	}
		
}
private void cargarCombos(File archivoCombos)
{
Map<String, Combo> combos = new HashMap<>();

BufferedReader br = new BufferedReader(new FileReader(archivoCombos));
String linea = br.readLine();
linea = br.readLine();
while (linea != null) 
{
	String[] partes = linea.split(",");
	String nombreCombo= partes[0];
	int descuento= Integer.parseInt(partes[1]);
	Combo elCombo= new Combo(descuento, nombreCombo);
	combos.put(nombreCombo, elCombo);
}
}}

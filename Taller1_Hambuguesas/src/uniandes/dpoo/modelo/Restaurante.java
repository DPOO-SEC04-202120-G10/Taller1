package uniandes.dpoo.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import uniandes.dpoo.procesamiento.LoaderInformacionArchivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Restaurante {
	
	private ArrayList<Pedido> pedidosCerrados;
	private Pedido pedidoEnCurso;
	private ArrayList<ProductoMenu> menuBase;
	private ArrayList<Combo> combos;
	public ArrayList<Ingrediente> ingredientes;
	
	
	public Restaurante()
		{	
			this.pedidosCerrados = new ArrayList<Pedido>();
			this.menuBase = new ArrayList<ProductoMenu>();
			this.combos = new ArrayList<Combo>();
			this.ingredientes = new ArrayList<Ingrediente>();
		}
		
	public void iniciarPedido(String nombreCliente, String direccionCliente)
		{
			this.pedidoEnCurso = new Pedido(nombreCliente, direccionCliente);
		}
	
	public  void cerrarYGuardarPedido()
		{
			pedidosCerrados.add(this.pedidoEnCurso);
			this.pedidoEnCurso = null;
		}
	
	public Pedido getPedidoEnCurso() 
		{
			return pedidoEnCurso;
		}
	
	public ArrayList<ProductoMenu> getMenuBase()
		{ 
			return menuBase;
		}
	
	public ArrayList<Ingrediente> getIngredientes()
		{
			return ingredientes;
		}
	
	public void cargarInformacionRestaurante(String archivoIngredientes, String archivoMenu, String archivoCombos) throws FileNotFoundException, IOException
		{
			cargarIngredientes(archivoIngredientes);
			cargarMenu(archivoMenu);
			cargarCombos(archivoCombos);
			
		}
	private void cargarIngredientes(String archivoIngredientes) throws FileNotFoundException, IOException
		{
			var ingredientes = LoaderInformacionArchivos.leerInfoArchivoIngredientes(archivoIngredientes);
		}
		
	
	private void cargarMenu(String archivoMenu) throws FileNotFoundException, IOException
		{
			var menuBase = LoaderInformacionArchivos.leerInfoArchivoProductosMenu(archivoMenu);
		}
	
	private void cargarCombos(String archivoCombos) throws FileNotFoundException, IOException
		{
			var combos = LoaderInformacionArchivos.leerInfoArchivoCombos(archivoCombos, menuBase);
		}

}

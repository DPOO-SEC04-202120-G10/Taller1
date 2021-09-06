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
	
	public ArrayList<Pedido> pedidosCerrados;
	public Pedido pedidoEnCurso;
	public  ArrayList<ProductoMenu> menuBase;
	public  ArrayList<Combo> combos;
	public  ArrayList<Ingrediente> ingredientes;
	
	
	public Restaurante()
		{	
			this.pedidosCerrados = new ArrayList<Pedido>();
			this.menuBase = new ArrayList<ProductoMenu>();
			this.combos = new ArrayList<Combo>();
			this.ingredientes = new ArrayList<Ingrediente>();
		}
		
	public  void iniciarPedido(String nombreCliente, String direccionCliente, int idPedido )
		{
			this.pedidoEnCurso = new Pedido(nombreCliente, direccionCliente,idPedido);
		}
	
	public  void cerrarYGuardarPedido()
		{
			pedidosCerrados.add(this.pedidoEnCurso);
			this.pedidoEnCurso = null;
		}
	public  ArrayList<Pedido> getPedidosCerrados() 
	{

		return pedidosCerrados;
	}
	public Pedido getPedidoEnCurso() 
		{
			return pedidoEnCurso;
		}
	
	public  ArrayList<ProductoMenu> getMenuBase()
		{ 
			return menuBase;
		}
	
	public  ArrayList<Ingrediente> getIngredientes()
		{
			return ingredientes;
		}
	public   ArrayList<Combo> getCombo()
	{
		return combos;
		
	}
	
	public void cargarInformacionRestaurante(String archivoIngredientes, String archivoMenu, String archivoCombos) throws FileNotFoundException, IOException
		{
			cargarIngredientes(archivoIngredientes);
			cargarMenu(archivoMenu);
			cargarCombos(archivoCombos);
			
		}
	private void cargarIngredientes(String archivoIngredientes) throws FileNotFoundException, IOException
		{
			
			try {
				this.ingredientes = LoaderInformacionArchivos.leerInfoArchivoIngredientes(archivoIngredientes);
			}
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	
	private void cargarMenu(String archivoMenu) throws FileNotFoundException, IOException
		{
		try {
		
			this.menuBase = LoaderInformacionArchivos.leerInfoArchivoProductosMenu(archivoMenu);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		}	
	
	private void cargarCombos(String archivoCombos) throws FileNotFoundException, IOException
		{
		try {
			this.combos = LoaderInformacionArchivos.leerInfoArchivoCombos(archivoCombos, menuBase);
		}
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			}

}

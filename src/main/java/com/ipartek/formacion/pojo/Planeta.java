package com.ipartek.formacion.pojo;

/**
 * Clase para crear planetas. 
 * @
 * @author Josu Hernandez
 *
 */
public class Planeta {

	//Atributos  
		private long id;
		private String imagen;
		private String nombre;

		private static final int NEW = -1;
	
	/**
	 * Constructor de la clase Planeta
	 * @param img {@code String}  contiene URL con imagen del planeta
	 * @param nombre {@code String}  nombre del planeta
	 * @param distancia {@code Float}  distancia al planeta desde la Tierra en UA (Unidades Astronomicas 1UA=150.000.000 km)
	 */
//constructor vacio
	public Planeta() {
		super();
		this.id = NEW;   //lo inicializo con un valor que nunca va a tener un planeta
		this.imagen = "http://icdn.pro/images/en/a/s/astroid-moon-planet-icone-5626-128.png";
		this.nombre = "Nuevo Planeta";

	}
	
	//constructor con un parametro: el nombre
	public Planeta(String nombre) {
	    this();
		this.nombre = nombre;		
}
	
	//constructor con dos parametros: el nombre y el identificador
	public Planeta(String nombre, int id) {
		this();             //llama al constructor vacio por temas de herencia 
							//asi no necesitamos añadir en el código del constructor con un pàrametro 
							//los this.id, this.img
		this.id = id;		//identificador del planeta
		this.nombre = nombre;  
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getImagen (){
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	
	
	
	public boolean isNew() {
		return (this.id==NEW)?true:false;  
		
	}
	
	
	@Override
	public String toString() {
		return "Planeta [id=" + id + ", nombre=" + nombre + ", imagen=" + imagen + "]";
	}

}

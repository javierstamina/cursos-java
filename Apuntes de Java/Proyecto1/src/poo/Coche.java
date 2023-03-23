package poo;

public class Coche {
	private int ruedas; //solo es modificable desde la propia clase
	private int largo;
	private int ancho;
	private int motor;
	private int peso_plataforma;
	
	String color;
	int peso_total;
	boolean asientos_cuero,climatizador;
	
	//método
	public Coche() {
		ruedas=4;
		largo=2000;
		ancho=300;
		motor=1600;
		peso_plataforma=500;
	}
	
	//método getter
	public String dime_largo() {
		return "El largo del coche es: "+ largo;
	}
	
	//método setter: modificar el valor de los objetos
	public void establece_color() {
		color="azul";
	}
	
	//método getter
		public String dime_color() {
			return "El color del coche es: "+ color;
		}

}

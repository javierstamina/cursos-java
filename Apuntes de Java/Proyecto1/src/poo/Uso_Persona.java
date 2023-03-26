package poo;

import java.util.Date;
import java.util.GregorianCalendar;

public class Uso_Persona {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

abstract class Persona{
	
}

class Empleado2{
	//método constructor con parámetros
	public Empleado2(String nom, double sue, int agno,int mes, int dia) {
		nombre=nom;
		sueldo=sue;
		GregorianCalendar calendario = new GregorianCalendar(agno,mes-1,dia);
		altaContrato=calendario.getTime();
	}
	
	//sobrecarga de constructores
	public Empleado2(String nom) {
		//nombre=nom;
		this(nom,3000,2000,01,01);
	}
	
	public String dameNombre() {//getter
		return nombre;
		
	}
	public double dameSueldo() {//getter
		return sueldo;
	}
	public Date dameFechaContrato() {//getter
		return altaContrato;
	}
	public void subeSueldo(double porcentaje) {//setter
		double aumento=sueldo*porcentaje/100;
		sueldo+=aumento;
	}
	
	private String nombre;
	private double sueldo;
	private Date altaContrato;
}

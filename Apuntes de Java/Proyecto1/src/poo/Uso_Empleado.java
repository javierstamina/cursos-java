package poo;

import java.util.*;

public class Uso_Empleado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		Empleado empleado1= new Empleado("Paco Gomez",85000,1990,12,17);
		Empleado empleado2= new Empleado("Ana Lopez",95000,1995,6,2);
		Empleado empleado3= new Empleado("María",105000,2002,3,15);
		
		empleado1.subeSueldo(5);
		empleado2.subeSueldo(5);
		empleado3.subeSueldo(5);
		
		System.out.println("Nombre: " + empleado1.dameNombre()+" Sueldo: "+empleado1.dameSueldo()
		+ " Fecha de Alta: "+empleado1.dameFechaContrato());
		System.out.println("Nombre: " + empleado2.dameNombre()+" Sueldo: "+empleado2.dameSueldo()
		+ " Fecha de Alta: "+empleado2.dameFechaContrato());
		System.out.println("Nombre: " + empleado3.dameNombre()+" Sueldo: "+empleado3.dameSueldo()
		+ " Fecha de Alta: "+empleado3.dameFechaContrato());
		*/
		
		//Por ARRAYS
		
		Jefatura jefe_RRHH=new Jefatura("Juan",55000,2006,9,25);
		jefe_RRHH.estableceIncentivo(2570);
		
		Empleado[] misEmpleados=new Empleado[6];
		misEmpleados[0]=new Empleado("Paco Gomez",30000,1990,12,17);
		misEmpleados[1]=new Empleado("Ana Lopez",31000,1995,6,2);
		misEmpleados[2]=new Empleado("María",32000,2002,3,15);
		misEmpleados[3]=new Empleado("Javier");
		misEmpleados[4]=jefe_RRHH; //Polimorfismo, principio de sustitución
		misEmpleados[5]=new Jefatura("María",95000,1999,5,26);
		
		Jefatura jefa_Finanzas=(Jefatura) misEmpleados[5]; //Casting
		jefa_Finanzas.estableceIncentivo(5000);
		
		
		
		/*for(int i=0;i<3;i++) {
			misEmpleados[i].subeSueldo(5);
		}*/
		for(Empleado e: misEmpleados) {
			e.subeSueldo(5);
		}
		
		/*for(int i=0;i<3;i++) {
			System.out.println("Nombre: " + misEmpleados[i].dameNombre()+" Sueldo: "+misEmpleados[i].dameSueldo()
			+ " Fecha de Alta: "+misEmpleados[i].dameFechaContrato());
		}*/
		for(Empleado e: misEmpleados) {
			System.out.println("Nombre: " + e.dameNombre()+" Sueldo: "+e.dameSueldo() //enlazado dinámico
					+ " Fecha de Alta: "+e.dameFechaContrato());
		}
		
	}

}

class Empleado{
	//método constructor con parámetros
	public Empleado(String nom, double sue, int agno,int mes, int dia) {
		nombre=nom;
		sueldo=sue;
		GregorianCalendar calendario = new GregorianCalendar(agno,mes-1,dia);
		altaContrato=calendario.getTime();
	}
	
	//sobrecarga de constructores
	public Empleado(String nom) {
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

class Jefatura extends Empleado {
	
	public Jefatura(String nom, double sue,int agno, int mes, int dia) {
		super(nom, sue, agno, mes, dia);
	}
	
	public void estableceIncentivo(double b){
		incentivo=b;
	}
	public double dameSueldo() {
		double sueldoJefe=super.dameSueldo();
		return sueldoJefe + incentivo;
	}
	private double incentivo;
	
}

final class Director extends Jefatura{
	public Director(String nom, double sue,int agno, int mes, int dia){
		super(nom, sue, agno, mes, dia);
	}
}

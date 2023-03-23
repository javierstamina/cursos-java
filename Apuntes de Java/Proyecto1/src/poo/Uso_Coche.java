package poo;

public class Uso_Coche {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//INSTANCIAR UNA CLASE
		Coche Renault=new Coche();
		System.out.println(Renault.dime_largo());
		
		//acceder a getter y setter
		Renault.establece_color();
		System.out.println(Renault.dime_color());
		//System.out.println("Este coche tiene "+ Renault.ruedas+ " ruedas");
		//System.out.println("Este coche pesa "+ Renault.peso+" kg");
	}

}

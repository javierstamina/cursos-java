package misApplets;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Calculadora extends JApplet {

	public void init() {
		// TODO Auto-generated method stub
		// un applet es setVisible(true) por defecto
		// no necesita EXIT_ON_CLOSE porque no se cierra en el navegador
		// no tiene titulo
		// tampoco se especifican ancho y alto ni location con setBounds
		// en conclusion se elimina todo lo referente al JFrame
		LaminaCalculadora miLamina = new LaminaCalculadora();
		add(miLamina);
	}

}

class LaminaCalculadora extends JPanel {
	
	public LaminaCalculadora() {
		principio = true;
		setLayout(new BorderLayout());
		pantalla = new JButton("0");
		pantalla.setEnabled(false);
		add(pantalla, BorderLayout.NORTH);
		
		miLamina2 = new JPanel();
		miLamina2.setLayout(new GridLayout(4, 4));
				
		ActionListener insertar = new InsertaNumero();
		ActionListener orden = new AccionOrden();
		
		ponerBoton("7", insertar);
		ponerBoton("8", insertar);
		ponerBoton("9", insertar);
		ponerBoton("/", orden);
		
		ponerBoton("4", insertar);
		ponerBoton("5", insertar);
		ponerBoton("6", insertar);
		ponerBoton("*", orden);
		
		ponerBoton("1", insertar);
		ponerBoton("2", insertar);
		ponerBoton("3", insertar);
		ponerBoton("-", orden);
		
		ponerBoton("0", insertar);
		ponerBoton(".", insertar);
		ponerBoton("=", orden);
		ponerBoton("+", orden);
		
		add(miLamina2, BorderLayout.CENTER);
		ultimaOperacion = "=";
	}
	
	private void ponerBoton(String rotulo, ActionListener oyente) {
		JButton boton = new JButton(rotulo);
		boton.addActionListener(oyente);
		miLamina2.add(boton);
	}
	
	private class InsertaNumero implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String entrada = e.getActionCommand();
			if(principio){
				pantalla.setText("");
				principio = false;
			}
			pantalla.setText(pantalla.getText() + entrada);
		}
		
	}
	
	private class AccionOrden implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String operacion = e.getActionCommand();
			calcular(Double.parseDouble(pantalla.getText()));
			ultimaOperacion = operacion;
			principio = true;
		}
		
		public void calcular(double x) {
			if(ultimaOperacion.equals("+"))
				resultado += x;
			else if(ultimaOperacion.equals("-"))
				resultado -= x;
			else if(ultimaOperacion.equals("*"))
				resultado *= x;
			else if(ultimaOperacion.equals("/"))
				resultado /= x;
			else if(ultimaOperacion.equals("="))
				resultado = x;
			pantalla.setText(Double.toString(resultado));
		}
		
	}
	
	private JPanel miLamina2;
	private JButton pantalla;
	private boolean principio;
	private double resultado;
	private String ultimaOperacion;
	
}
package br.edu.udc.Modelo;

import br.edu.udc.Modelo.manipulador.ManipuladorFormaGeometrica;

public interface FormaGeometrica {
	
	public Ponto2D centro();
	public double area();
	public double perimetro();
	public double base();
	public double altura();
	
	public ManipuladorFormaGeometrica getManipulador();
	public FormaGeometrica clone();

}
package br.edu.udc.Modelo.manipulador;

import java.awt.Graphics;

import br.edu.udc.Modelo.Ponto2D;
import br.edu.udc.Modelo.Triangulo;

public class ManipuladorTriangulo implements ManipuladorFormaGeometrica {
	private Triangulo triangulo;
	
	public ManipuladorTriangulo(Triangulo t) {
		triangulo = t;
	}

	@Override
	public void click(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void press(int x, int y) {
		Ponto2D p = new Ponto2D(x, y);
		triangulo.setA(p);
		p = new Ponto2D(x, y);
		triangulo.setB(p);
	}

	@Override
	public void release(int x, int y) {
		Ponto2D p = new Ponto2D(x, y);
		triangulo.setB(p);
		
	}

	@Override
	public void drag(int x, int y) {
		Ponto2D p = new Ponto2D(x, y);
		triangulo.setB(p);
		
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		
	}

}
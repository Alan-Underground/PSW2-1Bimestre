package br.edu.udc16_3;

import br.edu.udc7_1.Ponto2D;

public class Aplicacao {

	public static void main (String [] args) {
		Pilha pilha = new Pilha();

		pilha.push(new Ponto2D(1, 2));
		pilha.push(new Ponto2D(3, 4));
		pilha.push(new Ponto2D(5, 6));
		pilha.push(new Ponto2D(7, 8));
		pilha.push(new Ponto2D(9, 10));
		pilha.push(new Ponto2D(11, 12));
		pilha.push(new Ponto2D(13, 14));
		pilha.push(new Ponto2D(15, 16));

		System.out.println("Tamanho Pilha: " + pilha.getTamanho());
		
		pilha.pop();
		pilha.pop();
		pilha.pop();
		pilha.pop();
		
		System.out.println("Tamanho Pilha: " + pilha.getTamanho());
	}
}
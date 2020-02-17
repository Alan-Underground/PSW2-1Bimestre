package br.edu.udc16_2;

public interface Iterador {
	Object getDado();
	Object proximo(); // Muda o nó para o próximo
	Object anterior(); // Muda o nó para o anterior
}
package br.edu.udc.Colecao;

public interface Iterador<T> {
	T getObjeto();
	T proximo();
	T anterior();
}

package br.edu.ud.raquete;

import java.io.Serializable;

public class Raquete implements Serializable { //marcamos que pode ser serialiavel

		float peso;
		String cor;
		String marca;
		int comprimento;


		public Raquete(float peso, String cor, int comprimento, String marca) {
			super();
			this.peso = peso;
			this.cor = cor;
			this.marca = marca;
			this.comprimento = comprimento;
		}

		public float getPeso() {
			return peso;
		}

		public void setPeso(float peso) {
			this.peso = peso;
		}

		public String getCor() {
			return cor;
		}

		public void setCor(String cor) {
			this.cor = cor;
		}

		public String getMarca() {
			return marca;
		}

		public void setMarca(String marca) {
			this.marca = marca;
		}

		public int getComprimento() {
			return comprimento;
		}

		public void setComprimento(int comprimento) {
			this.comprimento = comprimento;
		}

		public Raquete(float peso, String cor, int comprimento ) {
			super();
			this.peso = peso;
			this.cor = cor;
			this.comprimento = comprimento;
			this.marca = marca;
		}
		
		@Override
		public String toString() {
			return "Raquete [peso=" + peso + ", cor=" + cor + ", marca=" + marca + ", comprimento=" + comprimento + "]";
		}
		
		
}

//File writer gravo textos

// ObjectOutputStream grava objetos.



package br.edu.ud.raquete;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.StringTokenizer;

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
		//dependendo da configuração da maquina espera um ponto no float e dependendo da maquina espera uma virgula
		public String toFileString() {
			return   peso +"; "+ cor + "; "+ marca + "\n";
		}
		
		//statico não preciso ter uma instancia para usar ele.
		//uso static quando ele não usa atributos dessa classe, 
		//vou criar atributos dentro do metodo.
		public static Raquete fromFileString(String str) {
			String cor;
			float peso;
			int comprimento;
			StringTokenizer token = new StringTokenizer(str);
			peso = Float.parseFloat(token.nextToken(";").trim());
			cor = token.nextToken(";").trim();
			comprimento = Integer.parseInt(token.nextToken(";").trim());
		
			return new Raquete(peso, cor, comprimento);
		}
	public static int getSize() {
		return 4+4+30; //float + int + char[15]  //cada registro tem 38 bytes em disco
	}

	//assegura que o nome tenha um comprimento adequado
	private String readCor( RandomAccessFile file) throws IOException{
		 char cor[] = new char[15], temp;
		 
		 for (int count = 0; count < cor.length; count++) {
			 temp = file.readChar();
			 cor[ count] = temp;
		 }
		 return new String (cor).replace( '\0',' ').trim();
		 }
	
	private void writeCor( RandomAccessFile file, String cor) throws IOException{
		StringBuffer buffer = null;
		
		if(cor != null)
			buffer = new StringBuffer (cor);
		else buffer = new StringBuffer(15);
		
		buffer.setLength(15);
		file.writeChars(buffer.toString());
	}
	//grava um registro no RamdomAccessFile especificado
	public void write( RandomAccessFile file) throws IOException
	{
		file.writeFloat(peso);
		writeCor(file,cor);
		file.writeInt(comprimento);	
	}
	
	//le um registro em um RamdomAccessFile especificado
		public void read( RandomAccessFile file) throws IOException
		{
			setPeso(file.readFloat());
			setCor(readCor(file));
			setComprimento(file.readInt());
		}
	
	
	
	
}





//File writer gravo textos

// ObjectOutputStream grava objetos.



package br.edu.ud.raquete;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

public class Aplicacao {

	//private FileWriter output;
	
	
	public static void main(String[] args) {
		new Aplicacao();
	}
	
	public Aplicacao() {
		Raquete raquete = lerRaquete();
		
		System.out.println("A sua raquete: " + raquete);
		
		FileWriter output = openFile();  //instancia um output, 
		
		try {
			output.append(raquete.toString());//passo a string para dar o append no arquivo
			output.append(String.format("\nAgora vou asalvar a raquete diferente:\n"));
			output.append(String.format("A raquete é %s, tem peso %.2f kg e comprimento %d mm e a marca é %s.",raquete.getCor(), raquete.getPeso(), raquete.getComprimento(), raquete.getMarca()));
			output.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		try {
			output.close(); //fechar o arquivo
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		ObjectOutputStream objectOutput = writeObjectFile(); //dessa forma fala que não é serializavel,  temos que mudar a classe raquete (implements Serializabl)
		try {
			objectOutput.writeObject(raquete);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			objectOutput.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		System.out.println("FIM");		
		
	
		System.out.println("FIM!");
	}
	
	
	
	static Raquete lerRaquete() {
		float peso;
		String cor;
		int comprimento;
		String marca;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Qual o peso da raquete  (em quilos)?");
		peso = sc.nextFloat();
		System.out.println("Qual o comprimento da raquete (em milimetros)?");
		comprimento = sc.nextInt();
		System.out.println("Qual é a cor da raquete? ");
		cor = sc.nextLine();
		System.out.println("Qual é a marca da raquete? ");
		marca = sc.nextLine();
		
		Raquete raquete = new Raquete(peso, cor, comprimento, marca);
		sc.close();
		return raquete;
	}
	
	//abrir o arquivo
	public FileWriter openFile() {
		FileWriter output = null;
		try {
			output = new FileWriter("raquetes.txt"); // se passar so o nome ele cria no diretorio corrente, ou passar o caminho completo (linux e windows são diferentes)
		}//fim do try
		
		//começar o catch com a excessão mais especifica primeiro, pq começa a testar de cima para baixo.
		
		catch(SecurityException securityException) { //sem acesso
			System.err.println("You do not have write access to this file.");
			System.exit(1);
		}//fim do catch
		catch (FileNotFoundException filesNotFoundException) { 
			System.err.println("Error creating file.");
			System.exit(1);
		}//fim do catch
		catch (IOException e) { // 
			System.err.println( "Error creating file." );
			System.exit(1);
			//e.printstackTrace
		}
		return output;
	}
	
	public ObjectOutputStream writeObjectFile() {
		ObjectOutputStream oos = null;

	try {
		oos = new ObjectOutputStream( new FileOutputStream("raquetes.serial") );
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	return oos;
	}
}

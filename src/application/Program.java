package application;

import java.util.Scanner;

import entities.Escala12x36;
import entities.Escala4x2;
import entities.Escala6x1alt;
import entities.Folga;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(
				"Digite a data da sua ultima folga! Se sua escala for 4x2 digite a ultima vez que folgou o segundo dia. (dd/MM/aaaa). ");
		String ultFolga = sc.next();

		System.out.println("Digite a data que deseja saber se estará de folga (dd/MM/aaaa): ");
		String pesqFolga = sc.next();

		System.out.println("Qual sua escala? ");
		System.out.println("1 - 4x2");
		System.out.println("2 - 6x1");
		System.out.println("3 - 12x36");

		int opç = sc.nextInt();

		Folga escala;

		if (opç == 1) {
			escala = new Escala4x2(ultFolga, pesqFolga);
		}

		else if (opç == 2) {
			escala = new Escala6x1alt(ultFolga, pesqFolga);
		}

		else {
			escala = new Escala12x36(ultFolga, pesqFolga);
		}

		escala.pesquisarFolga();

		sc.close();
	}
}
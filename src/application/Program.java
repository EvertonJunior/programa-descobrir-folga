package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

import entities.Escala12x36;
import entities.Escala4x2;
import entities.Escala6x1alt;
import entities.Folga;
import model.exception.DomainException;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		try {
			System.out.println(
					"Digite a data da sua ultima folga! Se sua escala for 4x2 digite a ultima vez que folgou o segundo dia. (dd/MM/aaaa). ");
			LocalDate ultFolga = LocalDate.parse(sc.next(), formatter);

			System.out.println("Digite a data que deseja saber se estará de folga (dd/MM/aaaa): ");
			LocalDate pesqFolga = LocalDate.parse(sc.next(), formatter);
			System.out.println("Qual sua escala? ");
			System.out.println("1 - 4x2");
			System.out.println("2 - 6x1");
			System.out.println("3 - 12x36");

			int opç = sc.nextInt();

			Folga escala = null;

			switch (opç) {
			case 1:
				escala = new Escala4x2(ultFolga, pesqFolga);
				break;
			case 2:
				escala = new Escala6x1alt(ultFolga, pesqFolga);
				break;
			case 3:
				escala = new Escala12x36(ultFolga, pesqFolga);
				break;
			default:
				System.out.println("Opção inválida!");
				break;
			}

			escala.pesquisarFolga();

		} catch (DateTimeParseException e) {
			System.out.println("Digite um formato de data válido. (dd/MM/aaaa)");
		} catch (InputMismatchException e) {
			System.out.println("Digite apenas números! ");
		} catch (DomainException e) {
			System.out.println("Data inválida: " + e.getMessage());
		} catch (NullPointerException e) {
			System.out.println("Escolha alguma escala! ");
		}
		sc.close();
	}
}

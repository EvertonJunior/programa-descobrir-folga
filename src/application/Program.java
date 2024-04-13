package application;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		Locale localeBR = new Locale("pt", "BR");

		System.out.println("Digite sua escala: ");
		System.out.println("1 - 4x2");
		System.out.println("2 - 6x1 (SAB/DOM alternados)");
		System.out.println("3 - 12x36");

		int opcao = sc.nextInt();

		if (opcao == 1) {
			System.out.println("Digite a data do seu último segundo dia de folga: (dd/MM/aaaa) ");
			String data1 = sc.next();
			LocalDate ultimaFolga = LocalDate.parse(data1, formatter);

			System.out.println("Digite a data que deseja saber se estará de folga: (dd/MM/aaaa) ");
			String data2 = sc.next();
			LocalDate pesqFolga = LocalDate.parse(data2, formatter);
			DayOfWeek diaDaSemana = pesqFolga.getDayOfWeek();
			String txtDiaDaSemana = diaDaSemana.getDisplayName(TextStyle.FULL, localeBR);

			long diferencaDias = ultimaFolga.until(pesqFolga, ChronoUnit.DAYS);

			if (diferencaDias < 0) {
				System.out.println("A data pesquisada é antes da ultima folga! ");
			}

			else if (diferencaDias % 6 == 0) {
				System.out.println("No dia " + data2 + " " + txtDiaDaSemana + " será o segundo dia de folga!");
			}

			else if ((diferencaDias + 1) % 6 == 0) {
				System.out.println("No dia " + data2 + " " + txtDiaDaSemana + " será o primeiro dia de folga!");
			}

			else {
				System.out.println("No dia " + data2 + " " + txtDiaDaSemana + " não estará de folga!");
			}

		}

		else if (opcao == 2) {
			System.out.println("Digite a data da sua ultima folga (sab/dom) : (dd/MM/aaaa)");
			String data1 = sc.next();
			LocalDate ultimaFolga = LocalDate.parse(data1, formatter);

			System.out.println("Digite a data que deseja saber se estará de folga: (dd/MM/aaaa) ");
			String data2 = sc.next();
			LocalDate pesqFolga = LocalDate.parse(data2, formatter);
			DayOfWeek diaDaSemana = pesqFolga.getDayOfWeek();
			DayOfWeek diaDaSemana2 = ultimaFolga.getDayOfWeek();
			String txtDiaDaSemana = diaDaSemana.getDisplayName(TextStyle.FULL, localeBR);
			String txtDiaDaSemana2 = diaDaSemana2.getDisplayName(TextStyle.FULL, localeBR);

			long diferencaDias = ultimaFolga.until(pesqFolga, ChronoUnit.DAYS);

			if (diferencaDias < 0) {
				System.out.println("A data pesquisada é antes da ultima folga! ");
			}
			
			else {
				if (txtDiaDaSemana2.equals("sábado")) {
					if (diferencaDias == 8 || diferencaDias % 14 == 0 || (diferencaDias - 8)% 14 == 0) {
						System.out.println("No dia " + data2 + " " + txtDiaDaSemana + " estará de folga!");
					}
					else {
						System.out.println("No dia " + data2 + " " + txtDiaDaSemana + " não estará de folga!");
					}
				}
				
				else if (txtDiaDaSemana2.equals("domingo")) {
					if (diferencaDias == 6 || diferencaDias % 14 == 0 || (diferencaDias - 6)% 14 == 0) {
						System.out.println("No dia " + data2 + " " + txtDiaDaSemana + " estará de folga!");
					}
					else {
						System.out.println("No dia " + data2 + " " + txtDiaDaSemana + " não estará de folga!");
					}
				}
				
				else {
					System.out.println("Ultima folga digitada não é sab/dom");
				}
			}
		}

		else if (opcao == 3) {
			System.out.println("Digite a data da sua ultima folga: (dd/MM/aaaa)");
			String data1 = sc.next();
			LocalDate ultimaFolga = LocalDate.parse(data1, formatter);

			System.out.println("Digite a data que deseja saber se estará de folga: (dd/MM/aaaa)");
			String data2 = sc.next();
			LocalDate pesqFolga = LocalDate.parse(data2, formatter);
			DayOfWeek diaDaSemana = pesqFolga.getDayOfWeek();
			String txtDiaDaSemana = diaDaSemana.getDisplayName(TextStyle.FULL, localeBR);

			long diferencaDias = ultimaFolga.until(pesqFolga, ChronoUnit.DAYS);

			if (diferencaDias < 0) {
				System.out.println("A data pesquisada é antes da ultima folga! ");
			}

			else if (diferencaDias % 2 == 0) {
				System.out.println("No dia " + data2 + " " + txtDiaDaSemana + " estará de folga!");
			}

			else {
				System.out.println("No dia " + data2 + " " + txtDiaDaSemana + " não estará de folga!");
			}

		}

		else {
			System.out.println("Opção inválida!");
		}

		System.out.println(" ");
		System.out.println("PROGRAMA ENCERRADO.");

	}

}
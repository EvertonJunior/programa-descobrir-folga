package entities;

import java.time.LocalDate;

import model.exception.DomainException;

public class Escala4x2 extends Folga {

	public Escala4x2() {

	}

	public Escala4x2(LocalDate ultFolga, LocalDate pesqFolga) {
		super(ultFolga, pesqFolga);
	}

	@Override
	public void pesquisarFolga() throws DomainException {
		if (diferencaDias(ultFolga, pesqFolga) % 6 == 0) {
			System.out.println(
					"No dia " + formatter.format(pesqFolga) + " " + dia(pesqFolga) + " será o segundo dia de folga!");
		}

		else if ((diferencaDias(ultFolga, pesqFolga) + 1) % 6 == 0) {
			System.out.println(
					"No dia " + formatter.format(pesqFolga) + " " + dia(pesqFolga) + " será o primeiro dia de folga!");
		}

		else {
			System.out
					.println("No dia " + formatter.format(pesqFolga) + " " + dia(pesqFolga) + " não estará de folga!");
		}
	}

}
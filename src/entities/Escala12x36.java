package entities;

import java.time.LocalDate;

import model.exception.DomainException;

public class Escala12x36 extends Folga {

	public Escala12x36() {

	}

	public Escala12x36(LocalDate ultFolga, LocalDate pesqFolga) {
		super(ultFolga, pesqFolga);
	}

	@Override
	public void pesquisarFolga() throws DomainException {
		if (diferencaDias(ultFolga, pesqFolga) % 2 == 0) {
			System.out.println("No dia " + formatter.format(pesqFolga) + " " + dia(pesqFolga) + " estará de folga!");
		}

		else {
			System.out
					.println("No dia " + formatter.format(pesqFolga) + " " + dia(pesqFolga) + " não estará de folga!");
		}
	}

}
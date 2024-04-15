package entities;

import java.time.LocalDate;

import model.exception.DomainException;

public class Escala6x1alt extends Folga {

	public Escala6x1alt() {

	}

	public Escala6x1alt(LocalDate ultFolga, LocalDate pesqFolga) {
		super(ultFolga, pesqFolga);
	}

	@Override
	public void pesquisarFolga() throws DomainException {
		String diaSemana = dia(ultFolga);

		switch (diaSemana) {
		case "sábado":
			if (diferencaDias(ultFolga, pesqFolga) == 8 || diferencaDias(ultFolga, pesqFolga) % 14 == 0
					|| (diferencaDias(ultFolga, pesqFolga) - 8) % 14 == 0) {
				System.out
						.println("No dia " + formatter.format(pesqFolga) + " " + dia(pesqFolga) + " estará de folga!");
			} else {
				System.out.println(
						"No dia " + formatter.format(pesqFolga) + " " + dia(pesqFolga) + " não estará de folga!");
			}
			break;
		case "domingo":
			if (diferencaDias(ultFolga, pesqFolga) == 6 || diferencaDias(ultFolga, pesqFolga) % 14 == 0
					|| (diferencaDias(ultFolga, pesqFolga) - 6) % 14 == 0) {
				System.out
						.println("No dia " + formatter.format(pesqFolga) + " " + dia(pesqFolga) + " estará de folga!");
			} else {
				System.out.println(
						"No dia " + formatter.format(pesqFolga) + " " + dia(pesqFolga) + " não estará de folga!");
			}
			break;
		default:
			System.out.println(diaSemana + " como ultima folga não é válida: Apenas sab/dom");
			break;
		}

	}

}
package entities;

import java.time.DayOfWeek;
import java.time.format.TextStyle;

public class Escala6x1alt extends Folga {

	public Escala6x1alt() {

	}

	public Escala6x1alt(String ultFolga, String pesqFolga) {
		super(ultFolga, pesqFolga);
	}

	@Override
	public void pesquisarFolga() {

		
		if (dia(ultFolga).equals("sábado")){
			if (diferencaDias == 8 || diferencaDias % 14 == 0 || (diferencaDias - 8) % 14 == 0) {
				System.out.println("No dia " + formatter.format(pesqFolga) + " " + dia(pesqFolga) +  " estará de folga!");
			}
			else {
				System.out.println("No dia " + formatter.format(pesqFolga) + " " + dia(pesqFolga) +  " não estará de folga!");
			}
		}
		if (dia(ultFolga).equals("domingo")){
			if (diferencaDias == 6 || diferencaDias % 14 == 0 || (diferencaDias - 6) % 14 == 0) {
				System.out.println("No dia " + formatter.format(pesqFolga) + " " + dia(pesqFolga) +  " estará de folga!");
			}
			else {
				System.out.println("No dia " + formatter.format(pesqFolga) + " " + dia(pesqFolga) +  " não estará de folga!");
			}
		}
		
	}

}
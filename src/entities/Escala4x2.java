package entities;

public class Escala4x2 extends Folga {

	public Escala4x2() {

	}

	public Escala4x2(String ultFolga, String pesqFolga) {
		super(ultFolga, pesqFolga);
	}

	@Override
	public void pesquisarFolga() {
		if (diferencaDias % 6 == 0) {
			System.out.println("No dia " + formatter.format(pesqFolga) + " " + dia(pesqFolga) + " será o segundo dia de folga!");
		}

		else if ((diferencaDias + 1) % 6 == 0) {
			System.out.println("No dia " + formatter.format(pesqFolga) + " " + dia(pesqFolga) +  " será o primeiro dia de folga!");
		}

		else {
			System.out.println("No dia " + formatter.format(pesqFolga) + " " + dia(pesqFolga) +  " não estará de folga!");
		}
	}

}
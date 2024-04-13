package entities;

public class Escala12x36 extends Folga {

	public Escala12x36() {

	}

	public Escala12x36(String ultFolga, String pesqFolga) {
		super(ultFolga, pesqFolga);
	}

	@Override
	public void pesquisarFolga() {
		if (diferencaDias % 2 == 0){
			System.out.println("No dia " + formatter.format(pesqFolga) + " " + dia(pesqFolga) +  " estará de folga!");
		}

		else {
			System.out.println("No dia " + formatter.format(pesqFolga) + " " + dia(pesqFolga) +  " não estará de folga!");
		}
	}

}
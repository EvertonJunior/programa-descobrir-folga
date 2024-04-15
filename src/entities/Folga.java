package entities;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

import model.exception.DomainException;

public abstract class Folga {
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	Locale localeBR = new Locale("pt", "BR");

	protected LocalDate ultFolga;
	protected LocalDate pesqFolga;

	public Folga() {
	}

	public Folga(LocalDate ultFolga, LocalDate pesqFolga) {
		this.ultFolga = ultFolga;
		this.pesqFolga = pesqFolga;
	}

	public LocalDate getUltFolga() {
		return ultFolga;
	}

	public void setUltFolga(LocalDate ultFolga) {
		this.ultFolga = ultFolga;
	}

	public LocalDate getPesqFolga() {
		return pesqFolga;
	}

	public void setPesqFolga(LocalDate pesqFolga) {
		this.pesqFolga = pesqFolga;
	}

	public abstract void pesquisarFolga() throws DomainException;

	public long diferencaDias(LocalDate ultFolga, LocalDate pesqFolga) throws DomainException {
		LocalDate agr = LocalDate.now();
		if (ultFolga.isAfter(agr)) {
			throw new DomainException("A data digitada da última folga é depois do dia atual");
		}
		if (pesqFolga.isBefore(ultFolga)) {
			throw new DomainException(
					"A data digitada para para descobrir se estará de folga é anterior a data da sua última folga");
		}
		return this.ultFolga.until(this.pesqFolga, ChronoUnit.DAYS);

	}

	public String dia(LocalDate date) {
		DayOfWeek day = date.getDayOfWeek();
		return day.getDisplayName(TextStyle.FULL, localeBR);
	}

}
package entities;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public abstract class Folga {
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	Locale localeBR = new Locale("pt", "BR");
	
	protected LocalDate ultFolga;
	protected LocalDate pesqFolga;
	protected long diferencaDias;
	
	public Folga() {
	}

	public Folga(String ultFolga, String pesqFolga) {
		this.ultFolga = LocalDate.parse(ultFolga, formatter);
		this.pesqFolga = LocalDate.parse(pesqFolga, formatter);
		diferencaDias = this.ultFolga.until(this.pesqFolga, ChronoUnit.DAYS);
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

	public long getDiferencaDias() {
		return diferencaDias;
	}

	public void setDiferencaDias(long diferencaDias) {
		this.diferencaDias = diferencaDias;
	}

	public abstract void pesquisarFolga();
	
	public String dia(LocalDate date) {
		DayOfWeek day = date.getDayOfWeek();
		return day.getDisplayName(TextStyle.FULL, localeBR);
	}

}
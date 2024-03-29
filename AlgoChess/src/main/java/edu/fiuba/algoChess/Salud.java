package edu.fiuba.algoChess;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public abstract class Salud implements Curable, Herible {

	@Getter
	@Setter
	int valorCompleto;

	@Getter
	@Setter
	int valorActual;

	@Override
	public abstract Salud curar(int salud);

	public Salud morir(){
		this.valorActual = 0;
		return new SaludMuerto();
	}

	public Salud llenar(){

		return new SaludLlena(this.valorCompleto);
	}

	// Herramienta para testing
	public boolean igualA(Salud salud) {
		return (this.getValorCompleto() == salud.getValorCompleto() && this.getValorActual() == salud.getValorActual());
	}
}

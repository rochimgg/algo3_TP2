package edu.fiuba.algoChess;

public class SaludLlena extends Salud {

	SaludLlena(int salud){
		super(salud,salud);
	}

	@Override
	public Salud curar(int salud) {
		return this;
	}

	@Override
	public Salud herir(int salud) {
		setValorActual(this.getValorActual()-salud);
		return this.getValorActual() == this.getValorCompleto()? this : new SaludMedia(this.getValorCompleto(),this.getValorActual());
	}

}

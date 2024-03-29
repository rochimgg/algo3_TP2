package edu.fiuba.algoChess;

import java.util.Optional;

public class Celda {

	private Optional<Pieza> piezaActual;
	private Bando sectorDelJugador;

	public Celda(){
		this.piezaActual = Optional.empty();
	}

	public Celda(Bando bando){
		this.piezaActual = Optional.empty();
		this.sectorDelJugador = bando;
	}


	public boolean isEmpty() {return this.piezaActual.isEmpty();}

	public Pieza getPiezaActual(){return this.piezaActual.get();}

	public Optional<Pieza> getContenido(){return this.piezaActual;}

/*	public void moverA(Celda nuevaCelda) {
		nuevaCelda.piezaActual = this.piezaActual;
		this.piezaActual = Optional.empty();
	}
*/

	public void setSectorDelJugador(Bando bandoJugador){
		this.sectorDelJugador = bandoJugador;
	}

	public Bando getSectorDelJugador(){ return this.sectorDelJugador;}

	public void guardar(Pieza piezaActual) {
		if (!this.sectorDelJugador.equals(piezaActual.getBando())  ) { //ESTA LINEA SOLO VALE EN LA PRIMERA ETAPA DEL JUEGO!!! AGREGAR OTRA CONDICION AL IF!!!
			throw new NoSePuedeUbicarPiezaEnSectoRival("No se puede ubicar pieza en sector rival");
		} else {
			this.piezaActual = Optional.of(piezaActual);
		}
	}

/*	public void ubicar(Pieza piezaActual) {
		this.estado.ubicar(Optional.of(piezaActual), this);
	} //capturar exception de ocupado o sectorEnemigo
*/
	public void eliminar() {
		this.piezaActual = Optional.empty();
	}

}
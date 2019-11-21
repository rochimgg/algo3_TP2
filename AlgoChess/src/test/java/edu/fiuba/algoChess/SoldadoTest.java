package edu.fiuba.algoChess;

import org.junit.Test;

import static junit.framework.TestCase.*;
import static org.junit.Assert.assertEquals;

public class SoldadoTest {

	@Test
	public void test00SeVerificaBatallon(){
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Tablero tableroTest = new Tablero(jugador1, jugador2);
		Soldado soldado1 = new Soldado(new Ubicacion(2,2));
		Soldado soldado2 = new Soldado(new Ubicacion(3,2));
		Soldado soldado3 = new Soldado(new Ubicacion(4,2));
		soldado1.setJugador(jugador1);
		soldado2.setJugador(jugador1);
		soldado3.setJugador(jugador1);
		tableroTest.ubicarEnCelda(soldado1, soldado1.getUbicacion());
		tableroTest.ubicarEnCelda(soldado2, soldado2.getUbicacion());
		tableroTest.ubicarEnCelda(soldado3, soldado3.getUbicacion());

		assertTrue(Batallon.esBatallon(soldado1,soldado2,soldado3,tableroTest));

	}

	@Test
	public void test01TresSoldadosContiguosSeMuevenEnLaMismaDireccion(){
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Tablero tableroTest = new Tablero(jugador1, jugador2);
		Soldado soldado1 = new Soldado(new Ubicacion(2,2));
		Soldado soldado2 = new Soldado(new Ubicacion(3,2));
		Soldado soldado3 = new Soldado(new Ubicacion(4,2));
		soldado1.setJugador(jugador1);
		soldado2.setJugador(jugador1);
		soldado3.setJugador(jugador1);
		tableroTest.ubicarEnCelda(soldado1, soldado1.getUbicacion());
		tableroTest.ubicarEnCelda(soldado2, soldado2.getUbicacion());
		tableroTest.ubicarEnCelda(soldado3, soldado3.getUbicacion());

		Batallon batallon = soldado1.verificaBatallonONull(tableroTest);

		batallon.moverseArriba(tableroTest);

		assertEquals(batallon.getSoldado1().getUbicacion(), new Ubicacion(4,3));
		assertEquals(batallon.getSoldado2().getUbicacion(), new Ubicacion(3,3));
		assertEquals(batallon.getSoldado3().getUbicacion(), new Ubicacion(2,3));

	}

	@Test
	public void test02TresSoldadosConObstaculoSeMuevenDos(){
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Tablero tableroTest = new Tablero(jugador1, jugador2);
		Soldado soldado1 = new Soldado(new Ubicacion(2,2));
		Soldado soldado2 = new Soldado(new Ubicacion(3,2));
		Soldado soldado3 = new Soldado(new Ubicacion(4,2));
		Jinete jinete = new Jinete(new Ubicacion(1,2));


	}

	@Test
	public void test03TresSoldadosConObstaculoDisuelveBatallon(){
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Tablero tableroTest = new Tablero(jugador1, jugador2);
		Soldado soldado1 = new Soldado(new Ubicacion(2,2));
		Soldado soldado2 = new Soldado(new Ubicacion(3,2));
		Soldado soldado3 = new Soldado(new Ubicacion(4,2));
		Jinete jinete = new Jinete(new Ubicacion(1,2));
	}

	@Test
	public void test04CuatroSoldadosContiguosMuevenTres(){
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Tablero tableroTest = new Tablero(jugador1, jugador2);
		Soldado soldado1 = new Soldado(new Ubicacion(2,2));
		Soldado soldado2 = new Soldado(new Ubicacion(3,2));
		Soldado soldado3 = new Soldado(new Ubicacion(4,2));
		Soldado soldado4 = new Soldado(new Ubicacion(5,2));

	};

	@Test
	public void test05SoldadoAtacaJineteCercano(){
		Soldado soldado = new Soldado();
		Ubicacion ubicacionSoldado = new Ubicacion(1,1);
		soldado.setUbicacion(ubicacionSoldado);
		Jinete jinete = new Jinete();
		Ubicacion ubicacionJinete = new Ubicacion(1,2);
		jinete.setUbicacion(ubicacionJinete);
		DistanciaRelativa distanciaJineteASoldado = soldado.getDistanciaRelativa(jinete);
		//	assertTrue(distanciaJineteASoldado instanceof DistanciaRelativa);
		int vidaTrasAtaque = jinete.getVida() - soldado.getAtaqueCercano();
		soldado.ejecutarComportamiento(distanciaJineteASoldado,jinete);
		assertEquals(vidaTrasAtaque,jinete.getVida());
	};

	@Test
	public void test06SoldadoAtacaJineteLejanoYNoSeQuitaVidaAJineteAtacado(){
		Soldado soldado = new Soldado();
		Ubicacion ubicacionSoldado = new Ubicacion(1,1);
		soldado.setUbicacion(ubicacionSoldado);
		Jinete jinete = new Jinete();
		Ubicacion ubicacionJinete = new Ubicacion(10,20);
		jinete.setUbicacion(ubicacionJinete);
		DistanciaRelativa distanciaJineteASoldado = soldado.getDistanciaRelativa(jinete);
		//	assertTrue(distanciaJineteASoldado instanceof DistanciaRelativa);
		int vidaTrasAtaque = jinete.getVida() - soldado.getAtaqueLejano();
		soldado.ejecutarComportamiento(distanciaJineteASoldado,jinete);
		assertEquals(vidaTrasAtaque,jinete.getVida());
	};

}
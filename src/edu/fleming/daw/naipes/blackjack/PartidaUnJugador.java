package edu.fleming.daw.naipes.blackjack;

import edu.fleming.daw.naipes.Mazo;
import edu.fleming.daw.naipes.Naipe;

public class PartidaUnJugador {

	private MazoBJ deck = new MazoBJ();
	private Mazo descarte = new Mazo();
	private Mano crupier = new Mano();
	private Mano jugador = new Mano();
	private boolean finalizada = false;
	
	public boolean repartir() {
		if (finalizada)
			System.out.println("No puedo repartir, la partida no ha finalizado.");
		else {
			if (crupier.numeroNaipes() > 0)
				descarte.add(crupier);
			if (jugador.numeroNaipes() > 0)
				descarte.add(jugador);
			if (deck.numeroNaipes() < 52)
				deck.add(descarte);
			jugador.add(deck.getNaipe());
			jugador.add(deck.getNaipe());
			finalizada = jugador.getValor() == 21;
			crupier.add(deck.getNaipe());
			crupier.add(deck.getNaipe());
		}
		return finalizada;
	}
	
	public boolean pedir() {
		if (finalizada)
			System.out.println("El jugador no puede pedir, la partida ha finalizado.");
		else {
			jugador.add(deck.getNaipe());
			if (deck.numeroNaipes() < 52)
				deck.add(descarte);
			finalizada = jugador.getValor() >= 21;
		}
		return finalizada;
	}
	
	public boolean plantarse() {
		while (crupier.getValor() < 17)
			crupier.add(deck.getNaipe());
		return finalizada = true;
	}
	
	public int getValorCrupier() {
		return crupier.getValor();
	}
	
	public int getValorJugador() {
		return jugador.getValor();
	}
	
	public boolean isCrupierBlackjack() {
		return crupier.isBlackjack();
	}
	
	public boolean isJugadorBlackjack() {
		return jugador.isBlackjack();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Crupier: ");
		sb.append(crupier.toString(!finalizada));
		sb.append(System.getProperty("line.separator"));
		sb.append("jugador: ");
		sb.append(jugador.toString(false));
		sb.append(System.getProperty("line.separator"));
		return sb.toString();
	}
	
}

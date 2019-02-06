package edu.fleming.daw.naipes.blackjack;

import java.util.Iterator;

import edu.fleming.daw.naipes.Id;
import edu.fleming.daw.naipes.Mazo;
import edu.fleming.daw.naipes.Naipe;

public class Mano extends Mazo {
	
	public int getValor() {
		int valor = 0;
		Iterator<Naipe> i = naipes.iterator();
		while (i.hasNext()) {
			Naipe n = i.next();
			valor += n.getRango();
			if (n.getId() == Id.AS && valor <12)
				valor += 10;
		}
		return valor;
	}
	
	public boolean isBlackjack() {
		return getValor() == 21 && naipes.size() == 2;
	}
	
	public String toString(boolean ocultar) {
		StringBuilder sb = new StringBuilder();
		Iterator<Naipe> i = naipes.iterator();
		while (i.hasNext()) {
			Naipe n = i.next();
			if (ocultar && naipes.indexOf(n) == 0)
				sb.append("***");
			else
				sb.append(n.toString());
		}
		if (!ocultar) {
			sb.append(" = ");
			sb.append(getValor());
			if (isBlackjack())
				sb.append(" - BLACKJACK");
		}
		return sb.toString();	
	}
	
}

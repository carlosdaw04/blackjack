package edu.fleming.daw.naipes.blackjack;

import java.util.Scanner;

public class BlackjackUnJugadorConsola {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean f ;
		
		PartidaUnJugador partida = new PartidaUnJugador();
		
		System.out.println("comienza la partida de blackjack");
		
		f=partida.repartir();
		
		
		System.out.println(partida.toString() );
		
		while(!f) {
			System.out.println("desea otra carta(si/no)");
			String r = sc.next();
			while(!r.equalsIgnoreCase("si") && !r.equalsIgnoreCase("no") ) {
				System.out.println("respuesta no valida , introduzca una respuesta valida");
				r=sc.next();
			}
			if(r.equalsIgnoreCase("SI")) {
				f=partida.pedir();
			}else{
				f=partida.plantarse();
			}
			
			System.out.println(partida.toString() );
		}
		
	}

}

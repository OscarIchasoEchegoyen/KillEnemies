package org.cuatrovientos.KillEnemies;

import java.io.Serializable;
import java.util.ArrayList;

public class GameState implements Serializable {

	private static final long serialVersionUID = 1L;

	private Hero hero;
	private ArrayList<Character> personajes;

	public GameState(Hero hero, ArrayList<Character> personajes) {
		this.hero = hero;
		this.personajes = personajes;
	}

	public Hero getHero() {
		return hero;
	}

	public ArrayList<Character> getPersonajes() {
		return personajes;
	}
}

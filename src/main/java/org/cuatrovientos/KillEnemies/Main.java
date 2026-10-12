package org.cuatrovientos.KillEnemies;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);

		System.out.print("Introduce el nombre de tu héroe: ");
		String nombre = teclado.nextLine();

		Hero hero = new Hero(nombre);

		ArrayList<Character> personajes = new ArrayList<>();

		for (int i = 0; i < 5; i++) {
			personajes.add(new Friend());
			personajes.add(new Enemy());
		}
		showCharacters(personajes);
		Collections.shuffle(personajes);

		System.out.println("\nEl héroe " + hero.getNombre() + " comienza la aventura\n");

		for (Character personaje : personajes) {

			if (personaje.isEnemy()) {
				Enemy enemy = (Enemy) personaje;
				hero.attack(enemy);
			} else {
				if (personaje instanceof Friend) {
					Friend friend = (Friend) personaje;
					hero.defend(friend);
				}
			}

		}

		System.out.println("\n--- ESTADÍSTICAS DEL HÉROE ---");
		System.out.println("Héroe: " + hero.getNombre());
		System.out.println("Enemigos matados: " + hero.getEnemigosMatados());
		System.out.println("Amigos defendidos: " + hero.getAmigosDefendidos());

		teclado.close();
	}
	
	public static void showCharacters(ArrayList<Character> personajes) {

		int amigos = 0;
		int enemigos = 0;

		for (Character personaje : personajes) {

		    if (personaje.isEnemy()) {
		        enemigos++;
		    } else if (personaje instanceof Friend) {
		        amigos++;
		    }

		}

		System.out.println("\n--- PERSONAJES ---");
		System.out.println("Amigos: " + amigos);
		System.out.println("Enemigos: " + enemigos);

		}

}

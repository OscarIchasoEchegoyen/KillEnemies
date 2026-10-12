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

		Collections.shuffle(personajes);

		System.out.println("\n¡El héroe " + hero.getNombre() + " comienza la aventura!");

		boolean salir = false;

		while (!salir && !personajes.isEmpty()) {

			showCharacters(personajes);
			System.out.println();
			countCharacters(personajes);

			System.out.println("\n1. Atacar a un personaje");
			System.out.println("2. Defender a un personaje");
			System.out.println("0. Salir");
			System.out.print("Elige una opción: ");

			int opcion = teclado.nextInt();

			if (opcion == 0) {
				salir = true;

			} else if (opcion == 1 || opcion == 2) {

				System.out.print("Introduce el índice del personaje: ");
				int indice = teclado.nextInt();

				if (indice < 0 || indice >= personajes.size()) {
					System.out.println("Índice incorrecto.");

				} else {

					Character personaje = personajes.get(indice);

					if (opcion == 1) {

						if (personaje instanceof Enemy) {
							hero.attack((Enemy) personaje);
							personajes.remove(indice);

						} else {
							System.out.println("¡Has atacado a un amigo!");
							personajes.remove(indice);
						}

					} else {

						if (personaje instanceof Friend) {
							Friend amigo = (Friend) personaje;
							hero.defend(amigo);
							amigo.heal();

						} else {
							System.out.println("¡Has defendido a un enemigo!");
							personajes.add(new Enemy());
						}
					}
				}

			} else {
				System.out.println("Opción incorrecta.");
			}
		}

		System.out.println("\n--- FIN DEL JUEGO ---");
		System.out.println("Héroe: " + hero.getNombre());
		System.out.println("Enemigos matados: " + hero.getEnemigosMatados());
		System.out.println("Amigos defendidos: " + hero.getAmigosDefendidos());

		teclado.close();
	}

	public static void showCharacters(ArrayList<Character> personajes) {

		System.out.println("\n--- LISTA DE PERSONAJES ---");

		for (int i = 0; i < personajes.size(); i++) {

			Character personaje = personajes.get(i);

			if (personaje.isEnemy()) {
				System.out.println("Índice " + i + ": Enemigo");
			} else if (personaje instanceof Friend) {
				System.out.println("Índice " + i + ": Amigo");
			}
		}
	}

	public static void countCharacters(ArrayList<Character> personajes) {

		int amigos = 0;
		int enemigos = 0;

		for (Character personaje : personajes) {
			if (personaje.isEnemy()) {
				enemigos++;
			} else if (personaje instanceof Friend) {
				amigos++;
			}
		}

		System.out.println("Amigos: " + amigos);
		System.out.println("Enemigos: " + enemigos);
	}
}

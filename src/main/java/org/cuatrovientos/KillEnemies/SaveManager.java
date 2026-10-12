package org.cuatrovientos.KillEnemies;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

public class SaveManager {

	private static final String ARCHIVO = "partida.dat";

	public static void guardar(GameState estado) {

		try {
			ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(ARCHIVO));

			salida.writeObject(estado);
			salida.close();

			System.out.println("Partida guardada correctamente.");

		} catch (IOException e) {
			System.out.println("Error al guardar la partida.");
			e.printStackTrace();
		}
	}

	public static GameState cargar() {

		try {
			ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(ARCHIVO));

			GameState estado = (GameState) entrada.readObject();
			entrada.close();

			System.out.println("Partida cargada correctamente.");

			return estado;

		} catch (IOException | ClassNotFoundException e) {
			return null;
		}
	}
}

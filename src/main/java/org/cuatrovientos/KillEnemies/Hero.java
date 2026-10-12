package org.cuatrovientos.KillEnemies;

public class Hero implements Character{

	private String nombre;
	private int enemigosMatados;
	private int amigosDefendidos;

	public Hero(String nombre) {
	    this.nombre = nombre;
	    this.enemigosMatados = 0;
	    this.amigosDefendidos = 0;
	}

	@Override
	public boolean isEnemy() {
	    return false;
	}

	public void attack(Enemy enemy) {
	    System.out.println("¡He atacado a un enemigo!");
	    enemy.kill();
	    enemigosMatados++;
	}

	public void defend(Friend friend) {
	    System.out.println("¡He defendido a un amigo!");
	    amigosDefendidos++;
	}

	public String getNombre() {
	    return nombre;
	}

	public int getEnemigosMatados() {
	    return enemigosMatados;
	}

	public int getAmigosDefendidos() {
	    return amigosDefendidos;
	}
	
}

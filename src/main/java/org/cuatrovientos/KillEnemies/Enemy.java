package org.cuatrovientos.KillEnemies;

public class Enemy implements Character{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public boolean isEnemy() {
		// TODO Auto-generated method stub
		return true;
	}
	
	 public void kill() {
	        System.out.println("Ahhhggg, me mataste, bastardo!");
	    }

}

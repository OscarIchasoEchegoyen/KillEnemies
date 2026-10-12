package org.cuatrovientos.KillEnemies;

public class Friend implements Character{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public boolean isEnemy() {
        return false;
    }
    
    public void heal() {
        System.out.println("¡Te he curado!");
    }
    
}

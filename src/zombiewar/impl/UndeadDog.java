/**
 * Created on 23/2/2016
 *
 * @author Jenny
 */
package zombiewar.impl;

import zombiewar.intf.ISurvivor;
import zombiewar.intf.IZombie;

public class UndeadDog extends Character implements IZombie{
	public static int COUNT = 0;
	private int index;
	/**
	 * A UndeadDog starts with 60 points of health
	 */
	public Predator() {
		super(60);
		index = COUNT++;
	}

	@Override
	public void attack(ISurvivor survivor) {
		survivor.decreaseHealth(25);
	}

	@Override
	public String toString(){
		return "Undead Dog";
	}

	@Override
	public int getIndex() {
		return index;
	}
}

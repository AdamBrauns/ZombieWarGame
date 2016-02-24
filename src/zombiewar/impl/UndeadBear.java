/**
 * Created on 23/2/2016
 *
 * @author Jenny
 */
package zombiewar.impl;

import zombiewar.intf.ISurvivor;
import zombiewar.intf.IZombie;

public class UndeadBear extends Character implements IZombie{
	public static int COUNT = 0;
	private int index;
	/**
	 * A UndeadBear starts with 60 points of health
	 */
	public Predator() {
		super(80);
		index = COUNT++;
	}

	@Override
	public void attack(ISurvivor survivor) {
		survivor.decreaseHealth(25);
	}

	@Override
	public String toString(){
		return "Undead Bear";
	}

	@Override
	public int getIndex() {
		return index;
	}
}

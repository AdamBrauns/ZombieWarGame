package zombiewar.impl;

import zombiewar.intf.ISurvivor;
import zombiewar.intf.IZombie;

/**
 * Created on 23/2/2016
 *
 * @author Reinaldo
 */
public class Spitter extends Character implements IZombie {

	private int index;

	public Spitter(int index) {
		super(45);
		this.index = index;
	}

	@Override
	public void attack(final ISurvivor creature) {
		creature.decreaseHealth(30);
	}

	@Override
	public String toString() {
		return "Radioactive Zombie";
	}

	@Override
	public int getIndex() {
		return index;
	}
}

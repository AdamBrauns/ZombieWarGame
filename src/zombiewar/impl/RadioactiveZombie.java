package zombiewar.impl;

import zombiewar.intf.ISurvivor;
import zombiewar.intf.IZombie;

/**
 * Created on 23/2/2016
 *
 * @author Reinaldo
 */
public class RadioactiveZombie extends Character implements IZombie {

	private int index;

	RadioactiveZombie(int index) {
		super(75);
		this.index = index;
	}

	@Override
	public void attack(final ISurvivor creature) {
		creature.decreaseHealth(25);
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

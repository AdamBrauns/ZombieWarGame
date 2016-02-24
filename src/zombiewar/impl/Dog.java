package zombiewar.impl;

import zombiewar.intf.ISurvivor;
import zombiewar.intf.IZombie;

/**
 * Created on 23/2/2016
 *
 * @author Reinaldo
 */
public class Dog extends Character implements ISurvivor {
	public static int COUNT = 0;
	private int index;

	Dog() {
		super(50);
		index = COUNT++;
	}

	@Override
	public void attack(final IZombie zombie) {
		zombie.decreaseHealth(15);
	}

	@Override
	public String toString() {
		return "Dog";
	}

	@Override
	public int getIndex() {
		return index;
	}
}

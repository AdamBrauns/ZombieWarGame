package zombiewar.impl;

import zombiewar.intf.ISurvivor;
import zombiewar.intf.IZombie;

/**
 * Created on 23/2/2016
 *
 * @author Reinaldo
 */
public class Dog extends Character implements ISurvivor {

	Dog(final int health) {
		super(health);
	}

	@Override
	public void attack(final IZombie zombie) {
		zombie.decreaseHealth(3);
	}
}

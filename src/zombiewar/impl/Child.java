/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zombiewar.impl;

import zombiewar.intf.ISurvivor;
import zombiewar.intf.IZombie;


public class Child extends Character implements ISurvivor{

	/**
	 * A Child starts with 20 points of health
	 */
	public Child() {
		super(20);
	}

	@Override
	public void attack(IZombie zombie) {
		zombie.decreaseHealth(2);
	}
	
	
}

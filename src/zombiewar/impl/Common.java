/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zombiewar.impl;

import zombiewar.intf.ISurvivor;
import zombiewar.intf.IZombie;

public class Common extends Character implements IZombie {

	private int index;
	/**
	 * A Common starts with 30 points of health
	 */
	public Common(int index) {

		super(30);
		this.index = index;
	}

	@Override
	public void attack(ISurvivor survivor) {
		survivor.decreaseHealth(5);
	}

	@Override
	public String toString() {
		return "Common Infected";
	}

	@Override
	public int getIndex() {
		return index;
	}
}

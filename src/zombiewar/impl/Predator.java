/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zombiewar.impl;

import zombiewar.intf.ISurvivor;
import zombiewar.intf.IZombie;

public class Predator extends Character implements IZombie{

	private int index;
	/**
	 * A Predator starts with 80 points of health
	 */
	public Predator(int index) {
		super(80);
		this.index = index;
	}

	@Override
	public void attack(ISurvivor survivor) {
		survivor.decreaseHealth(10);
	}

	@Override
	public String toString(){
		return "Predator";
	}

	@Override
	public int getIndex() {
		return index;
	}
}

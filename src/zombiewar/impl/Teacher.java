/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zombiewar.impl;

import zombiewar.intf.ISurvivor;
import zombiewar.intf.IZombie;


public class Teacher extends Character implements ISurvivor {
	public static int COUNT = 0;
	private int index;

	/**
	 * A teacher starts with 50 points of health
	 */
	public Teacher() {
		super(50);
		index = COUNT++;
	}

	@Override
	public void attack(IZombie zombie) {
		zombie.decreaseHealth(5);
	}

	@Override
	public String toString() {
		return "Teacher";
	}


	@Override
	public int getIndex() {
		return index;
	}
}

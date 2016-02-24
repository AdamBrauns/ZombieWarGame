/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zombiewar.impl;

import zombiewar.intf.ISurvivor;
import zombiewar.intf.IZombie;


public class Military extends Character implements ISurvivor {

	public static int COUNT = 0;
	private int index;

	public Military() {
		super(70);
		index = COUNT++;
	}

	@Override
	public void attack(IZombie zombie) {
		zombie.decreaseHealth(50);
	}

	@Override
	public String toString() {
		return "Military";
	}

	@Override
	public int getIndex() {
		return index;
	}
}

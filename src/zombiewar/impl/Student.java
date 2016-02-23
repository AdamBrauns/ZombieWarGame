/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zombiewar.impl;

import zombiewar.intf.ISurvivor;
import zombiewar.intf.IZombie;

public class Student extends Character implements ISurvivor{

	/**
	 * A student starts with 50 points of health
	 */
	public Student() {
		super(50);
	}

	@Override
	public void attack(IZombie zombie) {
		zombie.decreaseHealth(4);
	}

	@Override
	public String toString(){
		return "Student";
	}
}

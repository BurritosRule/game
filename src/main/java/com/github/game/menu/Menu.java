package com.github.game.menu;

import java.util.List;

import com.github.game.world.Action;

public interface Menu {
	
	//enum instead?
	public String header();
	public List<Action> possibleInput();
	
//	Current Location Header
//	---------------------------------------
//	Actions
//	  Applicable actions based on current player location
//	  Return
//  Player
//	  Player character related menus. Stats, inventory, etc.
//    Return
//	Options
//	  Save
//	  Load
//	  Exit
//	  Return

}

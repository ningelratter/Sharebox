package de.sharebox.models;

import de.sharebox.entities.Dir;

/**
 * 
 * @author Eilin
 * @verson 30.06.11
 */
public class DirModel {

	private Dir dir;
	
	public DirModel(Dir dir){
		setDir(dir);
	}
	
	private void setDir(Dir dir) {
		this.dir = dir;
		
	}
	
	public Dir getDir(){
		return dir;
	}
}

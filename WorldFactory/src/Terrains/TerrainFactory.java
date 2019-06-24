package Terrains;

import org.newdawn.slick.Color;

/**
 * The TerrainFactory class builds new terrain objects by taking in the type
 *  of object from Main and asking for a new neighbor 
 */

public class TerrainFactory {
	
	/**
	 * generateTerrain() creates a new Terrain type based on input passed from Main.
	 * 	This method processes the char type and returns the creation of a new Terrain object
	 */
	public static Terrain generateTerrain(char type, int x, int y, int width, int height) {
		if (type == 'G') {
			return Grass(x, y, width, height);
		} else if (type == 'H') {
			return Hill(x, y, width, height);
		} else if (type == 'M') {
			return Mountains(x, y, width, height);
		} else if (type == 'D') {
			return Desert(x, y, width, height);
		} else if (type == 'R') {
			return River(x, y, width, height);
		} else if (type == 'F') {
			return Forest(x, y, width, height);
		} else if (type == 'B') {
			return Beach(x, y, width, height);
		} else 
			return Lake(x, y, width, height);	
	}
	
	
	/************************* HELPER METHODS********************************
	 *   for each terrian type. Contains the probability rules for each type 
	 *   to generate the return a new object 
	 ************************************************************************/
	
/* Rules: Grass - 40%, Hill - 15%,  Desert - 5%, River - 15%  Forest - 15%, Beach - 10%, */
	private static Terrain Grass(int x, int y, int width, int height) {
		if(Math.random() <= .4) {
			return new Terrain('G', x, y, width, height, g);
		} else if (Math.random() <= .15) {
			return new Terrain('H', x, y, width, height, h);
		} else if (Math.random() <= .05) {
			return new Terrain('D', x, y, width, height, d); 
		} else if (Math.random() <= .15) {
			return new Terrain('R', x, y, width, height, r); 
		} else if (Math.random() <= .15) {
			return new Terrain('F', x, y, width, height, f);
		} else if (Math.random() <= .1) {
			return new Terrain('B', x, y, width, height, b);
		} else
			return new Terrain('L', x, y, width, height, l);
	}

/* Rules: Grass - 20%, Hill - 40%, Mountains - 15%, River - 10%, Forest - 10%, Lake - 10% */
	private static Terrain Hill(int x, int y, int width, int height) {
		if(Math.random() <= .2) {
			return new Terrain('G', x, y, width, height, g);
		} else if (Math.random() <= .4) {
			return new Terrain('H', x, y, width, height, h);
		} else if (Math.random() <= .15) {
			return new Terrain('M', x, y, width, height, m); 
		} else if (Math.random() <= .1) {
			return new Terrain('R', x, y, width, height, r); 
		} else if (Math.random() <= .1) {
			return new Terrain('F', x, y, width, height, f);
		} else if (Math.random() <= .05) {
			return new Terrain('B', x, y, width, height, b);
		} else
			return new Terrain('L', x, y, width, height, l);
	}
	
/* Rules: Hill - 25%, Mountains - 50%, Desert - 5%, River - 5%, Forest - 10%, Lake- 5% */
	private static Terrain Mountains(int x, int y, int width, int height) {
		if (Math.random() <= .25) {
			return new Terrain('H', x, y, width, height, h);
		} else if (Math.random() <= .5) {
			return new Terrain('M', x, y, width, height, m);
		} else if (Math.random() <= .05) {
			return new Terrain('D', x, y, width, height, d); 
		} else if (Math.random() <= .05) {
			return new Terrain('R', x, y, width, height, r); 
		} else if (Math.random() <= .1) {
			return new Terrain('F', x, y, width, height, f);
		} else if (Math.random() <= .05) {
			return new Terrain('L', x, y, width, height, l);
		} else
			return new Terrain('B', x, y, width, height, b);
	}
	
/* Rules: Grass - 30%, Mountains - 5%, Desert - 55%, Beach - 10% */ 
	private static Terrain Desert(int x, int y, int width, int height) {
		if(Math.random() <= .3) {
			return new Terrain('G', x, y, width, height, g);
		} else if (Math.random() <= .05) {
			return new Terrain('M', x, y, width, height, m); 
		} else if (Math.random() <= .55) {
			return new Terrain('D', x, y, width, height, d);
		} else if (Math.random() <= .1) {
			return new Terrain('B', x, y, width, height, b);
		} else
			return new Terrain('L', x, y, width, height, l);
	}
	
/* Rules: Grass - 5%, Hills - 5%, Mountains - 5%, River - 50%, Forest - 5%, Beach - 10%, Lake - 20% */
	private static Terrain River(int x, int y, int width, int height) {
		if(Math.random() <= .05) {
			return new Terrain('G', x, y, width, height, g);
		} else if (Math.random() <= .05) {
			return new Terrain('H', x, y, width, height, h);
		} else if (Math.random() <= .05) {
			return new Terrain('M', x, y, width, height, m); 
		} else if (Math.random() <= .5) {
			return new Terrain('R', x, y, width, height, r); 
		} else if (Math.random() <= .05) {
			return new Terrain('F', x, y, width, height, f);
		} else if (Math.random() <= .1) {
			return new Terrain('B', x, y, width, height, b);
		} else if (Math.random() <= .2) {
			return new Terrain('L', x, y, width, height, l);
		} else 
			return new Terrain('D', x, y, width, height, d);
	}
	
/* Rules: Grass - 15%, Hills - 15%, Mountains - 10% River - 10%, Forest - 45%, Lake - 5% */
	private static Terrain Forest(int x, int y, int width, int height) {
		if(Math.random() <= .15) {
			return new Terrain('G', x, y, width, height, g);
		} else if (Math.random() <= .15) {
			return new Terrain('H', x, y, width, height, h);
		} else if (Math.random() <= .1) {
			return new Terrain('M', x, y, width, height, m); 
		} else if (Math.random() <= .1) {
			return new Terrain('R', x, y, width, height, r); 
		} else if (Math.random() <= .45) {
			return new Terrain('F', x, y, width, height, f);
		} else if (Math.random() <= .05) {
			return new Terrain('L', x, y, width, height, l);
		} else
			return new Terrain('B', x, y, width, height, b);
	}
	
/* Rules: Grass - 10%, Desert - 5%, River - 5%, Beach - 40%, Lake - 40% */
	private static Terrain Beach(int x, int y, int width, int height) {
		if(Math.random() <= .1) {
			return new Terrain('G', x, y, width, height, g);
		} else if (Math.random() <= .05) {
			return new Terrain('D', x, y, width, height, d);
		} else if (Math.random() <= .05) {
			return new Terrain('R', x, y, width, height, r); 
		} else if (Math.random() <= .4) {
			return new Terrain('B', x, y, width, height, b);
		} else if (Math.random() <= .4) {
			return new Terrain('L', x, y, width, height, l);
		} else
			return new Terrain('B', x, y, width, height, b);
	}
	
/* Rules: River - 10%, Beach - 30%, Lake - 60% */
	private static Terrain Lake(int x, int y, int width, int height) {
		if (Math.random() <= .1) {
			return new Terrain('R', x, y, width, height, r);
		} else if (Math.random() <= .3) {
			return new Terrain('B', x, y, width, height, b);
		} else if (Math.random() <= .6) {
			return new Terrain('L', x, y, width, height, l);
		} else
			return new Terrain('F', x, y, width, height, f);
	}
	
	/** 
	 * Color variables used to call the proper color of each terrain in 
	 * the generateTerrain method and the getColor method
	 */
	private static Color g = new Color(154, 205, 50);  // grass - light green
	private static Color h = new Color(34, 139, 34);   // hill - middle green
	private static Color m = new Color(190, 190, 190); // mountain - grey 
	private static Color d = new Color(184, 134, 11);  // desert - yellow brown
	private static Color r = new Color(135, 206, 250); // river - light blue
	private static Color f = new Color(107, 142, 35);  // forest - dark green
	private static Color b = new Color(250, 250, 210); // beach - sandy
	private static Color l = new Color(70, 130, 180);  // lake - dark blue
	
	/**
	 * Helper method called in Main to retrive correct color 
	 * 	when creating a new Terrain object 
	 */
	public static Color getColor(String string) {
		if (string.equals("G")) {
			return new Color(154, 205, 50); //Color(154, 205, 50);
		} else if (string.equals("H")) {
			return new Color(34, 139, 34);
		} else if (string.equals("M")) {
			return new Color(190, 190, 190);
		} else if (string.equals("D")) {
			return new Color(184, 134, 11);
		} else if (string.equals("R")) {
			return new Color(135, 206, 250);
		} else if (string.equals("F")) {
			return new Color(107, 142, 35);
		} else if (string.equals("B")) {
			return new Color(250, 250, 210);
		} else if (string.equals("L")) {
			return new Color(70, 130, 180);
		} else 
			return Color.white;
	}
}

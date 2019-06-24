package Terrains;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

/**
 * The Terrain class defines the vital properties and behaviors 
 *  given to each Terrain type 
 */

public class Terrain {

	/** PROPERTIES **/ 
	public char type;
	public int x;
	public int y;
	public int width;
	public int height;
	public Color color;
	
	/**
	 * The constructors are called when an instance of an inherited class is created
	 */
	// This constructor is called if an instance with parameters is being made
	public Terrain(char type, int x, int y, int width, int height, Color color) {
		this.type = type;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
		System.out.println(this.color);
	}
	// This constructor is called if an instance without parameters is being made. 
	// All properties are initalized to 0.
	public Terrain() {
		this.type = ' ';
		this.x = 0;
		this.y = 0;
		this.width = 0;
		this.height = 0;
		this.color = Color.white;
	}
	
	/**
	 * drawSelf draws a rectangle using the color and position 
	 * 	of the given instance to fill all available space  
	 */
	public void drawSelf(Graphics painter) {
		Color previousColor = painter.getColor();
		//System.out.println(this.color);
		painter.setColor(this.color);
		painter.fillRect(this.x, this.y, this.width, this.height);
		painter.setColor(previousColor);
	}
	
	/**
	 * getType is a helper method called in Main to be used to 
	 * generate a neighboring terrain from the TerrainFactory.
	 * 
	 * @return the Terrain type in question
	 */
	public char getType() {
		return type;
	}

	
}

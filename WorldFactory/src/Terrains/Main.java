package Terrains;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

/**
 * The Main class extends Slick2D Basic Game to create the world 
 * based on user input, and populates the world by calling on
 * the TerrainFactory
 */

public class Main extends BasicGame {

	/**PROPERTIES**/
	static int worldWidth;
	static int worldHeight;
	Terrain[][] world;
	
	public Main(String title) {
		super(title);
	}

	/**
	 * This method renders the simulations screen
	 * @param myGame is the container holding the game
	 * @param painter is the graphics context to be used to render
	 */
	@Override
	public void render(GameContainer myGame, Graphics painter) throws SlickException {
		for(int i = 0; i < worldWidth; i++) {
			for(int j = 0; j< worldHeight; j++) {
				world[i][j].drawSelf(painter);
				//System.out.print(world[i][j].getType() );
			}
			//System.out.println();
		}	
		//System.out.println("\n\n");
	}

	/**
	 * The Init class is called before the simulation loop starts. It
	 *  	initalizes the Slick2D game by creating pixel size,
	 *  	and populates each cell by calling generateTerrain from the 
	 *  	TerrainFactory class 
	 */
	@Override
	public void init(GameContainer myGame) throws SlickException {
		
		this.world = new Terrain[worldWidth][worldHeight];
		
		int width = 640/worldWidth;
		int height = 480/worldHeight;
		
		for (int i = 0; i < worldWidth; i++) {
			for (int j = 0; j < worldHeight; j++) {
				
				// object at (0,0
				if (i == 0 &&  j == 0) {
					
					String[] arr = {"G", "H", "M", "D", "R", "F", "B", "L"};
					int index = (int) (Math.random() * 5);
					String terrain = arr[index];
					System.out.println(terrain);
					
					if(terrain.equals("G")) {
						world[0][0] = new Terrain('G', 0, 0, width, height, TerrainFactory.getColor("G"));
					} else if (terrain.equals("H")) {
						world[0][0] = new Terrain('H', 0, 0, width, height, TerrainFactory.getColor("H"));
					} else if (terrain.equals("M")) {
						world[0][0] = new Terrain('M', 0, 0, width, height, TerrainFactory.getColor("M"));
					} else if (terrain.equals("D")) {
						world[0][0] = new Terrain('D', 0, 0, width, height, TerrainFactory.getColor("D"));
					} else if (terrain.equals("R")) {
						world[0][0] = new Terrain('R', 0, 0, width, height, TerrainFactory.getColor("R"));
					} else if (terrain.equals("F")) {
						world[0][0] = new Terrain('F', 0, 0, width, height, TerrainFactory.getColor("F"));
					} else if (terrain.equals("B")) {
						world[0][0] = new Terrain('B', 0, 0, width, height, TerrainFactory.getColor("B"));	
					} else 
						world[0][0] = new Terrain('L', 0, 0, width, height, TerrainFactory.getColor("L"));
				}
				else if (j == 0) {								
					world[i][j] = TerrainFactory.generateTerrain(world[i-1][j].getType(), i*width, 
																			j*height, width, height);
				} else if (i == 0) {
					world[i][j] = TerrainFactory.generateTerrain(world[i][j-1].getType(), i*width,
																			j*height, width, height);
				} else { // Simulate coin flip for remainin cells 
						//Random rand = new Random();
						//int result = rand.nextInt(2);
						if (Math.random() < 0.5) 
						{
							world[i][j] = TerrainFactory.generateTerrain(world[i-1][j].getType(), 
																	i*width, j*height, width, height);
						}
						else 
						{ 
							world[i][j] = TerrainFactory.generateTerrain(world[i][j-1].getType(), 
																	i*width, j*height, width, height);
						}
					}
			}
		}
		System.out.println("DONE!");
	}
	
	@Override
	public void update(GameContainer myGame, int frame) throws SlickException {
	
	}
	
	/**
	 * The main method is the entry point to our simulaiton.
	 * 		The method asks the user to input a width and height for the world
	 * 		to determine how large and how many objects will be created. This method
	 * 		also sets up the Slick2D game container.
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the width of the world, and integer between 20-50:");
		worldWidth = scan.nextInt();
		if(worldWidth < 20 || worldWidth > 50) {
			throw new IllegalArgumentException("Integer is not within bounds");
		}
		
		System.out.println("Enter the height of the world, an integer between 20-50");
		worldHeight = scan.nextInt();
		if (worldHeight < 20 || worldHeight > 50) {
			throw new IllegalArgumentException("Integer is not within bounds");
		}
		
		try
		{
			AppGameContainer appgc;
			appgc = new AppGameContainer(new Main("Terrain Game"));
			appgc.setDisplayMode(640, 480, false);
			appgc.setMaximumLogicUpdateInterval(60);
			appgc.setTargetFrameRate(60);
			appgc.start();
		}
		catch (SlickException ex)
		{
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	
}

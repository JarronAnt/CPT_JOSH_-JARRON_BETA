package gameState;

import java.awt.Color;
import java.awt.Graphics2D;

import main.GamePanel;
import TileMap.TileMap;

public class Level3State extends GameState
{
private TileMap tileMap;
	
	
	public Level3State(GameStateManager gsm)
	{
		this.gsm = gsm; 
		init();
	}
	
	@Override
	public void init() 
	{
		tileMap = new TileMap(30);
		tileMap.loadTiles("/Tilesets/grasstileset.gif");
		tileMap.loadMap("/Maps/PlsV2.map");
		tileMap.setPos(0,0);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, GamePanel.SCREEN_WIDTH, GamePanel.SCREEN_HEIGHT);
		//draw the map
	 tileMap.draw(g);
	}

	@Override
	public void keyPressed(int k) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(int k) {
		// TODO Auto-generated method stub
		
	}
}

package gameState;

import java.awt.*;
import java.awt.event.KeyEvent;

import main.GamePanel;
import Entity.Player;
import TileMap.Background;
import TileMap.TileMap;

public class Level1State extends GameState 
{

	private TileMap tileMap;
	private Background bg;
	
	private Player player;
	
	int playerX;
	public Level1State(GameStateManager gsm)
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
		tileMap.setTween(1);
		
		bg = new Background("/Backgrounds/grassbg1.gif", 0.1);
		
		player = new Player(tileMap);
		
		player.setPosition(35,45);
	}

	@Override
	public void update() {
		player.update();
		tileMap.setPos(GamePanel.SCREEN_WIDTH / 2 - player.getx(), GamePanel.SCREEN_HEIGHT / 2 - player.gety());
		playerX = player.getx();
		
		
	}

	@Override
	public void draw(Graphics2D g) {

		//draw bg
		bg.draw(g);
		
		//draw the map
		tileMap.draw(g);
		
		//draw player
		player.draw(g);
	}

	@Override
	public void keyPressed(int k) {
		if( k == KeyEvent.VK_LEFT)
		{
			player.setLeft(true);
		}
		if( k == KeyEvent.VK_RIGHT)
		{
			player.setRight(true);
		}
		if( k == KeyEvent.VK_UP)
		{
			player.setUp(true);
		}
		if( k == KeyEvent.VK_DOWN)
		{
			player.setDown(true);
		}
		if( k == KeyEvent.VK_SPACE)
		{
			player.setJumping(true);
		}
		if( k == KeyEvent.VK_S)
		{
			player.setGliding(true);
		}
		if( k == KeyEvent.VK_A)
		{
			player.setPunching();
		}
		if( k == KeyEvent.VK_D)
		{
			player.setFiring();
		}
		if( k == KeyEvent.VK_ESCAPE)
		{
			System.exit(0);
		}
		
	}

	@Override
	public void keyReleased(int k) {
		if( k == KeyEvent.VK_LEFT)
		{
			player.setLeft(false);
		}
		if( k == KeyEvent.VK_RIGHT)
		{
			player.setRight(false);
		}
		if( k == KeyEvent.VK_UP)
		{
			player.setUp(false);
		}
		if( k == KeyEvent.VK_DOWN)
		{
			player.setDown(false);
		}
		if( k == KeyEvent.VK_SPACE)
		{
			player.setJumping(false);
		}
		if( k == KeyEvent.VK_S)
		{
			player.setGliding(false);
			
		}
	
		
	}
	
}

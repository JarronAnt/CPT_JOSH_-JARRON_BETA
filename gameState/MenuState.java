package gameState;

import TileMap.Background;

import java.awt.*;
import java.awt.event.KeyEvent;

public class MenuState extends GameState {
        
        private Background bg;
        @SuppressWarnings("unused")
		private int menuNum;
        private int currentChoice = 0;
        private String[] options = {
                "Start",
                "Help",
                "Quit",
                "Search"
        };
        
        private Color titleColor;
        private Font titleFont;
        
        private Font font;
        
        public MenuState(GameStateManager gsm) {
                
                this.gsm = gsm;
                
                try {
                	
                	
                	
                        bg = new Background("/Backgrounds/star_rsz.jpg", 1);
                        titleColor = new Color(0, 175, 129);
                	
                

                        bg.setVector(-0.1, 0);
                        
                        //set the font for the title 
                        titleFont = new Font(
                                        "Century Gothic",
                                        Font.PLAIN,
                                        28);
                        
                        //set font for everything else
                        font = new Font("Arial", Font.PLAIN, 12);
                        
                }
                catch(Exception e) {
                        e.printStackTrace();
                }
                
        }
        
        public void init() {}
        
        public void update() {
                bg.update();
        }
        
        public void draw(Graphics2D g) {
                
                // draw bg
                bg.draw(g);
                
                // draw title
                g.setColor(titleColor);
                g.setFont(titleFont);
                g.drawString("GAME", 115, 70);
                
                // draw menu options
                g.setFont(font);
                for(int i = 0; i < options.length; i++) {
                        if(i == currentChoice) {
                                g.setColor(Color.GREEN);
                        }
                        else {
                                g.setColor(Color.RED);
                        }
                        g.drawString(options[i], 145, 140 + i * 15);
                }
                
        }
        
        private void select() {
                if(currentChoice == 0) {
                        gsm.setState(GameStateManager.LEVEL1STATE);
                }
                if(currentChoice == 1) {
                        // help
                }
                if(currentChoice == 2) {
                        System.exit(0);
                }
                if(currentChoice == 4) {
                  //search
            }
        }
        
        public void keyPressed(int k) {
                if(k == KeyEvent.VK_ENTER){
                        select();
                }
                if(k == KeyEvent.VK_UP) {
                        currentChoice--;
                        if(currentChoice == -1) {
                                currentChoice = options.length - 1;
                        }
                }
                if(k == KeyEvent.VK_DOWN) {
                        currentChoice++;
                        if(currentChoice == options.length) {
                                currentChoice = 0;
                        }
                }
        }
        public void keyReleased(int k) {}
        
}











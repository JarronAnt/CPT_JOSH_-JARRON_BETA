package Entity;

import main.*;
import TileMap.TileMap;
import TileMap.Tile;

import java.awt.Rectangle;

public abstract class MapObject {
        
        // tile stuff
        protected TileMap tileMap;
        protected int tileSize;
        protected double xMap;
        protected double yMap;
        
        // position and vector
        protected double x;
        protected double y;
        protected double dx;
        protected double dy;
        
        // dimensions
        protected int width;
        protected int height;
        
        // collision box
        protected int cWidth;
        protected int cHeight;
        
        // collision
        protected int currRow;
        protected int currCol;
        protected double xdest;
        protected double ydest;
        protected double xtemp;
        protected double ytemp;
        protected boolean topLeft;
        protected boolean topRight;
        protected boolean bottomLeft;
        protected boolean bottomRight;
        
        // animation
        protected Animation animation;
        protected int currentAction;
        protected int previousAction;
        protected boolean facingRight;
        
        // movement
        protected boolean left;
        protected boolean right;
        protected boolean up;
        protected boolean down;
        protected boolean jumping;
        protected boolean falling;
        
        // movement attributes
        protected double moveSpeed;
        protected double maxSpeed;
        protected double stopSpeed;
        protected double fallSpeed;
        protected double maxFallSpeed;
        protected double jumpStart;
        protected double stopJumpSpeed;
        
        // constructor
        public MapObject(TileMap tm) {
                tileMap = tm;
                tileSize = tm.getTileSize(); 
        }
        
        public boolean intersects(MapObject o) {
                Rectangle r1 = getRectangle();
                Rectangle r2 = o.getRectangle();
                return r1.intersects(r2);
        }
        
        public Rectangle getRectangle() {
                return new Rectangle(
                                (int)x - cWidth,
                                (int)y - cHeight,
                                cWidth,
                                cHeight
                );
        }
        
        public void calculateCorners(double x, double y) {
                
                int leftTile = (int)(x - cWidth / 2) / tileSize;
                int rightTile = (int)(x + cWidth / 2 - 1) / tileSize;
                int topTile = (int)(y - cHeight / 2) / tileSize;
                int bottomTile = (int)(y + cHeight / 2 - 1) / tileSize;
                
                if(topTile < 0 || bottomTile >= tileMap.getNumRows() ||
                        leftTile < 0 || rightTile >= tileMap.getNumCols()) {
                        topLeft = topRight = bottomLeft = bottomRight = false;
                        return;
                }
                
                int tl = tileMap.getType(topTile, leftTile);
                int tr = tileMap.getType(topTile, rightTile);
                int bl = tileMap.getType(bottomTile, leftTile);
                int br = tileMap.getType(bottomTile, rightTile);
                
                topLeft = tl == Tile.BLOCKED;
                topRight = tr == Tile.BLOCKED;
                bottomLeft = bl == Tile.BLOCKED;
                bottomRight = br == Tile.BLOCKED;
                
        }
        
        public void checkTileMapCollision() {
                
                currCol = (int)x / tileSize;
                currRow = (int)y / tileSize;
                
                xdest = x + dx;
                ydest = y + dy;
                
                xtemp = x;
                ytemp = y;
                
                calculateCorners(x, ydest);
                if(dy < 0) {
                        if(topLeft || topRight) {
                                dy = 0;
                                ytemp = currRow * tileSize + cHeight / 2;
                        }
                        else {
                                ytemp += dy;
                        }
                }
                if(dy > 0) {
                        if(bottomLeft || bottomRight) {
                                dy = 0;
                                falling = false;
                                ytemp = (currRow + 1) * tileSize - cHeight / 2;
                        }
                        else {
                                ytemp += dy;
                        }
                }
                
                calculateCorners(xdest, y);
                if(dx < 0) {
                        if(topLeft || bottomLeft) {
                                dx = 0;
                                xtemp = currCol * tileSize + cWidth / 2;
                        }
                        else {
                                xtemp += dx;
                        }
                }
                if(dx > 0) {
                        if(topRight || bottomRight) {
                                dx = 0;
                                xtemp = (currCol + 1) * tileSize - cWidth / 2;
                        }
                        else {
                                xtemp += dx;
                        }
                }
                
                if(!falling) {
                        calculateCorners(x, ydest + 1);
                        if(!bottomLeft && !bottomRight) {
                                falling = true;
                        }
                }
                
        }
        
        public int getx() { return (int)x; }
        public int gety() { return (int)y; }
        public int getWidth() { return width; }
        public int getHeight() { return height; }
        public int getcWidth() { return cWidth; }
        public int getcHeight() { return cHeight; }
        
        public void setPosition(double x, double y) {
                this.x = x;
                this.y = y;
        }
        public void setVector(double dx, double dy) {
                this.dx = dx;
                this.dy = dy;
        }
        
        public void setMapPosition() {
                xMap = tileMap.getx();
                yMap = tileMap.gety();
        }
        
        public void setLeft(boolean b) { left = b; }
        public void setRight(boolean b) { right = b; }
        public void setUp(boolean b) { up = b; }
        public void setDown(boolean b) { down = b; }
        public void setJumping(boolean b) { jumping = b; }
        
        public boolean notOnScreen() {
                return x + xMap + width < 0 ||
                        x + xMap - width > GamePanel.SCREEN_WIDTH ||
                        y + yMap + height < 0 ||
                        y + yMap - height > GamePanel.SCREEN_HEIGHT;
        }
        
}

















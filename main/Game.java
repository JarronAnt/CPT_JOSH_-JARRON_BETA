package main;

import javax.swing.JFrame;

/*TODO: Implement Attacks :D
 *TODO: Add Enemies :D
 *TODO: Add way to progress (idea: if all enemies killed move to next lvl) :D
 *TODO: Add music :D
 *TODO: Add search and options
 *TODO: Add Comments T.T
 *TODO: polish T.T
*/
 
public class Game
{
	public static void main (String[] args)
	{
		JFrame window = new JFrame("GAME");
		window.setContentPane(new GamePanel());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.pack();
		window.setVisible(true);

	}
}

package com.game.menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import javax.swing.JLabel;
import javax.swing.JPanel;

import com.game.command.MenuCommand;
import com.game.configuration.Configuration;
import com.game.configuration.Constants;



public class Menu extends JPanel implements ActionListener{


	private JLabel _gameTitleJLabel = new JLabel("Jogo da Memória!!");
	private Configuration gameConfiguration = new Configuration();

	private DifficultySelectionPanel _difficultySelectionPanel = new DifficultySelectionPanel(this);
	private ModeSelectionPanel _modeSelectionPanel = new ModeSelectionPanel(this);
	
	public Menu(ActionListener responsibleMenu) {
		super();
		setBackground(Constants.backgroundColor);
		setFocusable(true);
		
		add(_gameTitleJLabel);
		add(_modeSelectionPanel);
		add(_difficultySelectionPanel);
		
		showFirstStep();
		addExitListener();
	}
	
	public void showFirstStep() 
	{
		_modeSelectionPanel.setVisible(true);
		_difficultySelectionPanel.setVisible(false);
	}
	
	public void showSecondStep()
	{

		_difficultySelectionPanel.setVisible(true);
		_modeSelectionPanel.setVisible(false);
		
	}
	
	public void finishMenu() 
	{
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		MenuCommand actionTaken = MenuCommand.fromString(e.getActionCommand());
		
		if (actionTaken.equals(MenuCommand.modeSelectionSinglePlayer) || actionTaken.equals(MenuCommand.modeSelectionMultiPlayer))
		{
			gameConfiguration.setPlayerCount(actionTaken.getValue());
			showSecondStep();
		}
		else if (actionTaken.equals(MenuCommand.difficultySelectionEasy)
				|| actionTaken.equals(MenuCommand.difficultySelectionNormal)
				|| actionTaken.equals(MenuCommand.difficultySelectionHard))
		{
			gameConfiguration.setGameDifficulty(actionTaken.getValue());
			finishMenu();
		}
	}
	
	private void addExitListener() {
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
					System.exit(0);
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}

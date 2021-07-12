package com.game.menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.game.command.MenuCommand;
import com.game.configuration.Configuration;
import com.game.configuration.Constants;



public class Menu extends JPanel implements ActionListener{


	private JLabel _gameTitleJLabel = new JLabel("Jogo da Memória!!");
	private Configuration _gameConfiguration = new Configuration();

	private DifficultySelectionPanel _difficultySelectionPanel = new DifficultySelectionPanel(this);
	private ModeSelectionPanel _modeSelectionPanel = new ModeSelectionPanel(this);
	
	private MenuActionListener _responsibleMenu;
	public Menu(MenuActionListener responsibleMenu) {
		super();
		setBackground(Constants.backgroundColor);
		setFocusable(true);
		
		_responsibleMenu = responsibleMenu;
		
		add(_gameTitleJLabel);
		add(_modeSelectionPanel);
		add(_difficultySelectionPanel);
		
		showFirstStep();
	}
	
	//Mostra a seleção de jogadores
	public void showFirstStep() 
	{
		_modeSelectionPanel.setVisible(true);
		_difficultySelectionPanel.setVisible(false);
	}
	
	//Mostra a seleção de dificuldade
	public void showSecondStep()
	{

		_difficultySelectionPanel.setVisible(true);
		_modeSelectionPanel.setVisible(false);
		
	}
	
	//Finaliza as configurações de Menu, e alerta o componente responsavel pelo Menu
	public void finishMenu() 
	{
		_responsibleMenu.ConfigurationFinished(_gameConfiguration);
	}
	
	
	//Escuta os eventos que acontecem dentro do Menu
	@Override
	public void actionPerformed(ActionEvent e) {
		MenuCommand actionTaken = MenuCommand.fromString(e.getActionCommand());
		
		if (actionTaken.equals(MenuCommand.modeSelectionSinglePlayer) || actionTaken.equals(MenuCommand.modeSelectionMultiPlayer))
		{
			_gameConfiguration.setPlayerCount(actionTaken.getValue());
			showSecondStep();
		}
		else if (actionTaken.equals(MenuCommand.difficultySelectionEasy)
				|| actionTaken.equals(MenuCommand.difficultySelectionNormal)
				|| actionTaken.equals(MenuCommand.difficultySelectionHard))
		{
			_gameConfiguration.setGameDifficulty(actionTaken.getValue());
			finishMenu();
		}
	}
	
	
}

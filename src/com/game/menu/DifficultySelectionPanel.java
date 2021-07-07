package com.game.menu;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.game.command.MenuCommand;
import com.game.configuration.Constants;

public class DifficultySelectionPanel extends JPanel {
	JButton _easyButton = new JButton("Fácil");
	JButton _normalButton = new JButton("Normal");
	JButton _hardButton = new JButton("Difícil");
	JPanel _difficultySelectionJPanel = new JPanel();
	
	
	public DifficultySelectionPanel(ActionListener responsibleMenu) {
		super();
		setVisible(false);
		this.setBackground(Constants.backgroundColor);

		add(_easyButton);
		add(_normalButton);
		add(_hardButton);
		
		_easyButton.setActionCommand(MenuCommand.difficultySelectionEasy.getDescription());
		_normalButton.setActionCommand(MenuCommand.difficultySelectionNormal.getDescription());
		_hardButton.setActionCommand(MenuCommand.difficultySelectionHard.getDescription());
		
		_easyButton.addActionListener(responsibleMenu);
		_normalButton.addActionListener(responsibleMenu);
		_hardButton.addActionListener(responsibleMenu);	
	}
}

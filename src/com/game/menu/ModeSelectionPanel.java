package com.game.menu;

import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.game.command.MenuCommand;
import com.game.configuration.Constants;

public class ModeSelectionPanel extends JPanel {
	JButton _singlePlayerButton = new JButton("1 Jogador");
	JButton _multiPlayerButton = new JButton("2 Jogadores");

	
	public ModeSelectionPanel(ActionListener responsibleMenu) {
		super();
		setVisible(false);
		setBackground(Constants.backgroundColor);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		add(_singlePlayerButton);
		add(_multiPlayerButton);
	
		_singlePlayerButton.addActionListener(responsibleMenu);
		_multiPlayerButton.addActionListener(responsibleMenu);
		
		
		_singlePlayerButton.setActionCommand(MenuCommand.modeSelectionSinglePlayer.getDescription());
		_multiPlayerButton.setActionCommand(MenuCommand.modeSelectionMultiPlayer.getDescription());
		
		_singlePlayerButton.setFocusable(false);
		_multiPlayerButton.setFocusable(false);
		
	}
}

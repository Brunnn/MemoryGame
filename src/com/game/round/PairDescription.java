package com.game.round;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.game.card.CardItem;

public class PairDescription extends SingleRunFrame {
	private JPanel _mainPanel;
	public PairDescription(CardItem item) {
		super();
		
		setTitle("Descrição da Imagem");
		
		_mainPanel = new JPanel();
		_mainPanel.setLayout(new FlowLayout());

		
		JLabel imageJLabel = new JLabel();
		imageJLabel.setIcon(item.getImageIcon());
		
		
		_mainPanel.add(new JLabel(item.getItemDescriptiom()));
		_mainPanel.add(imageJLabel);
		add(_mainPanel);
		
		ShowOnce();
	}
}

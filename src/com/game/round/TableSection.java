package com.game.round;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.swing.JPanel;

import com.game.card.CardItem;
import com.game.configuration.Constants;
import com.game.configuration.RuntimeConfiguration;





public class TableSection extends JPanel{

	private static int minCardPairs = 10;
	private static int maxCardPairs = 24; 
	private ArrayList<CardItem> _tableCards = new ArrayList<CardItem>();
	private int _difficultyMultiplier;
	
	private IRoundController _roundController;
	
	//Cria a seção onde serão colocadas as cartas geradas
	public TableSection(int difficulty, IRoundController roundController) {
		_roundController = roundController;
		_difficultyMultiplier = difficulty;
		setBackground(Constants.roundTableColor);
		setLayout(null);
		
		GenerateTable();
	}
	
	//Gera uma tabela de imagens de forma aleatória
	private void GenerateTable() {
		_tableCards.clear();
		
		
		int pairCount = minCardPairs +  (4 *_difficultyMultiplier) ;
		if (pairCount < minCardPairs)
			pairCount = minCardPairs;
		else if (pairCount > maxCardPairs) {
			pairCount = maxCardPairs;
		}
		
		//Seleciona randomicamente os pares de cartas
		Random generator = new Random();
		Object[] cardOptionsKeys = CardItem.options.keySet().toArray();
		
		for (int i = 0; i < pairCount/2; i++) {
			String randomItemIdString = (String) cardOptionsKeys[generator.nextInt(cardOptionsKeys.length)];
			CardItem CardItem1 = new CardItem(randomItemIdString, _roundController);
			CardItem CardItem2 = new CardItem(randomItemIdString, _roundController);
			
			//Adiciona o par gerado aleatoriamente
			_tableCards.add(CardItem1);
			_tableCards.add(CardItem2);
		}
		
		DrawTable();
	}

	//Desenha as cartas geradas na tela
	private void DrawTable() {
	
		RuntimeConfiguration runtimeConfiguration = RuntimeConfiguration.getRuntimeConfiguration();
		//Permuta aleatoriamente os pares gerados
		Collections.shuffle(_tableCards);
		
		int startingX = 5;
		int startingY = 5;
		Dimension panelSize = new Dimension(runtimeConfiguration.screenWidth - PlayerSection.sectionWidth, runtimeConfiguration.screenHeight);

		for (int i = 0; i < _tableCards.size() -1 ; i++) {
			add(_tableCards.get(i));
			_tableCards.get(i).setVisible(true);
			_tableCards.get(i).setBounds(startingX, startingY, CardItem.cardDimension.width, CardItem.cardDimension.height);
			
			startingX += 5 + CardItem.cardDimension.width;
			if (startingX + CardItem.cardDimension.width >= panelSize.width) {
				startingX = 5;
				startingY += 5 + CardItem.cardDimension.height;
			}
			
		}
		
	}
	
	//Verificar se todas as cartas foram descobertas
	public boolean allCardsDiscovered() {
		boolean r = true;

		for (int i=0; i < _tableCards.size(); i++) {
			if (_tableCards.get(i).isVisible()) {
				r = false; 
				break;
			}
		}
		return r;
	}
}

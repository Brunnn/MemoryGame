package com.game.card;


import static java.util.Map.entry;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


import com.game.configuration.Constants;
import com.game.configuration.RuntimeConfiguration;





public class CardItem extends JLabel implements MouseListener {
	
	public static Map<String, CardEntry> options = Map.ofEntries(
			entry("alcool1.jpg", new CardEntry("alcool1.jpg" , "O uso de alcool gel desinfeta e age como antisseptico na pele, deve-se limpar as m�os com ele todas as vezes que tocar em algo em algum ambiente externo.")),
			entry("doc1.jpg", new CardEntry("doc1.jpg", "Milh�es de m�dicos pelo mundo est�o lutando contra o COVID-19")),
			entry("doc2.jpg", new CardEntry("doc2.jpg", "M�dicos do mundo inteiro est�o arriscando suas vidas para proteger a popula��o")),
			entry("ead1.jpg", new CardEntry("ead1.jpg", "EAD � a �nica forma de ensino vi�vel enquanto estamos em pandemia")),
			entry("ead2.jpg", new CardEntry("ead2.jpg", "Mesmo a dist�ncia, todos devem acompanhar as aulas e realizar suas tarefas normalmente\r\n")),
			entry("febre1.jpg", new CardEntry("febre1.jpg", "Febre � um dos poss�veis sistomas da COVID-19, se sentir algo assim ou tamb�m tosse seca e cansa�o, procure um m�dico")),
			entry("febre2.jpg", new CardEntry("febre2.jpg", "Febre � um dos poss�veis sistomas da COVID-19, se sentir algo assim ou tamb�m tosse seca e cansa�o, procure um m�dico")),
			entry("hosp1.jpg", new CardEntry("hosp1.jpg", "Hospitais do Brasil inteiro ficaram lotados no come�o/meio da pandemia")),
			entry("mask1.jpg", new CardEntry("mask1.jpg", "O uso das m�scaras se tornou obrigat�rio com a pandemia, quem n�o usar al�m de correr o risco de se infectar ou infectar outras pessoas, ainda pode levar multas de alto valor")),
			entry("mask2.jpg", new CardEntry("mask2.jpg", "As m�scaras ajudam na n�o propaga��o do v�rus em grande escala. Use m�scara e cuide de quem cuida de voc�!")),
			entry("vacine1.jpg", new CardEntry("vacine1.jpg", "As vacinas est�o sendo distribuidas no Brasil inteiro como uma forma de acabar de vez com o v�rus. At� 11 de junho, cerca de 11% da popula��o brasileira ja est� totalmente vacinada.")),
			entry("virus1.jpg", new CardEntry("virus1.jpg", "O COVID-19 � uma infec��o respirat�ria aguda, podendo ser grave e com uma taxa de transmiss�o elevada. Para a conten��o dele devemos lavar muito bem as m�os, usar m�scara e evitar lugares tumultuados."))
	);
	
	
	public static Dimension cardDimension = new Dimension(160,160);
	private String _itemId;
	
	private boolean _isDrawn;
	
	private ICardItemListener _cardItemController;
	public CardItem(String itemId, ICardItemListener cardItemController) {
		_itemId = itemId;
		_cardItemController = cardItemController;
		
		
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		hideCardImage();
		
		addMouseListener(this);
	}
	
	
	
	public ImageIcon getImageIcon() {
		ImageIcon icon = null;
		Image scaled = options.get(_itemId).getBufferedImage().getScaledInstance(cardDimension.width, cardDimension.height, Image.SCALE_SMOOTH);
		icon = new ImageIcon(scaled);
		return icon;
	}
	
	public String getItemDescriptiom() {
		
		CardEntry cardEntry = CardItem.options.get(_itemId);
		return cardEntry.getImageDescription();
	}
	
	public void drawCardImage() {

		setIcon(getImageIcon());
		_isDrawn = true;
	}
	
	public void hideCardImage() {
		setIcon(null);
		setOpaque(true);
		setBackground(Constants.cardItemColor);
		setBorder(BorderFactory.createLineBorder(Constants.cardItemBorderColor, 5));
	
		_isDrawn = false;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("dsadas");
		_cardItemController.cardItemClicked(this);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public boolean isDrawn() {
		return _isDrawn;
	}
	
	public String getItemId() {
		return _itemId;
	}
}

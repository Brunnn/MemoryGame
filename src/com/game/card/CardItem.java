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
			entry("alcool1.jpg", new CardEntry("alcool1.jpg" , "O uso de alcool gel desinfeta e age como antisseptico na pele, deve-se limpar as mãos com ele todas as vezes que tocar em algo em algum ambiente externo.")),
			entry("doc1.jpg", new CardEntry("doc1.jpg", "Milhões de médicos pelo mundo estão lutando contra o COVID-19")),
			entry("doc2.jpg", new CardEntry("doc2.jpg", "Médicos do mundo inteiro estão arriscando suas vidas para proteger a população")),
			entry("ead1.jpg", new CardEntry("ead1.jpg", "EAD é a única forma de ensino viável enquanto estamos em pandemia")),
			entry("ead2.jpg", new CardEntry("ead2.jpg", "Mesmo a distância, todos devem acompanhar as aulas e realizar suas tarefas normalmente\r\n")),
			entry("febre1.jpg", new CardEntry("febre1.jpg", "Febre é um dos possíveis sistomas da COVID-19, se sentir algo assim ou também tosse seca e cansaço, procure um médico")),
			entry("febre2.jpg", new CardEntry("febre2.jpg", "Febre é um dos possíveis sistomas da COVID-19, se sentir algo assim ou também tosse seca e cansaço, procure um médico")),
			entry("hosp1.jpg", new CardEntry("hosp1.jpg", "Hospitais do Brasil inteiro ficaram lotados no começo/meio da pandemia")),
			entry("mask1.jpg", new CardEntry("mask1.jpg", "O uso das máscaras se tornou obrigatório com a pandemia, quem não usar além de correr o risco de se infectar ou infectar outras pessoas, ainda pode levar multas de alto valor")),
			entry("mask2.jpg", new CardEntry("mask2.jpg", "As máscaras ajudam na não propagação do vírus em grande escala. Use máscara e cuide de quem cuida de você!")),
			entry("vacine1.jpg", new CardEntry("vacine1.jpg", "As vacinas estão sendo distribuidas no Brasil inteiro como uma forma de acabar de vez com o vírus. Até 11 de junho, cerca de 11% da população brasileira ja está totalmente vacinada.")),
			entry("virus1.jpg", new CardEntry("virus1.jpg", "O COVID-19 é uma infecção respiratória aguda, podendo ser grave e com uma taxa de transmissão elevada. Para a contenção dele devemos lavar muito bem as mãos, usar máscara e evitar lugares tumultuados."))
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

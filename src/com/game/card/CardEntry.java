package com.game.card;

import java.awt.image.BufferedImage;
import java.io.File;


import javax.imageio.ImageIO;


import com.game.configuration.RuntimeConfiguration;

public class CardEntry {

	private BufferedImage _bufferedImage;
	private String _description;
	public CardEntry(String imagePath, String description) {
		_description = description;
		_bufferedImage = PreloadImage(imagePath);
	}
	
	private BufferedImage PreloadImage(String imagePath) {
		RuntimeConfiguration runtimeConfiguration = RuntimeConfiguration.getRuntimeConfiguration();
		BufferedImage bufferedImage = null;
		try {
			bufferedImage = ImageIO.read(new File(runtimeConfiguration.workingDir+"/src/images/"+imagePath));
		}
		catch (Exception e) {
			System.out.println("Imagem não encontrada: "+imagePath);
		}
		return bufferedImage;
	}
	public BufferedImage getBufferedImage() {
		return _bufferedImage;
	}
	public String getImageDescription() {
		return _description;
	}
}

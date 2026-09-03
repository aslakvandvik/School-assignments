package no.uib.this OOP course.view;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ViewPrinter {

	public static void savePanelAsImage(JPanel panel, String filePath) {
		BufferedImage image = new BufferedImage(
				panel.getWidth(), panel.getHeight(), BufferedImage.TYPE_INT_ARGB);

		Graphics2D g2d = image.createGraphics();

		panel.paint(g2d);
		g2d.dispose();

		try {
			File file = new File(filePath);
			ImageIO.write(image, "png", file);
			System.out.println("Panel saved as: " + filePath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

import javax.swing.*;
import java.awt.image.BufferedImage;

public class ImageBlurrer extends JFrame {
	private JSlider blurSlider;
	private JLabel imageLabel;
	private BufferedImage orignalImage;
	private BufferedImage newImage;

	public ImageBlurrer() {

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			ImageBlurrer frame = new ImageBlurrer();
			frame.setVisible(true);
		});
	}

	private void updateBuffer() {

	}

	private BufferedImage applyBlur(BufferedImage src, int radius) {

	}


}
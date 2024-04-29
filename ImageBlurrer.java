import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageBlurrer extends JFrame {
	private JSlider blurSlider;
	private JLabel imageLabel;
	private BufferedImage originalImage;
	private BufferedImage newImage;

	public ImageBlurrer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Image Blurrer");
		setSize(800, 600);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		try {
			originalImage = ImageIO.read(new File("image.png"));
			imageLabel = new JLabel(new ImageIcon(originalImage));
		} catch (IOException e) {
			e.printStackTrace();
			imageLabel = new JLabel("Unable to load image.png");
		}
		add(imageLabel, BorderLayout.CENTER);

		blurSlider = new JSlider(0, 20, 0);
        blurSlider.setMajorTickSpacing(5);
        blurSlider.setMinorTickSpacing(1);
        blurSlider.setPaintTicks(true);
        blurSlider.setPaintLabels(true);
        blurSlider.addChangeListener(e -> updateBlur());
        add(blurSlider, BorderLayout.SOUTH);

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			ImageBlurrer frame = new ImageBlurrer();
			frame.setVisible(true);
		});
	}

	private void updateBlur() {
		newImage = applyBlur(originalImage, blurSlider.getValue());
		imageLabel.setIcon(new ImageIcon(newImage));
	}

	private BufferedImage applyBlur(BufferedImage src, float radius) {
		return src.getSubimage(0, 0, (int) ((1 + radius) * 8), (int) ((1 + radius) * 8));
	}


}
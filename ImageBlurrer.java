import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class ImageBlurrer extends JFrame {
	private final JSlider blurSlider;
	private JLabel imageLabel;
	private BufferedImage originalImage;

	public ImageBlurrer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Image Blurrer");
		setSize(800, 600);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		try {
			originalImage = ImageIO.read(new File("pik.png"));
			imageLabel = new JLabel(new ImageIcon(originalImage));
		} catch (IOException e) {
			e.printStackTrace();
			imageLabel = new JLabel("Unable to load pik.png");
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
		int blurIntensity = blurSlider.getValue();
		BufferedImage newImage = blur(originalImage, blurIntensity);
		imageLabel.setIcon(new ImageIcon(newImage));
	}

	public static BufferedImage blur(BufferedImage image, int blurIntensity) {
		if (blurIntensity < 1) {
			return image;
		}

		if (blurIntensity % 2 == 0) {
			blurIntensity++;
		}

		float[] matrix = new float[blurIntensity * blurIntensity];
		float blurFactor = 1.0f / (blurIntensity * blurIntensity);
		Arrays.fill(matrix, blurFactor);

		BufferedImageOp op = new ConvolveOp(new Kernel(blurIntensity, blurIntensity, matrix),
				ConvolveOp.EDGE_NO_OP, null);
		return op.filter(image, null);
	}
}
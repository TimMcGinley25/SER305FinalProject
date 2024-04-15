import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class ImageBlurrer extends JFrame {
	private JSlider blurSlider;
	private JLabel imageLabel;
	private BufferedImage orignalImage;
	private BufferedImage newImage;

	public ImageBlurrer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Image Blurrer");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

		try{
			originalImage = imageIO.read(new File("image.png"));
			imageLabel = new JLabel(bew ImageIcon(originalImage));
		}catch (IOException e){
			e.printStackTrace();
			imageLabel = new JLabel("Unable to load image.png");
		}
		add(imageLabel, BorderLayout.CEN)

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			ImageBlurrer frame = new ImageBlurrer();
			frame.setVisible(true);
		});
	}

	private void updateBlur() {

	}

	private BufferedImage applyBlur(BufferedImage src, int radius) {

	}


}
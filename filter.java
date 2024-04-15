import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class ImageBluerrer extends JFrame {
    private JSlider blurSlider;
    private JLabel imageLabel;
    private BufferedImage orignalImage;
    private BufferedImage newImage;

    public ImageBluerrer(){

    }

    private void updateBufferrer(){

    }

    private BufferedImage applyBlur(BufferedImage src, int radius){
        
    }





    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ImageBlurrer frame = new ImageBlurrer();
            frame.setVisible(true);
        });
    }



}
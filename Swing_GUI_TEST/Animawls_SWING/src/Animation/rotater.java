package Animation;


import java.awt.*;  
import java.awt.geom.AffineTransform;  
import java.awt.image.BufferedImage;  
import java.io.*;  
import javax.swing.*;  
  
public class rotater extends JPanel {  
    BufferedImage image;  
  
    public rotater(BufferedImage image) {  
        this.image = image;  
    }  
  
    protected void paintComponent(Graphics g) {  
        super.paintComponent(g);  
        Graphics2D g2 = (Graphics2D)g;  
        int iw = image.getWidth();  
        int ih = image.getHeight();  
        double x = 50;  
        double y = 50;  
        AffineTransform at = AffineTransform.getTranslateInstance(x, y);  
        at.rotate(Math.PI/6, iw/2, ih/2);  
        g2.drawRenderedImage(image, at);  
        x = 150;  
        y = 150;  
        at.setToTranslation(x, y);  
        at.rotate(Math.PI/4, iw/2, ih/2);  
        g2.drawRenderedImage(image, at);  
        x = 250;  
        y = 250;  
        at.setToTranslation(x, y);  
        at.rotate(Math.PI/3, iw/2, ih/2);  
        g2.drawRenderedImage(image, at);  
    }  
  
    public static void main(String[] args) throws IOException {  
        File file = new File("IMAGES/ANIMATION_TEST/frame0.png");  
        BufferedImage image = javax.imageio.ImageIO.read(file);  
        JFrame f = new JFrame();  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        f.add(new rotater(image));  
        f.setSize(800,800);  
        f.setLocation(100,100);  
        f.setVisible(true);  
    }  
}  
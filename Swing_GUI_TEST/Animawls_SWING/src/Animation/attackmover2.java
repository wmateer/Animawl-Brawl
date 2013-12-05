package Animation;


import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class attackmover2 extends JLabel implements ActionListener
{
    int deltaX = 2;
    int deltaY = 3;
    int directionX = 1;
    int directionY = 1;
    
    private BufferedImage resizeImage(BufferedImage originalImage, int width, int height, int type) throws IOException {  
        BufferedImage resizedImage = new BufferedImage(width, height, type);  
        Graphics2D g = resizedImage.createGraphics();  
        g.drawImage(originalImage, 0, 0, width, height, null);  
        g.dispose();  
        return resizedImage;  
    }  


    public attackmover2(String imgPath,int startX, int startY,int deltaX, int deltaY,int directionX, int directionY,int delay)
    {
        this.deltaX = deltaX;
        this.deltaY = deltaY;
        this.directionX = directionX;
        this.directionY = directionY;

        try{
        	BufferedImage unsizedAnimalPicture = ImageIO.read(new File(imgPath));
    		BufferedImage sizedAnimalPicture = resizeImage(unsizedAnimalPicture,200,200, unsizedAnimalPicture.getType());
    		setIcon(new ImageIcon(sizedAnimalPicture));
        }
        catch(Exception purple){
        	purple.printStackTrace();
        }
        
       // setIcon( new ImageIcon("IMAGES/ANIMATION_TEST/frame0.png") );
        //setIcon( new ImageIcon(imgPath) );

        setSize( getPreferredSize() );
        setLocation(startX, startY);
        new javax.swing.Timer(delay, this).start();
    }

    public void actionPerformed(ActionEvent e)
    {
        Container parent = getParent();

        //  Determine next X position

        int nextX = getLocation().x + (deltaX * directionX);

        if (nextX < 100)
        {
        	
            nextX = 100;
            directionX *= 0;
            //directionX *= -1;
        }

        if ( nextX + getSize().width > (parent.getSize().width -300))
        {
            nextX = parent.getSize().width - getSize().width -300;
            directionX *= -1;
        }

        //  Determine next Y position

        int nextY = getLocation().y + (deltaY * directionY);

        if (nextY < 0)
        {
            nextY = 0;
            directionY *= -1;
        }

        if ( nextY + getSize().height > parent.getSize().height)
        {
            nextY = parent.getSize().height - getSize().height;
            directionY *= -1;
        }

        //  Move the label

        setLocation(nextX, nextY);
    }

    
    public static void main(String[] args)
    {
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();

        frame.setContentPane(panel);
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.getContentPane().setLayout(null);
//      frame.getContentPane().add( new TimerAnimation(10, 10, 2, 3, 1, 1, 10) );
        //frame.getContentPane().add( new mover(300, 100, 3, 2, -1, 1, 20) );
//      frame.getContentPane().add( new TimerAnimation(0, 000, 5, 0, 1, 1, 20) );
        frame.getContentPane().add( new attackmover2("IMAGES/ANIMATION_TEST/frame0.png",0, 200, 5, 0, 1, 1, 80) );
        frame.setSize(400, 400);
        frame.setLocationRelativeTo( null );
        frame.setVisible(true);
//      frame.getContentPane().add( new TimerAnimation(10, 10, 2, 3, 1, 1, 10) );
//      frame.getContentPane().add( new TimerAnimation(10, 10, 3, 0, 1, 1, 10) );
    }
   
    
}
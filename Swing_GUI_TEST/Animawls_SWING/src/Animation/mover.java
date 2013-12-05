package Animation;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class mover extends JLabel implements ActionListener
{
    int deltaX = 2;
    int deltaY = 3;
    int directionX = 1;
    int directionY = 1;

    public mover(
        int startX, int startY,
        int deltaX, int deltaY,
        int directionX, int directionY,
        int delay)
    {
        this.deltaX = deltaX;
        this.deltaY = deltaY;
        this.directionX = directionX;
        this.directionY = directionY;

        setIcon( new ImageIcon("IMAGES/ANIMATION_TEST/frame0.png") );

        setSize( getPreferredSize() );
        setLocation(startX, startY);
        new javax.swing.Timer(delay, this).start();
    }

    public void actionPerformed(ActionEvent e)
    {
        Container parent = getParent();

        //  Determine next X position

        int nextX = getLocation().x + (deltaX * directionX);

        if (nextX < 0)
        {
            nextX = 0;
            directionX *= -1;
        }

        if ( nextX + getSize().width > parent.getSize().width)
        {
            nextX = parent.getSize().width - getSize().width;
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
        frame.getContentPane().add( new mover(0, 200, 5, 0, 1, 1, 80) );
        frame.setSize(400, 400);
        frame.setLocationRelativeTo( null );
        frame.setVisible(true);
//      frame.getContentPane().add( new TimerAnimation(10, 10, 2, 3, 1, 1, 10) );
//      frame.getContentPane().add( new TimerAnimation(10, 10, 3, 0, 1, 1, 10) );
    }
}
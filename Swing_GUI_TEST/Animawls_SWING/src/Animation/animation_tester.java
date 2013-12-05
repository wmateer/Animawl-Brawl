
package Animation;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class animation_tester {
public static void main(String args[]) {
JFrame f = new JFrame();
JPanel panel = new JPanel();
Animation_Test s = new Animation_Test();
f.add(s);
f.setVisible(true);
f.setSize(500, 400);

//f.setContentPane(panel);
//f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
//f.getContentPane().setLayout(null);
//f.getContentPane().add( new mover(0, 200, 5, 0, 1, 1, 80) );
//f.setSize(400, 400);
//f.setLocationRelativeTo( null );
//f.setVisible(true);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );

}

}
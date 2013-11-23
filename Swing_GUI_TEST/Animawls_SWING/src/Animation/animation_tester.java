
package Animation;

import javax.swing.JFrame;

public class animation_tester {
public static void main(String args[]) {
JFrame f = new JFrame();
Animation_Test s = new Animation_Test();
f.add(s);
f.setVisible(true);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
f.setSize(500, 400);
}

}
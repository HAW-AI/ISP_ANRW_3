/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package viergewinnt;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author aleksandr
 */
public class DrawCircle extends JPanel
{
    private Color c;
    public DrawCircle(Color c) {
        super();
        this.c=c;
        setBounds(0,0,100,100);
        setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(c);
        g.drawOval( 0, 0, 100, 100 );
        g.fillOval(0, 0, 100, 100);
    }  
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package viergewinnt;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author aleksandr
 */
public class ClickListner implements MouseListener{

    private int field;
    public ClickListner(int field) {
        this.field=field;
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        VierGewinnt.getInstance().clickOn(field);
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
    
}

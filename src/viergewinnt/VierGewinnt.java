/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package viergewinnt;

import java.awt.Color;

/**
 *
 * @author aleksandr
 */
public class VierGewinnt {
    private boolean player=false;
    private static VierGewinnt instance; 
    private static Main m;
    private Integer[][] rows;
    private VierGewinnt() {
        m=new Main();
        m.setVisible(true);
        rows=new Integer[7][6];
        rows[0]=new Integer[6];
        rows[1]=new Integer[6];
        rows[2]=new Integer[6];
        rows[3]=new Integer[6];
        rows[4]=new Integer[6];
        rows[5]=new Integer[6];
        rows[6]=new Integer[6];
        
        computer();
    }
    public static VierGewinnt getInstance(){
        if(instance==null) {
            instance=new VierGewinnt();
        }
        return instance;
    }
    public void clickOn(int num){
        if(player) {
            player=false;
            int free=0;
            int row=((num-1)%7);
            player(getFree(row));
        }
    }
    public void player(int num){
         m.paintCircle(num, new DrawCircle(Color.blue));
         computer();
    }
    private int getFree(int row){
        int free=0;
        System.out.println("Row:"+row);
        for(int i=0;i<6;i++){
            if(rows[row][i]==null) {
                free=i;
            }
        }
        rows[row][free]=1;
        System.out.println("Free:"+free);
        return row+(7*free)+1;
    }
    public void computer(){
        m.paintCircle(getFree(3), new DrawCircle(Color.red));
        player=true;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                VierGewinnt.getInstance();
                
            }
        });
    }
}

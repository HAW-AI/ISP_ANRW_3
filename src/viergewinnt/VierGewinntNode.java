/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package viergewinnt;

/**
 *
 * @author aleksandr
 */
public class VierGewinntNode extends Node{

    private Integer[][] rows;
    public VierGewinntNode(Integer[][] rows) {
        this.rows=rows;
    }

    
    @Override
    public int eval() {
        int winAccu=0;
        int loseAccu=0;
        for(int i=0;i<7;i++){
            Integer[] r=rows(i);
            if(r[0]+r[2]>=4){
                winAccu++;
            }
            if(r[1]+r[2]>=4){
                loseAccu++;
            }
        }
        for(int i=0;i<6;i++){
            Integer[] c=cols(i);
            if(c[0]+c[2]>=4){
                winAccu++;
            }
            if(c[1]+c[2]>=4){
                loseAccu++;
            }
        }
        Integer[] d;
        d=diagonal(0,0,1);
        if(d[0]+d[2]>=4){ winAccu++; }
        if(d[1]+d[2]>=4){loseAccu++;}
        d=diagonal(0,1,1);
        if(d[0]+d[2]>=4){ winAccu++; }
        if(d[1]+d[2]>=4){loseAccu++;}
        d=diagonal(0,2,1);
        if(d[0]+d[2]>=4){ winAccu++; }
        if(d[1]+d[2]>=4){loseAccu++;}
        d=diagonal(1,0,1);
        if(d[0]+d[2]>=4){ winAccu++; }
        if(d[1]+d[2]>=4){loseAccu++;}
        d=diagonal(2,0,1);
        if(d[0]+d[2]>=4){ winAccu++; }
        if(d[1]+d[2]>=4){loseAccu++;}
        d=diagonal(3,0,1);
        if(d[0]+d[2]>=4){ winAccu++; }
        if(d[1]+d[2]>=4){loseAccu++;}
        
        d=diagonal(0,0,-1);
        if(d[0]+d[2]>=4){ winAccu++; }
        if(d[1]+d[2]>=4){loseAccu++;}
        d=diagonal(0,1,-1);
        if(d[0]+d[2]>=4){ winAccu++; }
        if(d[1]+d[2]>=4){loseAccu++;}
        d=diagonal(0,2,-1);
        if(d[0]+d[2]>=4){ winAccu++; }
        if(d[1]+d[2]>=4){loseAccu++;}
        d=diagonal(1,0,-1);
        if(d[0]+d[2]>=4){ winAccu++; }
        if(d[1]+d[2]>=4){loseAccu++;}
        d=diagonal(2,0,-1);
        if(d[0]+d[2]>=4){ winAccu++; }
        if(d[1]+d[2]>=4){loseAccu++;}
        d=diagonal(3,0,-1);
        if(d[0]+d[2]>=4){ winAccu++; }
        if(d[1]+d[2]>=4){loseAccu++;}
        
        return winAccu-loseAccu;
    }
    private Integer[] cols(int col){
        int minAccu=0;
        int maxAccu=0;
        for(int i=0;i<7;i++){
            if(rows[i][col]==MIN){
                minAccu++;
            }
            if(rows[i][col]==MAX){
                maxAccu++;
            }
        }
        int free=7-(maxAccu+minAccu);
        return new Integer[]{maxAccu,minAccu,free};
    }
    private Integer[] rows(int row){
        int minAccu=0;
        int maxAccu=0;
        for(int i=0;i<6;i++){
            if(rows[row][i]==MIN){
                minAccu++;
            }
            if(rows[row][i]==MAX){
                maxAccu++;
            }
        }
        int free=7-(maxAccu+minAccu);
        return new Integer[]{maxAccu,minAccu,free};
    }
    private Integer[] diagonal(int r,int c, int direction){
        int minAccu=0;
        int maxAccu=0;
        for(int i=r, j=c;i<7 && j<6;i=i+direction,j++){
            if(rows[i][j]==MIN){
                minAccu++;
            }
            if(rows[i][j]==MAX){
                maxAccu++;
            }
        }
        int free=7-(maxAccu+minAccu);
        return new Integer[]{maxAccu,minAccu,free};
    }
    
}

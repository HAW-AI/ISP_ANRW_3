/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package viergewinnt;

import java.util.ArrayList;

/**
 *
 * @author aleksandr
 */
public abstract class Node {
    public static final int MIN=1;
    public static final int MAX=2;
    private ArrayList<Node> children=new ArrayList<Node>();
    protected Node parent;
    private int type;
    private Node bestChild;
    public void addChild(Node child){
        child.parent=this;
        children.add(child);
    }
    public Node getChild(int num){
        return children.get(num);
    }
    public int count(){
        return children.size();
    }
    public int minmaxAB(int a,int b){
        if(count()>0) {
            return eval();
        }
        int best;
        if(type==MAX){
            best = Integer.MIN_VALUE;
            for(int i=0; i<count();i++){
                if(best >a) {
                    a = best;
                }
                Node child=children.get(i);
                int val = child.minmaxAB(a, b);
                if(val > best) {
                    best = val;
                    bestChild=child;
                }
                if(best >=b) {
                    return best;
                }
            }
        }else{
            best = Integer.MAX_VALUE;
            for(int i=0; i<count();i++){
                if(best < b) {
                    b = best;
                }
                Node child=children.get(i);
                int val = child.minmaxAB(a, b);
                if(val < best) {
                    best = val;
                    bestChild=child;
                }
                if(a <=best) {
                    return best;
                }
            }
        }
        return best;
    }
    public abstract int eval();
}

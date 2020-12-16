/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Truong-kyle
 */
public class LogicMenhDe {
    private ArrayList<Integer> left;
    private Integer right;

    public LogicMenhDe(ArrayList<Integer> left, Integer right) {
        this.left = left;
        this.right = right;
    }
    
    public LogicMenhDe(){
        left = new ArrayList<>();
        right = 0;
    }

    public ArrayList<Integer> getLeft() {
        return left;
    }
    
    public void addLeft(int Rule) {
        left.add(Rule);
    }
    

    public Integer getRight() {
        return right;
    }

    @Override
    public String toString() {
        return "LogicMenhDe{" + "left=" + left + ", right=" + right + '}';
    }

    public void setLeft(ArrayList<Integer> left) {
        this.left = left;
    }

    public void setRight(Integer right) {
        this.right = right;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Truong-kyle
 */
public class TapLuat {
    private int ruleID;
    private int ruleGroupID;
    private String content;

    public TapLuat(int ruleID, int ruleGroupID, String content) {
        this.ruleID = ruleID;
        this.ruleGroupID = ruleGroupID;
        this.content = content;
    }

    public int getRuleID() {
        return ruleID;
    }

    public int getRuleGroupID() {
        return ruleGroupID;
    }

    public String getContent() {
        return content;
    }

    public void setRuleID(int ruleID) {
        this.ruleID = ruleID;
    }

    public void setRuleGroupID(int ruleGroupID) {
        this.ruleGroupID = ruleGroupID;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "TapLuat{" + "ruleID=" + ruleID + ", ruleGroupID=" + ruleGroupID + ", content=" + content + '}';
    }

  
    
}

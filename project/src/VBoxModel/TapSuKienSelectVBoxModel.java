/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VBoxModel;

import Model.TapSuKien;

/**
 *
 * @author Truong-kyle
 */
public class TapSuKienSelectVBoxModel {

    private TapSuKien value;
    private String label;

    public TapSuKienSelectVBoxModel(TapSuKien value) {
        this.value = value;
        this.label = value.getValue();
    }

    public TapSuKien getValue() {
        return this.value;
    }

    public String getLabel() {
        return this.label;
    }

    @Override
    public String toString() {
//        return label;
    return String.format("%-20s%s", value.getValue().trim(), "(" + value.getEventTypeName().trim() + ")");
    }
}

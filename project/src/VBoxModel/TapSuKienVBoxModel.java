/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VBoxModel;

import Model.TapLoaiSuKien;

/**
 *
 * @author Truong-kyle
 */
public class TapSuKienVBoxModel {

    private TapLoaiSuKien value;
    private String label;

    public TapSuKienVBoxModel(TapLoaiSuKien value) {
        this.value = value;
        this.label = value.getName();
    }

    public TapLoaiSuKien getValue() {
        return this.value;
    }

    public String getLabel() {
        return this.label;
    }

    @Override
    public String toString() {
        return label;
    }
}

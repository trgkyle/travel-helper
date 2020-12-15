/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VBoxModel;
import Model.TapLuat;
/**
 *
 * @author Truong-kyle
 */
public class TapLuatVBoxModel {

    private TapLuat value;
    private String label;

    public TapLuatVBoxModel(TapLuat value) {
        this.value = value;
        this.label = value.getContent();
    }

    public TapLuat getValue() {
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

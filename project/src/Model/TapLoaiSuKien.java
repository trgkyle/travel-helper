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
public class TapLoaiSuKien {
    private int eventTypeID;
    private String name;

    public TapLoaiSuKien(int eventTypeID, String name) {
        this.eventTypeID = eventTypeID;
        this.name = name;
    }

    @Override
    public String toString() {
        return "TapNhomSuKien{" + "eventTypeID=" + eventTypeID + ", name=" + name + '}';
    }

    public void setEventTypeID(int eventTypeID) {
        this.eventTypeID = eventTypeID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEventTypeID() {
        return eventTypeID;
    }

    public String getName() {
        return name;
    }
}

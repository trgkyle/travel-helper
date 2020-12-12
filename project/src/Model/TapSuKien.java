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
public class TapSuKien {
    private int eventID;
    private int eventTypeID;
    private String value;
    private String eventTypeName;
    
    public TapSuKien(int eventID, int eventTypeID, String value, String eventTypeName) {
        this.eventID = eventID;
        this.eventTypeID = eventTypeID;
        this.value = value;
        this.eventTypeName = eventTypeName;
    }

    public String getEventTypeName() {
        return eventTypeName;
    }

    public void setEventTypeName(String eventTypeName) {
        this.eventTypeName = eventTypeName;
    }
    
    public int getEventID() {
        return eventID;
    }

    public int getEventTypeID() {
        return eventTypeID;
    }

    public String getValue() {
        return value;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public void setEventTypeID(int eventTypeID) {
        this.eventTypeID = eventTypeID;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "TapSuKien{" + "eventID=" + eventID + ", eventTypeID=" + eventTypeID + ", value=" + value + ", eventTypeName=" + eventTypeName + '}';
    }
    
}

package br.com.dnc.pmcheatweb.dto.calendar;

import java.util.List;

public class CalendarResponse {

    private Location location;
    private List<Event> listEvents;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Event> getListEvents() {
        return listEvents;
    }

    public void setListEvents(List<Event> listEvents) {
        this.listEvents = listEvents;
    }

    @Override
    public String toString() {
        return "CalendarResponse{" +
            "location=" + location +
            ", listEvents=" + listEvents +
            '}';
    }
}

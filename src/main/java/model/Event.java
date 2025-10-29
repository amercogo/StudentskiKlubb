package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Event {
    private Long id;
    private String title;
    private LocalDate date;
    private String location;
    private int likes;                 // za jednostavnu akciju "like"
    private List<Member> attendees = new ArrayList<>(); // 1:N: jedan Event ima više Member-a

    public Event() {}

    public Event(Long id, String title, LocalDate date, String location) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.location = location;
    }

    // getteri/setteri
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public LocalDate getDate() { return date; }
    public String getLocation() { return location; }
    public int getLikes() { return likes; }
    public List<Member> getAttendees() { return attendees; }

    public void setId(Long id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setDate(LocalDate date) { this.date = date; }
    public void setLocation(String location) { this.location = location; }
    public void setLikes(int likes) { this.likes = likes; }
    public void setAttendees(List<Member> attendees) { this.attendees = attendees; }

    public void like() { this.likes++; }
    public void addAttendee(Member m) { this.attendees.add(m); }
}

package data;

import model.Event;
import model.Member;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.*;

@Component
public class DemoData {

    private final List<Event> events = new ArrayList<>();
    private final List<Member> members = new ArrayList<>();
    private final Map<Long, Event> eventById = new HashMap<>();

    @PostConstruct
    public void init() {
        // Members
        members.add(new Member(1L, "Amina Hadžić", "amina@example.com", "Student", 2023));
        members.add(new Member(2L, "Kenan K.",
                "kenan@example.com", "Organizer", 2022));
        members.add(new Member(3L, "Sara S.", "sara@example.com", "Student", 2024));
        members.add(new Member(4L, "Luka L.", "luka@example.com", "Student", 2021));

        // Events
        Event e1 = new Event(1L, "Welcome Meetup", LocalDate.now().plusDays(3), "Sala A");
        Event e2 = new Event(2L, "Hack Night", LocalDate.now().plusDays(10), "Lab 2");
        Event e3 = new Event(3L, "CV & Careers", LocalDate.now().plusDays(20), "Sala B");

        // 1:N – dodajemo članove na evente
        e1.addAttendee(members.get(0));
        e1.addAttendee(members.get(2));

        e2.addAttendee(members.get(1));
        e2.addAttendee(members.get(3));

        events.addAll(Arrays.asList(e1, e2, e3));
        events.forEach(ev -> eventById.put(ev.getId(), ev));
    }

    // Getteri da kontroler može čitati
    public List<Event> getEvents() { return events; }
    public List<Member> getMembers() { return members; }
    public Optional<Event> findEvent(Long id) { return Optional.ofNullable(eventById.get(id)); }
}

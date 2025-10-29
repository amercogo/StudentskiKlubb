package controller;

import data.DemoData;
import model.Event;
import model.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@Controller
public class AppController {

    private final DemoData data;

    public AppController(DemoData data) {
        this.data = data;
    }

    // Redirect root -> /a (lista Event-a)
    @GetMapping("/")
    public String home() {
        return "redirect:/a";
    }

    // /a : lista Event-a (Model A)
    @GetMapping("/a")
    public String listEvents(Model model) {
        List<Event> events = data.getEvents().stream()
                .sorted(Comparator.comparing(Event::getDate))
                .toList();
        model.addAttribute("events", events);
        return "listaA";
    }

    // /b : lista Member-a (Model B)
    @GetMapping("/b")
    public String listMembers(Model model) {
        List<Member> members = data.getMembers();
        model.addAttribute("members", members);
        return "listaB";
    }

    // /a/action/{id} : stranica akcije za Event
    // GET param 'do=like' povecava lajkove; GET param 'addMemberId=...' dodaje clana
    @GetMapping("/a/action/{id}")
    public String eventAction(
            @PathVariable Long id,
            @RequestParam(name = "do", required = false) String action,
            @RequestParam(name = "addMemberId", required = false) Long addMemberId,
            Model model
    ) {
        Event event = data.findEvent(id).orElse(null);
        if (event == null) {
            model.addAttribute("error", "Event not found");
            return "action";
        }

        if ("like".equalsIgnoreCase(action)) {
            event.like();
        }
        if (addMemberId != null) {
            data.getMembers().stream()
                    .filter(m -> m.getId().equals(addMemberId))
                    .findFirst()
                    .ifPresent(event::addAttendee);
        }

        model.addAttribute("event", event);
        model.addAttribute("allMembers", data.getMembers()); // dropdown za dodavanje
        return "action";
    }
}

package model;

public class Member {
    private Long id;
    private String name;
    private String email;
    private String role;     // npr. "Student", "Organizer"
    private int joinedYear;

    public Member() {}

    public Member(Long id, String name, String email, String role, int joinedYear) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
        this.joinedYear = joinedYear;
    }

    // getteri/setteri
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getRole() { return role; }
    public int getJoinedYear() { return joinedYear; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setRole(String role) { this.role = role; }
    public void setJoinedYear(int joinedYear) { this.joinedYear = joinedYear; }
}

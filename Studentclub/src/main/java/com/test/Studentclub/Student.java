package com.test.Studentclub;

import java.util.Objects;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String email;

    @ManyToMany
    @JoinTable(
        name = "student_club",
        joinColumns = @JoinColumn(name = "student_id"),          // FK to student
        inverseJoinColumns = @JoinColumn(name = "club_id")       // FK to club
    )
    private Set<Club> clubs;

    public Student() {}

    public Student(String name, String email) {
        this.name = name;
        this.email = email;
    }

	public Student(int id, String name, String email, Set<Club> clubs) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.clubs = clubs;
	}

	public Student(String name, String email, Set<Club> clubs) {
		super();
		this.name = name;
		this.email = email;
		this.clubs = clubs;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Club> getClubs() {
		return clubs;
	}

	public void setClubs(Set<Club> clubs) {
		this.clubs = clubs;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", clubs=" + clubs + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(clubs, email, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(clubs, other.clubs) && Objects.equals(email, other.email) && id == other.id
				&& Objects.equals(name, other.name);
	}

    // getters & setters
}

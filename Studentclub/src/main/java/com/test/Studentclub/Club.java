package com.test.Studentclub;



import javax.persistence.*;
import java.util.Set;
import java.util.HashSet;
import java.util.Objects;

@Entity
@Table(name = "club")
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "club_name")
    private String clubName;

    @ManyToMany(mappedBy = "clubs") // Student owns the relationship
    private Set<Student> students = new HashSet<>();

    public Club() {}

    public Club(String clubName) {
        this.clubName = clubName;
    }

	public Club(String clubName, Set<Student> students) {
		super();
		this.clubName = clubName;
		this.students = students;
	}

	public Club(int id, String clubName, Set<Student> students) {
		super();
		this.id = id;
		this.clubName = clubName;
		this.students = students;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClubName() {
		return clubName;
	}

	public void setClubName(String clubName) {
		this.clubName = clubName;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Club [id=" + id + ", clubName=" + clubName + ", students=" + students + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(clubName, id, students);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Club other = (Club) obj;
		return Objects.equals(clubName, other.clubName) && id == other.id && Objects.equals(students, other.students);
	}

    // getters and setters
}




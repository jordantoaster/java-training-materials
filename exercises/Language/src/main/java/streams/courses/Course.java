package streams.courses;

import java.util.List;

public class Course {
	private String id;
	private String title;
	private CourseType type;
	private int duration;
	private List<Trainer> instructors;

	public Course(String id, String title, CourseType type, int duration, List<Trainer> instructors) {
		super();
		this.id = id;
		this.title = title;
		this.type = type;
		this.duration = duration;
		this.instructors = instructors;
	}
	
	public String getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public CourseType getType() {
		return type;
	}
	public int getDuration() {
		return duration;
	}
	public List<Trainer> getInstructors() {
		return instructors;
	}
}

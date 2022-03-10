package streams.courses;

import java.util.List;

public class Trainer {
	public Trainer(String name, double rate, List<String> skills) {
		super();
		this.name = name;
		this.rate = rate;
		this.skills = skills;
	}
	
	public String getName() {
		return name;
	}
	public double getRate() {
		return rate;
	}
	public List<String> getSkills() {
		return skills;
	}
	public String toString() {
		return name;
	}

	private String name;
	private double rate;
	private List<String> skills;
}

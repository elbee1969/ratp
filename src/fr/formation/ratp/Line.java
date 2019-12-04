package fr.formation.ratp;

public class Line {

	public Line(String name) {
		this.name = name;
	}

	public Line() {
		// TODO Auto-generated constructor stub
	}

	private String name;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return this.getName();
	}

}

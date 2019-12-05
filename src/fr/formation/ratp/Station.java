package fr.formation.ratp;

public class Station {
	public static int length;

	public Station(String name, Line line) {
		this.name = name;
		this.line = line;
	}

	public Station() {
		// TODO Auto-generated constructor stub
	}

	private String name;
	private Line line;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Line getLine() {
		return line;
	}

	public void setLine(Line line) {
		this.line = line;
	}

	@Override
	public String toString() {
		return this.getName();
		//+ ", line : " + this.getLine();
	};

}

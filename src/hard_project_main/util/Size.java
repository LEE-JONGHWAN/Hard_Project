package hard_project_main.util;

public enum Size {

	SMALL("250"),MEDIUM("500"),
	LARGE("1");


	private String abbreviation;

	public static String[] names() {
		Size[] sizes = values();
		String[] names = new String[sizes.length];

		for (int i = 0; i < sizes.length; i++) {
			names[i] = sizes[i].name();
		}
		return names;
	}

	private Size(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getAbbreviation() {
		return abbreviation;
	}
}

class Player {
	int hp;
	String name;
	String battleCry;

	// Что-то вроде параметров по умолчанию
	Player(String name) {
		this(name, "Lerroy Jenkins");
	}

	Player(String name, String battleCry) {
		hp = 100;
		this.name = name;
		this.battleCry = battleCry;
	}
}
package entity;

public class Hero {
	
	private int heroId;
	private String name;
	private String powerClass;
	private String ability;
	private int powerIndex;
	
	public Hero(int heroId, String name, String powerClass, String ability, int powerIndex) {
		super();
		this.setHeroId(heroId);
		this.setName(name);
		this.setPowerClass(powerClass);
		this.setAbility(ability);
		this.setPowerIndex(powerIndex);
	}

	public int getHeroId() {
		return heroId;
	}

	public void setHeroId(int heroId) {
		this.heroId = heroId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPowerClass() {
		return powerClass;
	}

	public void setPowerClass(String powerClass) {
		this.powerClass = powerClass;
	}

	public String getAbility() {
		return ability;
	}

	public void setAbility(String ability) {
		this.ability = ability;
	}

	public int getPowerIndex() {
		return powerIndex;
	}

	public void setPowerIndex(int powerIndex) {
		this.powerIndex = powerIndex;
	}
	
	
	
}
	

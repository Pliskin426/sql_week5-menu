package entity;

import java.util.List;

public class Team {

	private int teamId;
	private String teamName;
	private List<Hero> heros;
	
	public Team(int teamId, String teamName, List<Hero> heros) {
		super();
		this.setTeamId(teamId);
		this.setTeamName(teamName);
		this.setHeros(heros);
	}

	public List<Hero> getHeros() {
		return heros;
	}

	public void setHeros(List<Hero> heros) {
		this.heros = heros;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	
}

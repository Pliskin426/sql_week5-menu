package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Hero;
import entity.Team;

public class HeroDao {
	
	private Connection connection;
	private final String GET_MEMBERS_BY_TEAM_ID_QUERY = "SELECT * FROM hero WHERE team_id = ?";
	private final String DELETE_HEROS_BY_TEAM_ID_QUERY = "DELETE FROM hero WHERE team_id = ?";
	private final String CREATE_NEW_HERO_QUERY = "INSERT INTO hero(name, power_class, ability, power_index, team_id) VALUES (?,?,?,?,?)";
	private final String DELETE_HERO_BY_HERO_ID_QUERY = "DELETE FROM hero WHERE hero_id = ?";
	//private final String DISPLAY_ALL_HEROS_IN_DB_QUERY = "SELECT * FROM hero";
	
	public HeroDao() {
		connection = DBConnection.getConnection();
	}

	public List<Hero> getMembersByTeamId(int teamId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_MEMBERS_BY_TEAM_ID_QUERY);
		ps.setInt(1, teamId);
		ResultSet rs = ps.executeQuery();
		List<Hero> heros = new ArrayList<Hero>();
		
		while (rs.next()) {
			heros.add(new Hero(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
		}
		return heros;
	}
	
	public void createNewHero(String name, String powerClass, String ability, int powerIndex, int teamId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_HERO_QUERY);
		ps.setString(1, name);
		ps.setString(2, powerClass);
		ps.setString(3, ability);
		ps.setInt(4, powerIndex);
		ps.setInt(5, teamId);
		ps.executeUpdate();
	}
	
	public void deleteHerosByTeamId(int teamId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_HEROS_BY_TEAM_ID_QUERY);
		ps.setInt(1, teamId);
		ps.executeUpdate();
		
	}
	
	public void deleteHerosById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_HERO_BY_HERO_ID_QUERY);
		ps.setInt(1, id);
		ps.executeUpdate();
	}
	
	/*public void getHeros() throws SQLException {
		ResultSet rs = connection.prepareStatement(DISPLAY_ALL_HEROS_IN_DB_QUERY).executeQuery();
		return;
		}*/
		

}

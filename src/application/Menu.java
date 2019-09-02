package application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import DAO.HeroDao;
import DAO.TeamDao;
import entity.Hero;
import entity.Team;

public class Menu {
	private TeamDao teamDao = new TeamDao();
	private HeroDao heroDao = new HeroDao();
	private Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList(
			"Display Teams", 
			"Display a Team", 
			"Create Team", 
			"Delete Team",
			//"Show All Heros",
			"Create Hero", 
			"Delete Hero");
	
	public void start() {
		String selection = "";
		
		do {
			printMenu();
			selection = scanner.nextLine();
			
			try {
				if (selection.equals("1")) {
					displayTeams();
				} else if (selection.contentEquals("2")) {
					displayTeam();
				} else if (selection.contentEquals("3")) {
					createTeam();
				} else if (selection.contentEquals("4")) {
					deleteTeam();
				} else if (selection.contentEquals("7")) {
					//displayHeros();
				} else if (selection.contentEquals("5")) {
					createHero();
				} else if (selection.contentEquals("6")) {
					deleteHero();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			
			System.out.println("Press enter to continue....");
			scanner.hasNextLine();
			
		} while (!selection.equals("-1"));
		
	}
	
	private void printMenu() {
		System.out.println("Welcome to the Marvel Hero Database");
		System.out.println("Select an Option:\n------------------------");
		for (int i = 0; i < options.size(); i++ ) {
			System.out.println(i + 1 + ") " + options.get(i));
		}
	}
	
	private void displayTeams() throws SQLException {
		List<Team> teams = teamDao.getTeams();
		for (Team team : teams) {
			System.out.println(team.getTeamId() + ": " + team.getTeamName());
		}
	}
	
	private void displayTeam() throws SQLException {
		System.out.print("Enter team id: ");
		int id = Integer.parseInt(scanner.nextLine());
		Team team = teamDao.getTeamById(id);
		System.out.println(team.getTeamId() + ": " + team.getTeamName());
		for (Hero hero : team.getHeros()) {
			System.out.println("\tMemberId: " + hero.getHeroId() + " - Name: " + hero.getName());
		}
	}
	
	private void createTeam() throws SQLException {
		System.out.print("Enter new team name:");
		String teamName = scanner.nextLine();
		teamDao.createNewTeam(teamName);
	}
	
	private void deleteTeam() throws SQLException {
		System.out.print("Enter team ID to delete: ");
		int id = Integer.parseInt(scanner.nextLine());
		teamDao.deleteTeamById(id);
	}
	
	private void createHero() throws SQLException {
		System.out.print("Enter hero name: ");
		String name = scanner.nextLine();
		System.out.print("Enter hero class: ");
		String powerClass = scanner.nextLine();
		System.out.print("Enter hero ability: ");
		String ability = scanner.nextLine();
		System.out.print("Enter hero power level (1 - 200): ");
		int powerIndex = Integer.parseInt(scanner.nextLine());
		System.out.print("Enter team id of new hero: ");
		int teamId = Integer.parseInt(scanner.nextLine());
		heroDao.createNewHero(name, powerClass, ability, powerIndex, teamId);
	
	}
	
	private void deleteHero() throws SQLException {
		System.out.println("Enter hero id to delete: ");
		int id = Integer.parseInt(scanner.nextLine());
		heroDao.deleteHerosById(id);
		
	}
	
	//private void displayHeros() throws SQLException {
		//heroDao.getHeros();
		//System.out.println(heroDao.getHeroId() + ": " + heroDao.getName() + "Class: " + heroDao.getPowerClass() + "Ability: " + heroDao.getAbility() + "Power Level: " + heroDao.getPowerIndex());
		//}
}

package logic;

import java.util.ArrayList;

public class Region {
	private String name;
	private ArrayList<Player> playerList;
	private ArrayList<Quest> questList;
	
	public Region (String name) {
		setName(name);
		this.playerList = new ArrayList<Player>();
		this.questList = new ArrayList<Quest>();
	}
	
	public void setName(String name) {
		if (name.isBlank()) {
			this.name = "Nowhere";
			return;
		}
		this.name = name;
		
	}
	
	public int getPlayerCount() {
		return playerList.size();
	}
	
	public double getRegionRank() {
		double totalRank = 0.0;
		
		for (Player player: playerList) {
			totalRank += player.getRank();
		}
		
		return (double) Math.round((totalRank/getPlayerCount())*100)/100;
	}
	
	public ArrayList<Quest> getAvailableQuests(Player viewer) {
		ArrayList<Quest> availableQuests = new ArrayList<Quest>();
		for (Quest quest:questList) {
			if (quest.getStatus().equals(Status.AVAILABLE) && !quest.getAuthor().equals(viewer)) {
				availableQuests.add(quest);
			}
		}
		
		return availableQuests;
	}
	
	public void addPlayerToRegion(Player player) {
		playerList.add(player);
	}
	
	public void addQuestToRegion (Quest quest) {
		questList.add(quest);
	}

	public ArrayList<Player> getPlayerList() {
		return playerList;
	}

	public void setPlayerList(ArrayList<Player> playerList) {
		this.playerList = playerList;
	}

	public ArrayList<Quest> getQuestList() {
		return questList;
	}

	public void setQuestList(ArrayList<Quest> questList) {
		this.questList = questList;
	}
	
	public String getName() {
		return name;
	}
	
}
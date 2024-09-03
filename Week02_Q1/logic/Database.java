package logic;

import java.util.ArrayList;

public class Database {
	private ArrayList<Player> playerList;
	private ArrayList<Region> regionList;
	
	public Database() {
		this.playerList = new ArrayList<Player>();
		this.regionList = new ArrayList<Region>();
	}
	
	public Database(ArrayList<Player> playerList, ArrayList<Region> regionList) {
		this.playerList = playerList;
		this.regionList = regionList;
	}
	
	public Player addPlayer(String name, Region region) throws Exception {
		for (Player player:playerList) {
			if (player.getName().equals(name)) {
				throw new Exception();
			}
		}
			Player newPlayer = new Player(name);
			playerList.add(newPlayer);
			region.addPlayerToRegion(newPlayer);
			return newPlayer;
		}
	
	
	public boolean addRegion(String name) {
		for (Region region:regionList) {
			if (region.getName().equals(name)) {
				return false;
			}
		}
			Region newRegion = new Region(name);
			regionList.add(newRegion);
			return true;
		}
	
	public Region getRegionByName(String name) {
		for (Region region:regionList) {
			if (region.getName().equals(name)) {
				return region;
			}
		}
		return null;
	}
	
	public void addQuest(Player author, Region region, String name, String description) {
		Quest newQuest = new Quest(author,region,name,description);
		region.addQuestToRegion(newQuest);
	}
	
	public ArrayList<Player> getPlayerList() {
		return playerList;
	}

	public void setPlayerList(ArrayList<Player> playerList) {
		this.playerList = playerList;
	}

	public ArrayList<Region> getRegionList() {
		return regionList;
	}

	public void setRegionList(ArrayList<Region> regionList) {
		this.regionList = regionList;
	}
}
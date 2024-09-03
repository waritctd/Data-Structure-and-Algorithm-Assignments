package logic;

import java.util.ArrayList;

public class Server {
	private String name;
	private User owner;
	
	private ArrayList<Channel> channelList;
	private ArrayList<User> memberList;
	
	public Server(String name, User owner, TemplateType template) {
		this.owner = owner;
		this.channelList = new ArrayList<Channel>();
		this.memberList = new ArrayList<User>();
		
		
		addUser(owner);
		setName(name);
		
		
		switch(template) {
		case BASIC: 
			addChannel(owner, "general");
			break;
		case GAMING: 
			addChannel(owner, "gaming");
			break;
		case STUDY: 
			addChannel(owner, "homework-help");
			break;
		}
		
	}
	
	public Channel addChannel(User user, String channelName) {
		if (user.equals(owner)) {
			Channel newChannel = new Channel(channelName);
			newChannel.setName(channelName);
			channelList.add(newChannel);
			return newChannel;
		} else {
			return null;
		}
	}
	
	public User addUser(User user) {
		if (memberList.contains(user)) {
			return null;
		} else {
			memberList.add(user);
			user.addJoinedServersList(this);
			return user;
		}
	}
	
	public boolean kickUser(User kicker, User kicked) throws Exception {
		
		if (!kicker.equals(owner)) {
			throw new Exception();
			
		} else if (kicker.equals(owner) && 
				(!memberList.contains(kicked) || kicked.equals(owner))) {
			
			return false;
		} else {
			kicked.removeJoinedServersList(this);
			memberList.remove(kicked);
			return true;
		}	
	}
	
	public void setName(String name) {
		if (name.isBlank() || name == "") {
			this.name = owner.getName() + " home";
		} else {
			this.name = name;
		}
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public ArrayList<Channel> getChannelList() {
		return channelList;
	}

	public void setChannelList(ArrayList<Channel> channelList) {
		this.channelList = channelList;
	}

	public ArrayList<User> getMemberList() {
		return memberList;
	}

	public void setMemberList(ArrayList<User> memberList) {
		this.memberList = memberList;
	}

	public String getName() {
		return name;
	}

	public boolean isMemberInServer(User currentUser) {
		
		if (memberList.contains(currentUser)) {
			return true;
		}
		return false;
	}
	
	
}

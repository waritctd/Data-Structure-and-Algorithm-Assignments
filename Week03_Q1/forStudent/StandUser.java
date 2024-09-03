package forStudent;




import logic.main;

public class StandUser extends Character {
	

	private int maxHp;
	private int currentHp;
	
	private boolean isGuard = false;
	private Stand stand = null;

	public StandUser(String name, int hp, String quote, int strength, int defense) {
		super(name, quote, strength, defense);
		
		setCurrentHp(hp);
		setMaxHp(hp);
	}
	
		
	public int takeDamage(int damage) {
		int TotalDefense;
		int actualDamage; 
		
		if(stand == null) {
			 TotalDefense = this.getDefense();
		}
		else {
			 TotalDefense = this.getDefense() + (stand.IsActive()?stand.getDefense():0);
		}
		
		if (isGuard) {
			actualDamage = (damage - (TotalDefense*2));
		} else {
			actualDamage = (damage - (TotalDefense));
		}
		
		
		int finalDamage = (actualDamage < 0) ? 0 : actualDamage;
		int finalHp = this.currentHp - finalDamage;
		
		this.currentHp = (finalHp < 0) ? 0 : finalHp;
		
		return (finalDamage);
	}

	public int doDamage(StandUser target) {
		return target.takeDamage(this.getStrength() + (stand.IsActive()?stand.getStrength():0));
		
	}
	
	public int setMaxHp(int maxHp) {
		return this.maxHp = (maxHp < 1) ? 1 : maxHp;
	}
	
	public int getMaxHp() {
		return maxHp;
	}

	public int getCurrentHp() {
		return currentHp;
	}

	public void setCurrentHp(int hp) {
		if(hp < 0) {
			this.currentHp = 1;
		}
		else
			this.currentHp = hp;
	}
	
	public boolean isGuard() {
		return isGuard;
	}
	public void setGuard(boolean isGuard) {
		this.isGuard = isGuard;
	}
	
	public void setStand(Stand stand) {
		this.stand = stand;
	}
	

	public void printShowStat() {
		System.out.println("***************************");
		System.out.println(this.getName());
		System.out.println("\"" + this.getQuote()+ "\"" );
		System.out.println("HP = " + this.getMaxHp() );
		System.out.println("Strength = " + this.getStrength() );
		System.out.println("Defense  = " + this.getDefense() );
		System.out.println("***************************");
	}
	
	public StandUser selectStandUser() {
		printShowStat();
		main.kb.nextLine();
		System.out.println("Are you sure ? (Y/N) :");
		String special = main.kb.nextLine().trim().toLowerCase();
		boolean isSelected = special.equals("y") ? true : false ;
		if(isSelected)
			return this;
		else
			return null;
	}
	

	

}
	
	
	


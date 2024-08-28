package culverT01.cardgameplayer;

public class Card {
	//Attributes
	protected String name; 
	private String cardType;
	private String skill;
	
	//Constructor
	public Card(String name, String cardType, String skill) {
		this.name = name;
		this.setCardType(cardType);
		this.setSkill(skill);
		
	}

	//Getters and Setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

}

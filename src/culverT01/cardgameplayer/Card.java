package culverT01.cardgameplayer;

public class Card {
	//Attributes
	protected String name; 
	private String cardType;
	
	//Constructor
	public Card(String name, String cardType) {
		this.name = name;
		this.setCardType(cardType);
		
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

}

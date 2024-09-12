package culverT01.cardgameplayer;

public abstract class SupportCard extends Card {
	//Attributes
	String effectDesc;

	public SupportCard(String name, String cardType, String skill, String effectDesc) {
		super(name, cardType, skill);
		this.setEffectDesc(effectDesc);
	}
	//Behaviour
	public abstract boolean effect(Player player);
	
	//Getters and Setters
	public String getEffectDesc() {
		return effectDesc;
	}

	public void setEffectDesc(String effectDesc) {
		this.effectDesc = effectDesc;
	}

}

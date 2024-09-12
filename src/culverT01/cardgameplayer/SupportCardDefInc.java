package culverT01.cardgameplayer;

public class SupportCardDefInc extends SupportCard {
	//Attribute
	private int strength;

	//Constructor
	public SupportCardDefInc(String name, String cardType, String skill, String effectDesc, int strength) {
		super(name, cardType, skill, effectDesc);
		this.setStrength(strength);
	}

	//Behaviour
	@Override
	public boolean effect(Player player) {
		//Increase the player's defence points by the value stored in the strength attribute
		player.setDefencePoints(player.getDefencePoints() + strength);
		//Return the value true
		return true;

	}

	//Getter and Setter
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}

}

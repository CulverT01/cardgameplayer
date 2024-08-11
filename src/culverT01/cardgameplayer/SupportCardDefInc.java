package culverT01.cardgameplayer;

public class SupportCardDefInc extends SupportCard {
	//Attribute
	private int strength;

	//Constructor
	public SupportCardDefInc(String name, String cardType, String effectDesc, int strength) {
		super(name, cardType, effectDesc);
		this.setStrength(strength);
	}

	//Behaviour
	@Override
	public void effect(Player player) {
		//Increase the player's defence points by the value stored in the strength attribute
		player.setDefencePoints(player.getDefencePoints() + strength);

	}

	//Getter and Setter
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}

}

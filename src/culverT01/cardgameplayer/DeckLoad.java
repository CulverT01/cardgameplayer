package culverT01.cardgameplayer;

import java.util.ArrayList;

public class DeckLoad {

	public DeckLoad() {
		// TODO Auto-generated constructor stub
	}
	 public static ArrayList<Card> loadDeck1 () {
		 ArrayList<Card> deck1 = new ArrayList<Card>();
		 //Melee Creatures
		 CreatureCard rookieSoldier1 = new CreatureCard("Rookie Soldier", "Melee Creature", 700, 300, null);
		 CreatureCard rookieSoldier2 = new CreatureCard("Rookie Soldier", "Melee Creature", 700, 300, null);
		 CreatureCard rookieSoldier3 = new CreatureCard("Rookie Soldier", "Melee Creature", 700, 300, null);
		 CreatureCard simpleSlime1 = new CreatureCard("Simple Slime", "Melee Creature", 500, 500, null);
		 CreatureCard simpleSlime2 = new CreatureCard("Simple Slime", "Melee Creature", 500, 500, null);
		 CreatureCard simpleSlime3 = new CreatureCard("Simple Slime", "Melee Creature", 500, 500, null);
		 CreatureCard huntingHound1 = new CreatureCard("Hunting Hound", "Melee Creature", 600, 400, null);
		 CreatureCard huntingHound2 = new CreatureCard("Hunting Hound", "Melee Creature", 600, 400, null);
		 CreatureCard huntingHound3 = new CreatureCard("Hunting Hound", "Melee Creature", 600, 400, null);
		 CreatureCard stoneGolem1 = new CreatureCard("Stone Golem", "Melee Creature", 900, 100, null);
		 CreatureCard stoneGolem2 = new CreatureCard("Stone Golem", "Melee Creature", 900, 100, null);
		 CreatureCard stoneGolem3 = new CreatureCard("Stone Golem", "Melee Creature", 900, 100, null);
		 CreatureCard aceHunter1 = new CreatureCard("Ace Hunter", "Melee Creature", 1400, 600, "Ace");
		 CreatureCard aceHunter2 = new CreatureCard("Ace Hunter", "Melee Creature", 1400, 600, "Ace");
		 CreatureCard legendaryHero = new CreatureCard("Legendary Hero", "Melee Creature", 2100, 1900, "Legend");
		 //Item Support Cards
		 SupportCardAtkIncMel ironSword1 = new SupportCardAtkIncMel("Iron Sword", "Item Support", null,
				 "Increase the Attack of one Melee Creature on your Frontline by 300", 300);
		 SupportCardAtkIncMel ironSword2 = new SupportCardAtkIncMel("Iron Sword", "Item Support", null,
				 "Increase the Attack of one Melee Creature on your Frontline by 300", 300);
		 SupportCardAtkIncMel ironSword3 = new SupportCardAtkIncMel("Iron Sword", "Item Support", null,
				 "Increase the Attack of one Melee Creature on your Frontline by 300", 300);
		 SupportCardAtkIncMel woodenSpear1 = new SupportCardAtkIncMel("Wooden Spear", "Item Support", null,
				 "Increase the Attack of one Melee Creature on your Frontline by 250", 250);
		 SupportCardAtkIncMel woodenSpear2 = new SupportCardAtkIncMel("Wooden Spear", "Item Support", null,
				 "Increase the Attack of one Melee Creature on your Frontline by 250", 250);
		 SupportCardAtkIncMel woodenSpear3 = new SupportCardAtkIncMel("Wooden Spear", "Item Support", null,
				 "Increase the Attack of one Melee Creature on your Frontline by 250", 250);
		 SupportCardHthIncMel woodenShield1 = new SupportCardHthIncMel("Wooden Shield", "Item Support", null,
				 "Increase the Health of one Melee Creature on your Frontline by 300", 300);
		 SupportCardHthIncMel woodenShield2 = new SupportCardHthIncMel("Wooden Shield", "Item Support", null,
				 "Increase the Health of one Melee Creature on your Frontline by 300", 300);
		 SupportCardHthIncMel woodenShield3 = new SupportCardHthIncMel("Wooden Shield", "Item Support", null,
				 "Increase the Health of one Melee Creature on your Frontline by 300", 300);
		 SupportCardDefInc woodenStakes1 = new SupportCardDefInc("Wooden Stakes", "Item Support", null,
				 "Increase your Defence Points by 500", 500);
		 SupportCardDefInc woodenStakes2 = new SupportCardDefInc("Wooden Stakes", "Item Support", null,
				 "Increase your Defence Points by 500", 500);
		 SupportCardDefInc woodenStakes3 = new SupportCardDefInc("Wooden Stakes", "Item Support", null,
				 "Increase your Defence Points by 500", 500);
		 SupportCardRecMe reincarnation = new SupportCardRecMe("Reincarnation", "Item Support", "Ace",
				 "Return a Melee Creature from the Wasteland to the bottom of the Deck");
		 SupportCardAtkIncMel steelSword = new SupportCardAtkIncMel("Steel Sword", "Item Support", "Ace",
				 "Increase the Attack of one Melee Creature on your Frontline by 600", 600);
		 SupportCardResMe passionatePrayer = new SupportCardResMe("Passionate Prayer", "Item Support", "Legend",
				 "Play 1 Melee Creature from your Wasteland to your Frontline");
		 //Populate deck1 with cards
		 deck1.add(rookieSoldier1); deck1.add(rookieSoldier2); deck1.add(rookieSoldier3); deck1.add(simpleSlime1);
		 deck1.add(simpleSlime2); deck1.add(simpleSlime3); deck1.add(huntingHound1); deck1.add(huntingHound2);
		 deck1.add(huntingHound3); deck1.add(stoneGolem1); deck1.add(stoneGolem2); deck1.add(stoneGolem3);
		 deck1.add(aceHunter1); deck1.add(aceHunter2); deck1.add(legendaryHero); deck1.add(passionatePrayer);
		 deck1.add(steelSword); deck1.add(reincarnation); deck1.add(woodenStakes3); deck1.add(woodenStakes2);
		 deck1.add(woodenStakes1); deck1.add(woodenShield3); deck1.add(woodenShield2); deck1.add(woodenShield1);
		 deck1.add(woodenSpear3); deck1.add(woodenSpear2); deck1.add(woodenSpear1); deck1.add(ironSword3);
		 deck1.add(ironSword2); deck1.add(ironSword1);
		return deck1;
		 
	 }
	 public static ArrayList<Card> loadDeck2 () {
		 ArrayList<Card> deck2 = new ArrayList<Card>();
		//Magic Creatures
		 CreatureCard willOWisp1 = new CreatureCard("Will o Wisp", "Magic Creature", 200, 800, null);
		 CreatureCard willOWisp2 = new CreatureCard("Will o Wisp", "Magic Creature", 200, 800, null);
		 CreatureCard willOWisp3 = new CreatureCard("Will o Wisp", "Magic Creature", 200, 800, null);
		 CreatureCard elfMagician1 = new CreatureCard("Elf Magician", "Magic Creature", 400, 600, null);
		 CreatureCard elfMagician2 = new CreatureCard("Elf Magician", "Magic Creature", 400, 600, null);
		 CreatureCard elfMagician3 = new CreatureCard("Elf Magician", "Magic Creature", 400, 600, null);
		 CreatureCard willowNymph1 = new CreatureCard("Willow Nymph", "Magic Creature", 500, 500, null);
		 CreatureCard willowNymph2 = new CreatureCard("Willow Nymph", "Magic Creature", 500, 500, null);
		 CreatureCard willowNymph3 = new CreatureCard("Willow Nymph", "Magic Creature", 500, 500, null);
		 CreatureCard lightningSprite1 = new CreatureCard("Lightning Sprite", "Magic Creature", 100, 900, null);
		 CreatureCard lightningSprite2 = new CreatureCard("Lightning Sprite", "Magic Creature", 100, 900, null);
		 CreatureCard lightningSprite3 = new CreatureCard("Lightning Sprite", "Magic Creature", 100, 900, null);
		 CreatureCard elfWizard1 = new CreatureCard("Elf Wizard", "Magic Creature", 800, 1200, "Ace");
		 CreatureCard elfWizard2 = new CreatureCard("Elf Wizard", "Magic Creature", 800, 1200, "Ace");
		 CreatureCard wiseElf = new CreatureCard("Wise Elf", "Magic Creature", 1200, 2800, "Legend");
		 //Magic Support Cards
		 SupportCardAtkIncMag strSpellOne1 = new SupportCardAtkIncMag("Strength Spell Lv 1", "Magic Support", null,
				 "Increase the Attack of one Magic Creature on your Frontline by 300", 300);
		 SupportCardAtkIncMag strSpellOne2 = new SupportCardAtkIncMag("Strength Spell Lv 1", "Magic Support", null,
				 "Increase the Attack of one Magic Creature on your Frontline by 300", 300);
		 SupportCardAtkIncMag strSpellOne3 = new SupportCardAtkIncMag("Strength Spell Lv 1", "Magic Support", null,
				 "Increase the Attack of one Magic Creature on your Frontline by 300", 300);
		 SupportCardHthIncMag hthSpellOne1 = new SupportCardHthIncMag("Health Spell Lv 1", "Magic Support", null,
				 "Increase the Health of one Magic Creature on your Frontline by 300", 300);
		 SupportCardHthIncMag hthSpellOne2 = new SupportCardHthIncMag("Health Spell Lv 1", "Magic Support", null,
				 "Increase the Health of one Magic Creature on your Frontline by 300", 300);
		 SupportCardHthIncMag hthSpellOne3 = new SupportCardHthIncMag("Health Spell Lv 1", "Magic Support", null,
				 "Increase the Health of one Magic Creature on your Frontline by 300", 300);
		 SupportCardHthIncMag blessedWater1 = new SupportCardHthIncMag("Blessed Water", "Magic Support", null,
				 "Increase the Health of one Magic Creature on your Frontline by 250", 250);
		 SupportCardHthIncMag blessedWater2 = new SupportCardHthIncMag("Blessed Water", "Magic Support", null,
				 "Increase the Health of one Magic Creature on your Frontline by 250", 250);
		 SupportCardHthIncMag blessedWater3 = new SupportCardHthIncMag("Blessed Water", "Magic Support", null,
				 "Increase the Health of one Magic Creature on your Frontline by 250", 250);
		 SupportCardDefInc barSpellOne1 = new SupportCardDefInc("Barrier Spell Lv 1", "Magic Support", null,
				 "Increase your Defence Points by 500", 500);
		 SupportCardDefInc barSpellOne2 = new SupportCardDefInc("Barrier Spell Lv 1", "Magic Support", null,
				 "Increase your Defence Points by 500", 500);
		 SupportCardDefInc barSpellOne3 = new SupportCardDefInc("Barrier Spell Lv 1", "Magic Support", null,
				 "Increase your Defence Points by 500", 500);
		 SupportCardSerMs memSpellOne = new SupportCardSerMs("Memory Spell Lv 1", "Magic Support", "Ace",
				 "Search 1 Magic Support Card from your Deck and add it to your Hand");
		 SupportCardHthIncMag hthSpellTwo = new SupportCardHthIncMag("Health Spell Lv 2", "Magic Support", "Ace",
				 "Increase the Health of one Magic Creature on your Frontline by 600", 600);
		 SupportCardSerMa graduation = new SupportCardSerMa("Graduation", "Magic Support", "Legend",
				 "Search 1 Magic Creature from your Deck and add it to your Hand");
		 //Populate deck2 with cards
		 deck2.add(hthSpellTwo); deck2.add(memSpellOne); deck2.add(barSpellOne3); deck2.add(barSpellOne2);
		 deck2.add(barSpellOne1); deck2.add(blessedWater3); deck2.add(blessedWater2); deck2.add(blessedWater1);
		 deck2.add(hthSpellOne3); deck2.add(hthSpellOne2); deck2.add(hthSpellOne1); deck2.add(strSpellOne3);
		 deck2.add(strSpellOne2); deck2.add(strSpellOne1); deck2.add(wiseElf); deck2.add(elfWizard2);
		 deck2.add(elfWizard1); deck2.add(elfMagician3); deck2.add(elfMagician2); deck2.add(elfMagician1);
		 deck2.add(graduation); deck2.add(willowNymph3); deck2.add(willowNymph2); deck2.add(willowNymph1);
		 deck2.add(willOWisp3); deck2.add(willOWisp2); deck2.add(willOWisp1); deck2.add(lightningSprite3);
		 deck2.add(lightningSprite2); deck2.add(lightningSprite1);
		return deck2;
	 }

}



import java.util.Random;
import java.util.Scanner;

public class TextAdventureGame{
	private static Scanner scanner=new Scanner(System.in);
	private static Random random=new Random();
	private static int playerHealth=100;
	private static int playerGold=0;
	private static boolean hasKey=false;
	private static boolean hasMap=false;

	public static void main(String[] args) {
		System.out.println("Welcome to the Text Adventure Game!");

		while(true) {
			System.out.println("\nWhat do you want to do?");
			System.out.println("1.Explore");
			System.out.println("2.Check Inventory");
			System.out.println("3.Quit");

			int choice=scanner.nextInt();
			scanner.nextLine();

			switch(choice) {
			case 1:
				explore();
				break;
			case 2:
				checkInventory();
				break;
			case 3:
				System.out.println("Exiting game.Goodbye!");
				return;
				default:
					System.out.println("Invalid choice.Please choose again.");
			}
		}
	}

	private static void explore() {
		int event=random.nextInt(10);

		switch(event) {
		case 0:
			System.out.println("You found a treasure chest!");
			playerGold+=50;
			break;
		case 1:
			System.out.println("You encountered a friendly traveler.");
			System.out.println("The traveler gives you a health potion as a gift!");
			playerHealth+=20;
			break;
		case 2:
			System.out.println("You stumbeled upon an abandoned house.");
			System.out.println("Upon searching,you found a mysterious key!");
			hasKey=true;
			break;
		case 3:
			System.out.println("You were ambushed by bandits!");
			int banditStrength=random.nextInt(40)+20;
			System.out.println("The bandit's strength:"+banditStrength);
			System.out.println("Your health:"+playerHealth);

			if(banditStrength>playerHealth) {
				System.out.println("The bandits overwhelmed you.Game over!");
				System.exit(0);
			}
			else {
				System.out.println("You fought off the bandits and found a stash of gold!");
				playerGold+=30;
			}
			break;
		case 4:
			System.out.println("You discovered a hidden cave.");
			System.out.println("Do you want to enter the cave?");
			System.out.println("1.Enter the cave");
			System.out.println("2.Ignore the cave");

			int caveChoice=scanner.nextInt();
			scanner.nextLine();

			if(caveChoice==1) {
				exploreCave();
			}
			else {
				System.out.println("You decide to ignore the cave and continue your journey.");
			}
			break;
		case 5:
			System.out.println("You found an old map!");
			System.out.println("The map seems to lead to a hidden treasure.");
			hasMap=true;
			break;
		case 6:
			System.out.println("You stumbled upon a mystical shrine.");
			System.out.println("You feel a strange energy emanating from it.");
			System.out.println("Do you want to pray at the shrine?");
			System.out.println("1.Pray");
			System.out.println("2.Leave");

			int shrineChoice=scanner.nextInt();
			scanner.nextLine();

			if(shrineChoice==1) {
				prayAtShrine();
			}
			else {
				System.out.println("You decide to leave the shrine and continue your journey.");
			}
			break;
		case 7:
			System.out.println("You encountered a pack of wild animals!");
			System.out.println("Do you want to fight or flee?");
			System.out.println("1.Fight");
			System.out.println("2.Flee");

			int animalChoice=scanner.nextInt();
			scanner.nextLine();

			if(animalChoice==1) {
				int animalStrength=random.nextInt(30)+10;
				System.out.println("The animal's strength:"+animalStrength);
				System.out.println("Your health:"+playerHealth);

				if(animalStrength>playerHealth) {
					System.out.println("The animals overwhelmed you.Game over!");
					System.exit(0);
				}
				else {
					System.out.println("You managed to fend off the animals!");
					playerGold+=20;
				}
			}
			else {
				System.out.println("You fled from the pack of wild animals.");
			}
			break;
		case 8:
			System.out.println("You discovered a hidden passage!");
			System.out.println("Do you want to explore it?");
			System.out.println("1.Explore");
			System.out.println("2.Ignore");

			int passageChoice=scanner.nextInt();
			scanner.nextLine();

			if(passageChoice==1) {
				System.out.println("You venture into the passage and find a hidden chamber!");
				System.out.println("Inside,you find valuable treasures!");
				playerGold+=100;
			}
			else {
				System.out.println("You decide to ignore the hidden passage and continue your journey.");
			}
			break;
		case 9:
			System.out.println("You encountered a traveling merchant.");
			System.out.println("The merchant offers various goods for sale.");
			System.out.println("1.Health Potion(20 gold)");
			System.out.println("2.Sword(50 gold)");
			System.out.println("3.Leave");

			int merchantChoice=scanner.nextInt();
			scanner.nextLine();

			switch(merchantChoice) {
			case 1:
				if(playerGold>=20) {
					playerGold-=20;
					playerHealth+=20;
					System.out.println("You bought a health potion and restored 20 health!");
				}
				else {
					System.out.println("You don't have enough gold to buy a health potion.");
				}
				break;
			case 2:
				if(playerGold>=50) {
					playerGold-=50;
					System.out.println("You bought a sword.Your strength has increased!");
				}
				else {
					System.out.println("You don't have enough gold to buy a sword.");
				}
				break;
			case 3:
				System.out.println("You decide to leave the merchant.");
				break;
				default:
					System.out.println("Invalid choice.");
			}
			break;
		}
	}

	private static void exploreCave() {
		System.out.println("As you enter the cave,you find it's dark and eerie.");
		if(hasKey) {
			System.out.println("You use the mysterious key to unlock a hidden chest!");
			System.out.println("Inside the chest,you find a legendary weapon!");
		}
		else {
			System.out.println("You don't have the key to unlock anything here.");
		}
	}

	private static void prayAtShrine() {
		int blessing=random.nextInt(3);

		switch(blessing) {
		case 0:
			System.out.println("You feel a surge of strength coursing through your veins!");
			playerHealth+=30;
			break;
		case 1:
			System.out.println("You feel a soothing warmth enveloping you,healing your wounds.");
			playerHealth=100;
			break;
		case 2:
			System.out.println("You sense a increase in your luck,as if fortune favors you.");
			playerGold+=50;
			break;
		}
	}

	private static void checkInventory() {
		System.out.println("Inventory:");
		System.out.println("Gold:"+playerGold);
		System.out.println("health:"+playerHealth);
		System.out.println("Key:"+(hasKey?"Yes":"No"));
		System.out.println("Map:"+(hasMap?"Yes":"No"));
	}
}
import java.util.*;

class Card {
    String symbol;
    String value;

    Card(String symbol, String value) {
        this.symbol = symbol;
        this.value = value;
    }

    @Override
    public String toString() {
        return symbol + " " + value;
    }
}

public class CardCollection {
    public static void main(String[] args) {
        Map<String, List<Card>> cardMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Card\n2. Find Cards by Symbol\n3. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Symbol: ");
                    String symbol = scanner.nextLine();
                    System.out.print("Enter Value: ");
                    String value = scanner.nextLine();
                    cardMap.computeIfAbsent(symbol, k -> new ArrayList<>()).add(new Card(symbol, value));
                    break;

                case 2:
                    System.out.print("Enter Symbol to find: ");
                    String findSymbol = scanner.nextLine();
                    List<Card> cards = cardMap.get(findSymbol);
                    if (cards != null) {
                        for (Card card : cards) {
                            System.out.println(card);
                        }
                    } else {
                        System.out.println("No cards found with symbol " + findSymbol);
                    }
                    break;

                case 3:
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}

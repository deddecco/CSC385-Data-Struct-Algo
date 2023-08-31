package card.util;

public abstract class Deck {
    public Card[] deck = new Card[52];
    int count;

    public Deck() {
        initialize();
    }

    /**
     * adds a Card to the Deck if doing so doesn't exceed the capacity of the deck
     */
    public void add(Card newCard) {
        if (count < deck.length) {
            deck[count] = newCard;
            count += 1;
        } else {
            throw new DeckCapacityReachedException("Capacity reached.");
        }
    }


    /**
     * draws a Card from the high-index end of the Deck
     */
    public Card draw() {
        // handle empty deck case
        if (count == 0) {
            throw new EmptyDeckException("Cannot draw from empty deck");
        }

        // subtract 1 from count
        count--;
        // get card at location count in deck
        Card drawnCard = deck[count];
        //set at location count to null in deck
        deck[count] = null;

        return drawnCard;
    }


    /**
     * returns the number of Cards in the Deck
     */
    public int getCount() {
        return count;
    }


    /**
     * returns true if the count is 0 and false otherwise
     */
    public boolean isEmpty() {
        return getCount() == 0;
    }


    //fisher-yates-shuffles the deck
    public void shuffle() {
        for (int i = count - 1; i >= 0; i--) {
            int swapIdx = (int) (Math.random() * (i + 1));
            swap(i, swapIdx);
        }
    }

    // swaps two Cards at given positions by means of a temporary Card
    private void swap(int index1, int index2) {
        Card temp = deck[index1];
        deck[index1] = deck[index2];
        deck[index2] = temp;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < count; i++) {
            sb.append(deck[i]);
            if (i < count - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }


    // every abstract class has at least one abstract method, and every abstract method must be implemented
    // by the children that inherit from the abstract class.
    protected abstract void initialize();

}
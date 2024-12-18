import java.util.ArrayList;

public class Deck{
    private ArrayList<Card> deck;
    private ArrayList<Card> playerhand;
    private ArrayList<Card> dealerhand;
    public int playerscore;
    public int dealerscore;

     public void startdeck() {
        deck = new ArrayList<Card>();
        playerhand = new ArrayList<Card>();
        dealerhand = new ArrayList<Card>();
        makedeck();
     }
      

    private void makedeck() {
        for (int suit = 1; suit <= 4; suit++) { 
            for (int rank = 2; rank <= 14; rank++) { 
                deck.add(new Card(rank, suit));
            }
        }
    }

     public void dealcards(){
        playerhand.add(deck.remove((int)(Math.random() * deck.size())));
        dealerhand.add(deck.remove((int)(Math.random() * deck.size())));
        playerhand.add(deck.remove((int)(Math.random() * deck.size())));
        dealerhand.add(deck.remove((int)(Math.random() * deck.size())));
    }

    public int calcplayerscore(ArrayList<Card>hand){
        int playerscore = 0;
        for( Card card : playerhand){
            int rank = card.getRank();
            if (rank == 14)
            playerscore += 11;
            else if (rank > 10) 
            playerscore += 10;
             else 
            playerscore += rank;
        }
        return playerscore;
    }


    public int calcdealerscore(ArrayList<Card>hand){
        int dealerscore = 0; 
        for( Card card: dealerhand){
            int rank = card.getRank();
            if (rank == 14)
            dealerscore += 11;
            else if (rank > 10) 
            dealerscore += 10;
             else 
             dealerscore += rank;
        }
        return dealerscore;
        
    }



    public void dealagain(){
        playerhand.add(deck.remove((int)(Math.random() * deck.size())));
        playerscore = calcplayerscore(playerhand);        
        }

        public void shouldhit(){
            if (calcplayerscore(playerhand) > calcdealerscore(dealerhand)){
                dealerhand.add(deck.remove((int)(Math.random() * deck.size())));
                dealerscore = calcdealerscore(dealerhand);
            }
        }

         public String winorlose(){
        playerscore = calcplayerscore(playerhand);
        dealerscore = calcdealerscore(dealerhand);
                if (playerscore > 21) {
            return "Sorry, but you lost. You busted!";
        } else if (dealerscore > 21) {
            return "Good job! You won. The dealer busted!";
        } else if (playerscore > dealerscore) {
            return "Good job! You won!";
        } else if (dealerscore > playerscore) {
            return "Sorry, but you lost. The dealer has a better hand.";
        } else {
            return "It's a tie. No one wins.";
        }
    }

    public boolean isbust(){
        return (playerscore > 21);
    }




        public ArrayList<Card> getPlayerHand() {
        return playerhand;
    }

    public ArrayList<Card> getDealerHand() {
        return dealerhand;
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

}
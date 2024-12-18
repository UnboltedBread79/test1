public class Blackjackmain{
    
    public static void main(String[] args) {
        Deck d = new Deck();
       d.startdeck();
       d.dealcards();
       Blackjack b = new Blackjack(d);
        System.out.println("Deck:");
        b.game();

        
    }
 


}

import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;



public class Blackjack extends JPanel{
    public Deck deck;
    public Blackjack(Deck d){
        this.deck = d;
    }
    
    

    public void game(){
       JFrame x = new JFrame("Hit or Stand");
        x.setSize(500,600);
        setLayout(new BorderLayout());
        x.add(this);
        JButton button = new JButton("Hit");
        JButton button1 = new JButton("Stand");
        JPanel south = new JPanel();
        this.add(south,BorderLayout.SOUTH);
        south.add(button, BorderLayout.SOUTH);
        south.add(button1, BorderLayout.SOUTH);
        x.setVisible(true);
        JOptionPane.showMessageDialog(x,"Welcome to BlackJack, when ur ready press OK!");
        JOptionPane.showMessageDialog(x,"Your hand is worth" + " " + deck.calcplayerscore(deck.getPlayerHand()));
       button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                deck.dealagain();
                 int playerScore = deck.calcplayerscore(deck.getPlayerHand());
                JOptionPane.showMessageDialog(x, "Your hand is now worth " + playerScore);
                if(deck.isbust()){
                JOptionPane.showMessageDialog(x, "Sorry but your score is over 21, you lose");
                    
                }
            }
        });

         button1.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent b){
               deck.shouldhit();
                 int dealerScore = deck.calcdealerscore(deck.getDealerHand());
                JOptionPane.showMessageDialog(x, " The dealer's hand is worth" + " " + dealerScore + " " + deck.winorlose());
             }
          });
    
    }
}
    

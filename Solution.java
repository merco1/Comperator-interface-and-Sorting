
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Comperator implements Comparator<Player> {

    public int compare (Player player1,Player player2) {

        if (player2.getScore()> player1.getScore()) {
            return (1);
        }

        else if (player2.getScore()<player1.getScore()) {
            return (-1);
        }
        else {
           Checker checker=new Checker();
            return checker.compare(player1,player2);
        }
    }


}
class Checker implements Comparator<Player> {
    public int compare (Player player1,Player player2) {
        int scoreResult = Integer.compare(player2.getScore(), player1.getScore());
        if (scoreResult !=0)return scoreResult;
        return player1.getName().compareTo(player2.getName());
    }

}

class Player {
    private String Name ;
    private int Score;

    public Player (String name, int score) {
       this.Name=name;
       this.Score=score;

    }

    public String getName() {
        return Name;
    }

    public int getScore() {
        return Score;
    }
}


public class Solution {
    public static void main(String[] args) {
   Scanner scan = new Scanner(System.in);

   int n = scan.nextInt();
      Player [] player= new Player[n];
      Comperator checker = new Comperator();

      for (int a = 0 ; a<n;a++){
          player[a] =new Player(scan.next(), scan.nextInt());
      }
        Arrays.sort(player,checker);

      for (int i = 0 ; i< player.length; i++) {
          System.out.println(player[i].getName()+player[i].getScore());

      }

    }



}
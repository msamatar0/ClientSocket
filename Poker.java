import java.util.*;

/**
 *
 * @author msamatar0
 */
public class Poker{
    static int[][] testDeck =   {
        {3, 2, 4,  5,  6},  {1, 2, 5, 13, 23 }, {19, 20, 15, 23, 14 },                        
        {52, 51, 50, 1, 23 }, {5, 15, 17, 29, 44 }, {52, 15, 17, 30, 26 },
        {3, 2, 41,  5,  28}, {1, 2, 5, 13, 14 }, {19, 20, 15, 23, 14 },                        
        {52, 51, 50, 36, 22 }, {1, 15, 17, 29, 44 }, {40, 52, 51, 49, 50},
        {2, 15, 28, 41, 3 }, {2, 3, 4,  5,  1 },  {14, 15, 8, 30, 5 },
        {23, 34, 45, 52, 2 }, {7, 8, 9, 10, 50 }, {2, 5, 23, 50, 19 },
        {15, 29, 7, 19, 44 }, {23, 36, 10, 1, 49 }, {46, 49, 48, 45, 47 },
        {28, 2, 15, 1, 41 },  {14, 17, 18, 16, 15}, {4, 52, 37, 51, 14 }, 
        { 2, 28, 19, 41, 6 }, { 47, 23, 35, 7, 50, }, {50, 40, 52, 51, 48 },
        { 49, 39, 10, 44, 43,  }, { 12, 34, 18, 50, 38,  }, { 25, 14, 15, 23, 48,  },
        { 21, 24, 52, 37, 9,  }, { 5, 4, 20, 8, 2,  }, { 36, 1, 42, 35, 26,  },
        { 31, 32, 6, 45, 19,  }, { 16, 43, 10, 21, 11,  }, { 47, 7, 3, 19, 20,  },
        { 8, 13, 5, 34, 35,  }, { 39, 30, 42, 24, 37,  }, { 52, 41, 28, 1, 48,  },
        { 12, 4, 22, 31, 25,  }, { 15, 26, 33, 27, 51,  }, { 29, 40, 50, 52, 18,  },
        { 7, 1, 23, 48, 27,  }, { 44, 3, 4, 37, 51,  }, { 2, 38, 47, 17, 11,  },
        { 25, 9, 10, 31, 49,  }, { 26, 15, 21, 36, 42,  }, { 24, 16, 34, 43, 33,  },
        { 37, 51, 41, 33, 18,  }, { 44, 4, 7, 46, 1,  }, { 17, 34, 43, 30, 35,  },
        { 15, 8, 28, 40, 11,  }, { 1, 43, 27, 49, 17 },   {26, 31, 5, 36, 13},
        { 8, 7, 8, 23, 39 },     {2, 3, 15, 14, 13 },        {23, 45, 51, 1, 52 },
        {22, 45, 2, 49, 13 },     {23, 35, 47, 36, 10 },       {15, 16, 45, 35, 52},
    };
    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Card hand[] = new Card[5];
        int cardNum[] = new int[5],
            idNum[] = new int[5],
            suitNum[] = new int[5];
        ArrayList<String> handNames = new ArrayList<>();
        while(in.hasNextInt()){
            for(int i = 0; i < 5; i++){
                hand[i] = new Card(in.nextInt());
                cardNum[i] = hand[i].getCard();
                idNum[i] = hand[i].getID();
                suitNum[i] = hand[i].getSuit();
            }
            Arrays.sort(hand);
            Arrays.sort(cardNum);
            Arrays.sort(idNum);
            Arrays.sort(suitNum);
            if(incrementing(idNum) && uniform(suitNum))
                handNames.add(Arrays.equals(cardNum, new int[]{10, 11, 12, 13, 1})? "Royal Flush" : "Straight Flush");
            
            handNames.stream().forEach((i) -> System.out.println(i));
        }
    }
    
    public static boolean uniform(int[] arr){
        for(int i = 0; i < arr.length; ++i){
            int n = arr[i];
            if(i < arr.length && n == arr[i + 1]);
            else if(i < arr.length && n != arr[i + 1])
                return false;
            else
                break;
        }
        return true;
    }
    
    public static boolean incrementing(int[] arr){
        for(int i = 0; i < arr.length; ++i){
            int n = arr[i];
            if(i < arr.length && n == arr[i + 1] + 1);
            else if(i < arr.length && n != arr[i + 1] + 1)
                return false;
            else
                break;
        }
        return true;
    }
}

class Card implements Comparable<Card>{
    int id = 0, card = 0, suit = 0;
    
    public Card(int n){
        id = n;
        card = id % 13;
        suit = id / 13;
    }
    
    public int getID(){
        return id;
    }
    
    public int getCard(){
        return id;
    }
    
    public int getSuit(){
        return id;
    }
    
    @Override
    public int compareTo(Card o){
        return id - o.id;
    }
    
    @Override
    public String toString(){
        String cardStr, suitStr;
        switch(card){
            case 1:
                cardStr = "Ace";
                break;
            case 11:
                cardStr = "Jack";
                break;
            case 12:
                cardStr = "Queen";
                break;
            case 13:
                cardStr = "King";
                break;
            default:
                cardStr = card + "";
        }
        switch(suit){
            case 0:
                suitStr = "of Spades";
                break;
            case 1:
                suitStr = "of Hearts";
                break;
            case 2:
                suitStr = "of Diamonds";
                break;
            case 3:
                suitStr = "of Clubs";
                break;
            default:
                suitStr = "";
        }
        return cardStr + " " + suitStr;
    }

    
}


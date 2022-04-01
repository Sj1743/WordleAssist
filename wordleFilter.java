package wordleassist;
import java.util.*;

public class wordleFilter{

    static Scanner sc = new Scanner(System.in);
    static String[] list = new String[2309]; 
    public static void main(String[] args){

        assign();
        instructions();
        boolean exit = false;

        while(!exit){
            System.out.print("Enter letter: ");
            char ch = sc.next().charAt(0);
            if(Character.isDigit(ch)){
                exit = true;
            }else{
                System.out.print("Enter position: ");
                int pos = sc.nextInt();
                filter(ch, pos);
                print();
            }
        }
    }

    public static void filter(char ch, int pos){
        if(pos > 0 && pos < 6){
            for(int i = 0; i < list.length; i++){
                if(!(list[i].equals("")) && list[i].charAt(pos-1) != ch)
                    list[i] = "";
            }
        }else if(pos == 0){
            for(int i = 0; i < list.length; i++){
                if(!(list[i].equals("")) && list[i].indexOf(ch) == -1)
                    list[i] = "";
            }
        }else if(pos == -1){
            for(int i = 0; i < list.length; i++){
                if(!(list[i].equals("")) && list[i].indexOf(ch) != -1)
                    list[i] = "";
            }
        }
    }

    public static void instructions(){
        System.out.println("Type in the alphabet that is included or not included in the word when prompted for letter."); 
        System.out.println("If the letter is in the word, enter the position of said letter in the word if known (1, 2, 3, 4, or 5), when prompted for position."); 
        System.out.println("If the letter is in the word but position remains unknown, return 0 when prompted for position."); 
        System.out.println("If the letter is NOT in the word, input -1 when prompted for position."); 
        System.out.println("To exit, enter any number when prompted for letter."); 
    }

    public static void print(){
        for(int i = 0; i < list.length; i++){
            if(!(list[i].equals("")))
                System.out.println(list[i]);
        }
    }

    public static void assign(){
        list = wordList.words;
    }
}
import java.util.*;
import java.io.*;

public class wordleFilter {
    static Scanner sc = new Scanner(System.in);
    static String[] list = new String[2309]; 
    static String[] shortList = new String[2309];
    public static void main(String[] args) throws Exception{
        
        File file = new File("C:\\GitHub\\WordleAssist\\wordList.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        /*
        Scanner scanner = new Scanner(list);
        scanner.useDelimiter("\\z");
        */

        for(int i = 0; i < list.length; i++){
            shortList[i] = list[i];
        }

        for(int i = 0; i < list.length; i++){
            String st = br.readLine();
            list[i] = st;
        }

        boolean exit = false;

        while(exit == false){
            int opt = menu();
            switch(opt){
                case 1: included();
                    break;
                case 2: System.out.println("You chose to sort through letter not included.");
                    break;
                case 3: System.out.println("You chose to exit.");
                    exit = true;
                    break;
                default: System.err.println("Invalid input.");
                    continue;
            }
        }
    }

    public static int menu(){
        System.out.print("\n");
        System.out.println("Enter 1 for letter included.");
        System.out.println("Enter 2 for letter not included.");
        System.out.println("Enter 3 to exit.");
        System.out.print("\nInput: ");
        int i = sc.nextInt();
        System.out.print("\n");
        return i;
    }

    public static void included(){
        System.out.print("Enter letter included: ");
        String ch = sc.next();
        for(int i = 0; i < list.length; i++){
            if(shortList[i] != null){
                if(shortList[i].contains(ch)){
                    System.out.print(shortList[i] + "\n");
                }else{
                    shortList[i] = null;
                }
            }
        }
    }
}
import java.util.Scanner;
/**
 * Write a description of class problemset4b here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class problemset4b
{
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        System.out.print("input:");
        String palindromeinput = scan.nextLine();
        palindromeinput = palindromeinput.toLowerCase();
        System.out.println(palindromeCheck(palindromeinput));

        System.out.print("input a sentence:");
        String sentence = scan.nextLine();
        System.out.println(pigtranslator(sentence));
        
        System.out.print("enter in the min:");
        int min = scan.nextInt();
        System.out.print("enter in the max:");
        int max = scan.nextInt();
        
        System.out.print("number of acending numbers"+acendingnumbers(min,max));

    }

    public static String palindromeCheck(String str){
        String nonLetters = ",.:;()[]{}!?@#$%^&* “";

        String first = "";
        String second = "";

        for(int z = 0; z<=str.length()-1; z++){
            String letter = str.substring(z,z+1);
            if (nonLetters.contains(letter)){
                str = str.replace(letter,"");  

            }
        }
        int half = str.length()/2;

        for(int i = 0; i<= half-1; i++){
            String letter = str.substring(i,i+1);
            first+= letter;
        }
        for(int j = str.length()-1; j>= half+1; j--){
            String letter = str.substring(j,j+1);
            second+= letter;
        }
        System.out.println(first);
        System.out.println(second);
        if(first.equals(second)) return "it is a palindrome";
        else return "not a palindrome";
    }

    public static String pigtranslator(String str){
        
        String newstring = "";
        while(str.length() > 0){
            int space = str.indexOf(" ");
            if(space>0){ 
                    String wordsplit = str.substring(0,space);
                    newstring += pigtranslatortest(wordsplit);
                    str = str.substring(space+1, str.length());
            } 
        else {
            newstring = pigtranslatortest(str);
            str = "";
        }
 }
 return newstring;
}     
    public static String pigtranslatortest(String str){
        String back = "ay";
        String newstring = "";
        char firstletter = str.charAt(0);
        str = str.substring(1,str.length());
        newstring += str+firstletter+back;
        return newstring;
    }
        
 
    public static int acendingnumbers(int min, int max){
        int count = 0;
        for(int i = min; i <= max; i++){   
            int rightnumber = i%10;
            i /= 10;    
            while(i<0){
            int nextnumber = i%10;
            i /= 10;
            while(rightnumber > nextnumber) count++;
            
          }
        }
        return count;
    }
}


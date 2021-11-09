import java.util.Scanner;

public class CreateValidatePassword {

    static String password = "";
    static int minLength = 3;   //Minimum password Length
    static int minNum = 1;      //Minimum password Numbers
    static int minSymb = 1;     //Minimum password Symbols

    //Prompting user to log in
    public static boolean logIn(){
        if(password != ""){
            System.out.println("Please enter your password:");
            for(int i = 3; i > 0; i--){
                Scanner uIn = new Scanner(System.in);
                if(uIn.nextLine().equals(password)){
                    return true;
                }else{
                    if((i - 1) != 0){
                        System.out.println("Incorrect password! " + (i - 1) + " attempt/s left!");
                    }
                }
            }
            System.out.println("Too many incorrect attempts! Exiting program...");
            System.exit(0);
        }else{
            firstTimeSetup();
        }
        return true;
    }

    //User password creation method
    public static void firstTimeSetup(){
        //Var initialization
        Scanner uIn = new Scanner(System.in);   //initializing system.in Scanner to read input

        char[] symbols = {'!','£','$','%','&','*','_','+'};
        char[] nums = {'1','2','3','4','5','6','7','8','9'};
        int[] passwordItems = {0,0,0};   //0 - characters | 1 - numbers | 2 - symbols
        boolean loop = true;


        System.out.println("Welcome to Motel app! Looks like it's the\nfirst time you're using this software.\n\n" +
                "Would you like to create a password? (Y/N)");

        if(uIn.nextLine().equalsIgnoreCase("y")){
            System.out.println("Please create a password: ");

            while(loop == true){

                for(int a = 0; a < passwordItems.length; a++){
                    passwordItems[a] = 0;
                }//resetting item count

                String userPass = uIn.nextLine(); //taking user input

                for(int i = 0; i < userPass.length(); i ++){

                    passwordItems[0] ++; //incrementing character count

                    for(int a = 0; a < nums.length; a++){
                        if(userPass.charAt(i) == nums[a]){
                            passwordItems[1] ++; //incrementing number count
                        }
                    }//checking for numbers

                    for(int b = 0; b < symbols.length; b++){
                        if(userPass.charAt(i) == symbols[b]){
                            passwordItems[2] ++; //incrementing symbol count
                        }
                    }//checking for symbols

                }//main loop going through all string characters

                if(passwordItems[0] >= minLength && passwordItems[1] >= minNum && passwordItems[2] >= minSymb){
                    password = userPass;
                    System.out.println("Password set!");
                    loop = false;
                    logIn();
                }else{
                    System.out.println("Password invalid! Please make sure you have at least 1 character, number and symbol.\n\n" +
                            passwordItems[0] + " characters. | " + passwordItems[1] + " numbers. | " + passwordItems[2] + " symbols.");
                }
            }

        }else{
            System.exit(0);
        }; //reading user input and checking if equal to Y or N
    }

}

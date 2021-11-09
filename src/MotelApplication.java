/*MotelApplication.java
    Name: Luca Cassar
    Class: Year 10 Monologue
    School: Malta visual and performing arts school
 */
import java.util.Locale;
import java.util.Scanner;

public class MotelApplication {

    //Variable innitialization

    static int listSize = 5;                                //max customer list size(arraySize = listSize)
    static String[] customerName = new String[listSize];    //stores customer name(String = name)
    static String[] customerSurname = new String[listSize]; //stores customer surname(String = surname)
    static int[] customerAge = new int[listSize];           //stores customer Age(1 int = 1 day//)
    static int[] customerStay = new int[listSize];          //stores customer stay(1 int = 1 day)

    static String[] customerMeal = new String[listSize];    //stores what type of meal customer ordered ("standard"/"deluxe")
    static String[] ccustomerRoom = new String[listSize];    //stores what type of room customer booked

    static CreateValidatePassword cvp = new CreateValidatePassword();

    public static void main(String[] args){
        if(cvp.logIn()){
            menu();
        }
    }

    public static void displayCustomerBill(){
        Scanner uIn = new Scanner(System.in);

        System.out.println("---------------------------------\n" +
                "Please enter the code number of customer to display bill:");
        int customer = uIn.nextInt() - 1;

        int totalFoodPrice;
        final int totalRoomPrice;

        //If customer meal and room haven't been declared, set to 0 (Prevent null pointer exception)
        if(customerMeal[customer] != null){
            totalFoodPrice = totalPrice.totFood(customerMeal[customer], customerStay[customer]);
        }else{
            totalFoodPrice = 0;
        }
        if(ccustomerRoom[customer] != null){
             totalRoomPrice = totalPrice.totRoom(ccustomerRoom[customer], customerStay[customer]);
        }else{
            totalRoomPrice = 0;
        }

        System.out.println("Name -> " + customerName[customer] + " | Surname -> " + customerSurname[customer] +
                " | Customer age -> " + customerAge[customer] + " | Number " +
                "of days -> " + customerStay[customer]
        +"\nThe food cost for the stay is: " + totalFoodPrice +
                "\nThe room cost for the stay is: " + totalRoomPrice +
                "\nThe total bill for the customer is " + (totalFoodPrice + totalRoomPrice) + "\n");
        menu();
    }

    //set customer room method
    public static void customerRoom(){
        Scanner uIn = new Scanner(System.in);

        System.out.println("---------------------------------\n" +
                "Please enter the code number of customer to select a room type:");
        int customer = uIn.nextInt() - 1;
        System.out.println("<<<< ROOMS MENU >>>>\n" +
                "<A> SUITE\n" +
                "<P> PREMIUM ROOM\n" +
                "<S> STANDARD ROOM\n" +
                "-----------------------\n" +
                "Select an option:");

        Scanner uIn1 = new Scanner(System.in);  //Not exactly sure on why I had to create another scanner obj,
                                                //usually it works when I reuse the same one, anyways just so you know.

        char userOption = uIn1.nextLine().charAt(0);
        Rooms customerRoom = new Rooms();
        switch(userOption){
            case 'a':
                customerRoom.roomType = "suite";
                ccustomerRoom[customer] = customerRoom.roomType;
                System.out.println("<<<< " + customerRoom.roomType.toUpperCase(Locale.ROOT) + " >>>>\n" +
                        "Room area = " + customerRoom.area() +
                        "\nRoom cost = " + customerRoom.roomCost(customerStay[customer]) +
                        "\n---------------------------------\n" +
                        customerName[customer] + " " + customerSurname[customer] + "'s total bill of room is " + customerRoom.roomCost(customerStay[customer])+"\n");
                break;
            case 'p':
                customerRoom.roomType = "premium";
                ccustomerRoom[customer] = customerRoom.roomType;
                System.out.println("<<<< " + customerRoom.roomType.toUpperCase(Locale.ROOT) + " >>>>\n" +
                        "Room area = " + customerRoom.area() +
                        "\nRoom cost = " + customerRoom.roomCost(customerStay[customer]) +
                        "\n---------------------------------\n" +
                        customerName[customer] + " " + customerSurname[customer] + "'s total bill of room is " + customerRoom.roomCost(customerStay[customer])+"\n");
                break;
            case 's':
                customerRoom.roomType = "standard";
                ccustomerRoom[customer] = customerRoom.roomType;
                System.out.println("<<<< " + customerRoom.roomType.toUpperCase(Locale.ROOT) + " >>>>\n" +
                        "Room area = " + customerRoom.area() +
                        "\nRoom cost = " + customerRoom.roomCost(customerStay[customer]) +
                        "\n---------------------------------\n" +
                        customerName[customer] + " " + customerSurname[customer] + "'s total bill of room is " + customerRoom.roomCost(customerStay[customer])+"\n");
                break;
        }
        menu();
    }

    //set customer food order method
    public static void customerFoodOrder(){
        int customer;
        System.out.println("---------------------------------\n" +
                "Please enter the code number of customer to select food:");
        Scanner uIn = new Scanner(System.in);
        customer = uIn.nextInt() - 1;

        //Outputting customer information for confirmation
        System.out.println("Name -> " + customerName[customer] + " | Surname -> " + customerSurname[customer] +
                " | Customer age -> " + customerAge[customer] + " | Number " +
                "of days -> " + customerStay[customer] +
                "\nWhat type of meal do you wish <d>DELUXE or <s>STANDARD:");

        Scanner uIn1 = new Scanner(System.in);  //Not exactly sure on why I had to create another scanner obj,
                                                //usually it works when I reuse the same one, anyways just so you know.

        String userIn = uIn1.nextLine();
        switch(userIn.charAt(0)){
            case 's':
                customerMeal[customer] = "standard";
                System.out.println("<<< YOU HAVE CHOSEN STANDARD >>>\n" + customerName[customer] + " " + customerSurname[customer] + "'s total bill of meal is " + (customerStay[customer] * 10));
                break; //choosing standard meal

                case 'd':
                    customerMeal[customer] = "deluxe";
                    System.out.println("<<< YOU HAVE CHOSEN DELUXE >>>\n" + customerName[customer] + " " + customerSurname[customer] + "'s total bill of meal is " + (customerStay[customer] * 20));
                    break; //choosing deluxe meal
            default:
                System.out.println("Invalid input!");
                break;
        }
        menu();
    }

    //input customer details method
    public static void customerDetails(){
        int emptySlot = 0;
        for(int i = 0; i < listSize; i++){
            if(customerName[i] == null){
                emptySlot = i;
                break;
            }else if(customerName[listSize - 1] != null){
                System.out.println("List full!");
                menu();
            }
        }
        Scanner uIn = new Scanner(System.in);
        System.out.println("Please input the name of the customer:");
        customerName[emptySlot] = uIn.nextLine();

        System.out.println("Please input the surname of the customer:");
        customerSurname[emptySlot] = uIn.nextLine();

        System.out.println("Please input the age of the customer:");
        customerAge[emptySlot] = uIn.nextInt();

        System.out.println("Please input the stay of the customer:");
        customerStay[emptySlot] = uIn.nextInt();

        System.out.println("CODE    NAME    SURNAME    AGE    DAYS");
        for(int i = 0; i < listSize; i++){
            System.out.println((i+1) + "    " +  customerName[i] + "    " + customerSurname[i] + "    " + customerAge[i] + "    " + customerStay[i]);
        }
        menu();
    }

    //main menu method, can get referenced from other methods to Initiate menu.
    public static void menu(){
        //Menu design
        System.out.println("**************************************\n" +
                           "   <<<<<Welcome to MOTEL SHINE>>>>>\n" +
                           "**************************************");
        System.out.println("(press 1) - Input customer details\n" +
                "(Press 2) - Select the type of food customer wishes\n" +
                "(Press 3) - Select the type of room customer wishes\n" +
                "(Press 4) - Output the Customer bill\n" +
                "(press 5) - Log out of the program\n" +
                "(Press e) - to exit the program");
        System.out.println("***************************************\n" +
                "Select an option from the above menu:");

        Scanner uIn = new Scanner(System.in);
        char userOption = uIn.nextLine().charAt(0); //Converting String to char

        switch(userOption){
            case'1':
                customerDetails();
                break;
            case'2':
                customerFoodOrder();
            case'3':
                customerRoom();
                break;
            case'4':
                displayCustomerBill();
            case'5':
                System.out.println("Logging out...");
                main(new String[1]);
            case'e':
                System.out.println("Exiting program...");
                System.exit(0);
                break;
        }
    }




}

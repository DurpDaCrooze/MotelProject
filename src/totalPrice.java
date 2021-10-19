public class totalPrice {

    public static int totRoom(String roomType, int customerStay){
        switch(roomType){
            case "standard":
                return 20 * customerStay;

            case "premium":
                return 30 * customerStay;

            case "suite":
                return 40 * customerStay;
        }
        return 0;
    }

    public static int totFood(String foodType, int customerStay){
        switch(foodType){
            case "deluxe":
                return 20 * customerStay;

            case "standard":
                return 10 * customerStay;

        }
        return 0;
    }

}

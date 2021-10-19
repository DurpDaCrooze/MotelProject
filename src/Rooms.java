public class Rooms {

    public String roomType = null; //room type for obj will be set here

    //when called for type of room, this will return the area of the set object room type.
    public double area(){
        switch(roomType){
            case "standard":
                return 25;

            case "premium":
                return 35;

            case "suite":
                return 45;

            default:
                return 0;
        }
    }

    //this string return method will return room type
    public String roomType(){
        return  roomType;
    }

    //this method will return the total room cost. Takes one argument(int) that will be multiplied by the room price for total room cost (room cost * customer stay)
    public int roomCost(int customerStay){
        switch(roomType){
            case "standard":
                return 20 * customerStay;

            case "premium":
                return 30 * customerStay;

            case "suite":
                return 40 * customerStay;

            default:
                return 0;
        }
    }

}

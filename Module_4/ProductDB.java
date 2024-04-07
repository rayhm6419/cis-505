public class ProductDB {
    public static GenericQueue<Product> getProduct(String code){
        GenericQueue<Product> products = new GenericQueue<>();
        String[][] ballAttributes = {
                {"B100", "Black Widow 2.0", "144.95", "Black and Red"},
                {"B200", "Hy-Road Pearl", "139.95", "Blue and Purple"},
                {"B300", "Timeless", "154.95", "Gold and Black"},
                {"B400", "Pitch Black", "129.95", "Solid Black"},
                {"B500", "Astrophysix", "164.95", "Neon Green and Magenta"}
        };

        String[][] shoesAttributes = {
                {"C100", "Super Soft Max", "144.78", "6.5"},
                {"C200", "Glide Master 3000", "120.99", "10"},
                {"C300", "Strike King Pro", "115.49", "8"},
                {"C400", "Alley Ace Runner", "130.00", "11"},
                {"C500", "Pin Prowler Flex", "99.95", "9"}
        };

        String[][] bagAttributes = {
                {"D100", "Pro Bowler Carry Bag", "49.99", "Single Ball"},
                {"D200", "Champion Roller", "69.99", "Double Ball"},
                {"D300", "The Weekender Tote", "39.99", "Single Ball"},
                {"D400", "The Tourney Traveler", "59.99", "Triple Ball"}
        };


        if (code.equalsIgnoreCase("b")){

            for(String[] ball : ballAttributes){
                Ball balls = new Ball();
               balls.setCode(ball[0]);
               balls.setDescription(ball[1]);
               balls.setPrice(Double.parseDouble(ball[2]));
               balls.setColor(ball[3]);
               products.enqueue(balls);
           }
        } else if (code.equalsIgnoreCase("s")) {

            for(String[] shoes : shoesAttributes){
                Shoe shoe = new Shoe();
                shoe.setCode(shoes[0]);
                shoe.setDescription(shoes[1]);
                shoe.setPrice(Double.parseDouble(shoes[2]));
                shoe.setSize(Double.parseDouble(shoes[3]));
                products.enqueue(shoe);
            }

        }else if (code.equalsIgnoreCase("a")) {
            for (String[] bags : bagAttributes){
                Bag bag = new Bag();
                bag.setCode(bags[0]);
                bag.setDescription(bags[1]);
                bag.setPrice(Double.parseDouble(bags[2]));
                bag.setType(bags[3]);
                products.enqueue(bag);
            }
        }
        return products;
    }
}
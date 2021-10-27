import java.util.*;

public class MyShop {
    static ArrayList<Product> myProductList = new ArrayList<>();
    static ArrayList<Product> myCart = new ArrayList<>();

    public void start() {
        Product gamingComputer = new Product("Burken MaxPower", 35000, "Stationary gaming computer, that can run high end games.",2);
        Product gamingKeyboard = new Product("Burken KeySpammer TKL", 2500, "Gaming keyboard tkl(No numpad) and wireless, for the people who wanna get the most spams out of their keyboard",2);
        Product gamingMouse = new Product("Burken ClickBait", 1950, "Wireless gaming mouse, that doesnt live up to its name. Not a clickbait, high precision and sensitive clickpads for faster reactions.",3);
        Product gamingHeadset = new Product("Burken HearThroughWalls", 2200, "Whit these unbelievably good headset people may think you cheat. This headset uses the latest technology in surround sound.",4);
        Product gamingMonitor = new Product("Burken NeverGoBlind", 5900, "This monitor makes you wish you never go blind, with its stunning visuals and sharpness, and high framerate.",1);

        myProductList.add(gamingMouse);
        myProductList.add(gamingComputer);
        myProductList.add(gamingKeyboard);
        myProductList.add(gamingHeadset);
        myProductList.add(gamingMonitor);

        boolean programRunning = true;

        while (programRunning) {
            printMenu();
            int menuChoice = getUserInt();
            switch (menuChoice) {
                case 1:
                    showList();
                    break;
                case 2:
                    addToCart();
                    break;
                case 3:
                    checkPrice();
                    break;
                case 4:
                    removeFromCart();
                    break;
                case 5:
                    productDescription();
                    break;
                case 6:
                    programRunning = false;
                    System.out.println("Bye! Hope to see you again soon!");
                    break;
            }
        }
    }

    public  void printMenu() {
        System.out.println("------------------------------------------------------------------------------------------------------------");
        System.out.println("-----------------");
        System.out.println("Welcome to Eliver");
        System.out.println("-----------------\n\n");


        System.out.println("[1] List of all products");
        System.out.println("[2] Add product to cart");
        System.out.println("[3] Check price of everything in cart");
        System.out.println("[4] Remove product from cart");
        System.out.println("[5] Description of selected product");
        System.out.println("[6] Exit shop");
        System.out.print("[?]>");
    }

    public  void showList() {
        System.out.println("------------------------------------------------------------------------------------------------------------");
        System.out.println("Product name                  Price");
        System.out.println("-----------------------------------");
        for (int i = 0; i < myProductList.size(); i++) {
            System.out.printf("%-30s%d\n", myProductList.get(i).getName(), myProductList.get(i).getPrice());
        }
    }

    public  void addToCart() {
        System.out.println("------------------------------------------------------------------------------------------------------------");
        System.out.println("What product would you like to add to your cart.");
        System.out.print("[Product name]> ");
        String productChoice = getUserString();

        for (int i = 0; i < myProductList.size(); i++) {
            if (Objects.equals(productChoice, myProductList.get(i).getName())) {
                myCart.add(myProductList.get(i));
            }
        }
    }

    public  void removeFromCart() {
        System.out.println("------------------------------------------------------------------------------------------------------------");
        System.out.println("Which product would you like to remove from cart?");
        System.out.print("[Product name]> ");

        String userChoice = getUserString();
        for (int i = 0; i < myCart.size(); i++) {
            if (userChoice.equals(myCart.get(i).getName())) {
                myCart.remove(i);
            }
        }
    }

    public  void checkPrice() {
        System.out.println("------------------------------------------------------------------------------------------------------------");
        int myPrice = 0;
        for (int i = 0; i < myCart.size(); i++) {
            myPrice += myCart.get(i).getPrice();
        }
        System.out.println("The price of everything in your cart is: " + myPrice + " kr");

    }

    public  void productDescription() {
        System.out.println("------------------------------------------------------------------------------------------------------------");
        System.out.println("Which product description would you like to read?");
        System.out.print("[Product name]> ");
        String userChoice = getUserString();
        String askForContent ="";

        for (int i = 0; i < myProductList.size(); i++) {
            if (userChoice.equals(myProductList.get(i).getName())) {
                askForContent = myProductList.get(i).getDescription();
                break;
            } else {
               Random myRnd = new Random();
               int myNumber = myRnd.nextInt(myProductList.size());

               myProductList.get(myNumber).getName();

                askForContent = "This product [" + userChoice + "] doesnt exist, did you mean [" + myProductList.get(myNumber).getName() + "]?";
            }
        }
        System.out.println("------------------------------------------------------------------------------------------------------------");
        System.out.println(askForContent);
    }

    public static int getUserInt() {
        Scanner myScanner = new Scanner(System.in);
        int myInt;
        while (true) {
            try {
                myInt = Integer.parseInt(myScanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Felaktigt menyval");
            }
        }
        return myInt;
    }

    public static String getUserString() {
        Scanner myScanner = new Scanner(System.in);

        return myScanner.nextLine();
    }


}

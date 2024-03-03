import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.InputMismatchException;





public class Theatre {   // declaring the class
    public static String[] row_1 = new String[12]; // initialising the 3 arrays
    public static String[] row_2 = new String[16];
    public static String[] row_3 = new String[20];

    static ArrayList<Ticket> tickets = new ArrayList<Ticket>(); // ArrayList which will hold ticket details



    //Method to buy a ticket
    public static void buy_ticket() {
        Scanner seat = new Scanner(System.in);

        System.out.print("Enter row number: ");
        int row_num = seat.nextInt();

        System.out.print("Enter seat number in the row: ");
        int seat_num = seat.nextInt();

        if (row_num == 1) {
            if (row_1[seat_num - 1].equals("O")) {
                row_1[seat_num - 1] = "X";
            } else {
                System.out.println("This seat is already booked");
            }
        } else if (row_num == 2) {
            if (row_2[seat_num - 1].equals("O")) {
                row_2[seat_num - 1] = "X";
            } else {
                System.out.println("This seat is already booked");
            }
        } else if (row_num == 3) {
            if (row_3[seat_num - 1].equals("O")) {
                row_3[seat_num - 1] = "X";
            } else {
                System.out.println(" This seat is already booked");
            }
        } else {
            System.out.println("Error: This row number does not exist. Please select 1-3");
        }


    }





    //Method for the user to cancel ticket
    public static void cancel_ticket(){
        Scanner cancel = new Scanner(System.in);

        System.out.print("Enter row number: ");
        int row_num = cancel.nextInt();

        System.out.print("Enter seat number in the row: ");
        int seat_num = cancel.nextInt();

        if (row_num == 1){
            if (row_1[seat_num-1].equals("X")){
                row_2[seat_num-1] = "O";
            } else {
                System.out.println("This seat is not booked..");
            }

        } else if (row_num == 2) {
            if (row_2[seat_num-1].equals("X")){
                row_2[seat_num-1] = "O";
            } else {
                System.out.println("This seat is not booked..");
            }

        } else if (row_num == 3) {
            if (row_3[seat_num-1].equals("X")){
                row_3[seat_num-1] = "O";
            } else {
                System.out.println("This seat is not booked..");
            }

        } else {
            System.out.println("Error: This row number does not exist. Please select 1-3");
        }


    }



    //Method to show the available seats

    public static void show_available(){
        System.out.print(" Available seats in the 1st row: ");
        for (int j=0; j< row_1.length; j++){
            if (row_1[j].equals("O")){
                System.out.print(j+1 + ", ");
            }
        }

        System.out.println();
        System.out.print(" Available seats in the 2nd row: ");
        for (int j=0; j< row_2.length; j++){
            if (row_2[j].equals("O")){
                System.out.print(j+1 + ", ");
            }
        }

        System.out.println();
        System.out.print(" Available seats in the 3rd row: ");
        for (int j=0; j< row_3.length; j++){
            if (row_3[j].equals("O")){
                System.out.print(j+1 + ", ");
            }
        }
        System.out.println();

    }


    public static void print_seating_area() {
                                              //This is where the stage is printed
        System.out.println("    ***********");
        System.out.println("    *  STAGE  *");
        System.out.println("    ***********");

        // Print the seat structure
        System.out.print("   ");
        for (String seat : row_1) {
            System.out.print(seat);
        }
        System.out.println();
        System.out.print("  ");
        for (String seat : row_2) {
            System.out.print(seat);
        }
        System.out.println();
        for (String seat : row_3) {
            System.out.print(seat);
        }
    }


    //Method to validate user's choice
    public static boolean check(int choice){
        return choice > 0 && choice < 9;
    }

    //Method to save to a file

    public static void save_to_file(){
        try {
            FileWriter file = new FileWriter("ticketDetails.txt");

            for (String value : row_1) {
                file.write(value);
            }
            file.write(System.lineSeparator());

            for (String value : row_2) {
                file.write(value);
            }
            file.write(System.lineSeparator());

            for (String value: row_3) {
                file.write(value);
            }

            file.close();
            System.out.println("Array has been successfully written to file!");

        } catch (IOException e) {
            System.out.println("An error occurred while writing the array to the file!");
            e.printStackTrace();
        }


    }

    // Method to load from a file
    public static void load_from_file(){
        try {
            File file = new File("ticketDetails.txt");
            Scanner file_reader = new Scanner(file);
            int line_num = 0;

            while (file_reader.hasNextLine()) {
                String row_line = file_reader.nextLine();
                if (line_num==0){
                    for (int i=0; i< row_1.length; i++){
                        row_1[i] = Character.toString(row_line.charAt(i));
                    }
                } else if (line_num==1) {
                    for (int i=0; i< row_2.length; i++){
                        row_2[i] = Character.toString(row_line.charAt(i));
                    }
                } else if (line_num ==2) {
                    for (int i=0; i< row_3.length; i++){
                        row_3[i] = Character.toString(row_line.charAt(i));
                    }
                } else {
                    System.out.println("Nothing was read");
                }
                line_num++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    public static void main (String [] args) {  //main method to display welcome message & menu
            System.out.println("Welcome to the New Theatre!");
            Scanner input = new Scanner(System.in);

            //Initialising arrays with O
            Arrays.fill(row_1, "O");
            Arrays.fill(row_2, "O");
            Arrays.fill(row_3, "O");



            // Menu Display
            System.out.println("__________________________");
            System.out.println("Please select an option: ");
            System.out.println("1) Buy a ticket");
            System.out.println("2) Print seating area");
            System.out.println("3) Cancel ticket");
            System.out.println("4) List available seats");
            System.out.println("5) Save");
            System.out.println("6) Load");
            System.out.println("7) Print ticket information and total price");
            System.out.println("8) Sort tickets by price");
            System.out.println("0) Quit");
            System.out.println("_______________________");



            // Carrying out & validating the user's choice

            boolean Quit = false;
            while  (!Quit) {
                System.out.println(" ");
                System.out.println("Enter option: ");
                int choice = 0;
                try {
                    choice = input.nextInt();
                    check(choice);
                } catch (InputMismatchException e) {
                    System.out.println();
                }




                switch (choice) { //switch
                    case 1:
                        //Buy a ticket
                        while (true) {
                            buy_ticket();
                            System.out.print(" Would you like to purchase another ticket? (Say yes or no): ");
                            String response = input.next();
                            if (response.equals("yes")) {
                                System.out.println("proceed..");
                            } else if (response.equals("no")) {
                                break;
                            } else {
                                System.out.println("Invalid response");
                            }
                        }
                        break;

                    case 2:
                        //Printing the seating arrangement
                        print_seating_area();
                        break;

                    case 3:
                        // Cancel ticket
                        cancel_ticket();
                        break;

                    case 4:
                        // Listing available seats
                        show_available();
                        break;

                    case 5:
                        // Save to file
                        save_to_file();
                        break;

                    case 6:
                        // Load from file
                        load_from_file();
                        break;

                    case 7:
                        // Print ticket information and total price
                        break;

                    case 8:
                        // Sort tickets by price
                        break;

                    case 0:
                        Quit = true;// Code will exit when user opts for this option
                        break;

                    default:
                        System.out.println(" Invalid response.. Please Try again");

                }
            }
        }
    }


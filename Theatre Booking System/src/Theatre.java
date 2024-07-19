import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.ArrayList;

public class Theatre {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to The New Theatre");
        int[] row1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] row2 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] row3 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        ArrayList<Ticket> ticketList = new ArrayList<>();
        int option;
        do{
            // Print the main menu
            System.out.println("-------------------------------------------------");
            System.out.println("Please select an option : ");
            System.out.println("1) Buy a ticket ");
            System.out.println("2) Print seating area");
            System.out.println("3) Cancel ticket");
            System.out.println("4) List available seats");
            System.out.println("5) Save to file");
            System.out.println("6) Load from file");
            System.out.println("7) Print ticket information and total price");
            System.out.println("8) Sort tickets by price");
            System.out.println("    0) Quit");
            System.out.println("-------------------------------------------------");
            // Prompt the user to input a menu option
            System.out.print("Enter option : ");
            option = scanner.nextInt();

            switch (option) {
                case 0:
                    break;
                case 1:
                    buy_ticket(row1, row2, row3,ticketList);
                    break;
                case 2:
                    print_seat_area(row1, row2, row3);
                    break;
                case 3:
                    cancel_ticket(row1, row2, row3,ticketList);
                    break;
                case 4:
                    show_available(row1, row2, row3);
                    break;
                case 5:
                    //saves the 3 arrays with the row’s information in a file
                    save(row1,row2,row3);
                    break;
                case 6:
                    load (row1,row2,row3);
                    break;
                case 7:
                    show_tickets_info(ticketList);
                    break;
                case 8:
                    sort_tickets(ticketList);
                    break;
                default:
                    System.out.println("Invalid option. Try again.");

            }
        }while (option!=0);
    }

    private static void buy_ticket(int[] row_num1, int[] row_num2, int[] row_num3,ArrayList<Ticket> ticketList) {
        try {
            Scanner sc = new Scanner(System.in);
            Scanner price_1 = new Scanner(System.in);
            System.out.print("Enter your name: ");
            String name = sc.nextLine();
            System.out.print("Enter your surname: ");
            String surname = sc.nextLine();
            System.out.print("Enter your email: ");
            String email = sc.nextLine();
            System.out.print("Enter your row number : ");
            int row_input = sc.nextInt();
            System.out.print("Enter your seat number : ");
            int seat_input = sc.nextInt();
            System.out.print("Enter the ticket price : ");
            double price = price_1.nextDouble();
            Person user = new Person(name,surname,email);
            Ticket ticket = new Ticket(row_input,seat_input,price,user);
            seat_input--;

            if (row_input < 1 || row_input > 3) {
                System.out.println("Invalid row number.");
            }
            else if (seat_input < 0 || seat_input > 19) {
                System.out.println("Invalid seat number.");
            }
            else if (row_input == 1 && row_num1[seat_input] == 1) {
                System.out.println("This seat is already reserved.");
            }
            else if (row_input == 2 && row_num2[seat_input] == 1) {
                System.out.println("This seat is already reserved.");
            }
            else if (row_input == 3 && row_num3[seat_input] == 1) {
                System.out.println("This seat is already reserved.");
            }
            else {
                if (row_input == 1) {
                    row_num1[seat_input] = 1;
                    ticketList.add(ticket);
                    ticket.get_ticket();
                } else if (row_input == 2) {
                    row_num2[seat_input] = 1;
                    ticketList.add(ticket);
                    ticket.get_ticket();
                } else {
                    row_num3[seat_input] = 1;
                    ticketList.add(ticket);
                    ticket.get_ticket();
                }
                System.out.println("Seat booked");
            }
        }catch (Exception e){
            System.out.println("Enter valid integer");
        }
    }

    private static void print_seat_area(int[] row_num1, int[] row_num2, int[] row_num3) {
        String[] row_1 = {"O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"};
        String[] row_2 = {"O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"};
        String[] row_3 = {"O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"};

        System.out.println("     ***********");
        System.out.println("     *  STAGE  *");
        System.out.println("     ***********");

        for (int i = 0; i < row_1.length; i++) {
            if (i == 0) {
                System.out.print("    ");
            }
            if (i == 6) {
                System.out.print(" ");
            }
            if (row_num1[i] == 1) {
                row_1[i] = "X";
            }
            System.out.print(row_1[i]);
        }
        System.out.println(" ");
        for (int i = 0; i < row_2.length; i++) {
            if (i == 0) {
                System.out.print("  ");
            }
            if (i == 8) {
                System.out.print(" ");
            }
            if (row_num2[i] == 1) {
                row_2[i] = "X";
            }
            System.out.print(row_2[i]);
        }
        System.out.println(" ");
        for (int i = 0; i < row_3.length; i++) {
            if (i == 10) {
                System.out.print(" ");
            }
            if (row_num3[i] == 1) {
                row_3[i] = "X";
            }
            System.out.print(row_3[i]);
        }
        System.out.println(" ");
    }

    private static void cancel_ticket(int[] row_num1, int[] row_num2, int[] row_num3,ArrayList<Ticket> ticketList) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter your row number : ");
            int r = sc.nextInt();
            System.out.print("Enter your seat number : ");
            int s = sc.nextInt();
            s--;

            if (r < 1 || r > 3) {
                System.out.println("Invalid row number.");
            } else if (s < 0 || s > 19) {
                System.out.println("Invalid seat number.");
            } else if (r == 1 && row_num1[s] == 0) {
                System.out.println("This seat isn't  reserved.");
            } else if (r == 2 && row_num2[s] == 0) {
                System.out.println("This seat is isn't reserved.");
            } else if (r == 3 && row_num3[s] == 0) {
                System.out.println("This seat isn't reserved.");
            } else {
                if (r == 1) {
                    row_num1[s] = 0;
                } else if (r == 2) {
                    row_num2[s] = 0;
                } else {
                    row_num3[s] = 0;
                }
                for (Ticket ticket : ticketList){
                    if (ticket.getRow() == r && ticket.getSeat() == s+1){
                        ticketList.remove(ticket);
                        break;
                    }
                }
                System.out.println("Seat cancel successfully!");
            }
        }catch (Exception e){
            System.out.println("Enter valid integer");
        }

    }

    private static void show_available(int[] row_num1, int[] row_num2, int[] row_num3) {
        System.out.print("Seats available in row 1: ");
        for (int i = 0; i < row_num1.length; i++) {

            if (row_num1[i] == 0) {
                System.out.print(i + 1 + " ");
            }
        }
        System.out.println(" ");
        System.out.print("Seats available in row 2: ");
        for (int a = 0; a < row_num2.length; a++) {

            if (row_num2[a] == 0) {
                System.out.print(a + 1 + " ");
            }
        }
        System.out.println(" ");
        System.out.print("Seats available in row 3: ");
        for (int b = 0; b < row_num3.length; b++) {

            if (row_num3[b] == 0) {
                System.out.print(b + 1 + " ");
            }
        }
        System.out.println(" ");
    }

    private static void save(int[] row_num1, int[] row_num2, int[] row_num3) {

        try{
            File file= new File("data.txt");
            boolean file_created = file.createNewFile();
            if (file_created){
                System.out.println("File successfully created");
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        try {
            FileWriter myWriter = new FileWriter("data.txt");


            for (int i = 0; i < row_num1.length; i++) {
                myWriter.write(row_num1[i] + " ");
            }
            myWriter.write("\n");

            for (int i = 0; i < row_num2.length; i++) {
                myWriter.write(row_num2[i] + " ");
            }
            myWriter.write("\n");

            for (int i = 0; i < row_num3.length; i++) {
                myWriter.write(row_num3[i] + " ");
            }
            myWriter.close();
        }
        catch (Exception e){
            System.out.println("An error occurred.");
        }
    }
    private static void load(int[] row_num1,int[] row_num2,int[] row_num3) {
        try {
            File file= new File("data.txt");
            Scanner reader= new Scanner(file);

            for (int i=0;i<row_num1.length;i++){
                int num = reader.nextInt();
                row_num1[i]=num;
            }
            for (int i=0;i<row_num2.length;i++){
                int num = reader.nextInt();
                row_num2[i]=num;
            }
            for (int i=0;i<row_num3.length;i++){
                int num = reader.nextInt();
                row_num3[i]=num;
            }
            reader.close();
        }
        catch (IOException e) {
            System.out.println("Error while reading a file.");
            e.printStackTrace();
        }
    }
    private static void show_tickets_info(ArrayList<Ticket> ticketList) {
        double total = 0.0;
        for (Ticket ticket : ticketList) {
            System.out.println("Name: " + ticket.getPerson().getName() + " " + ticket.getPerson().getSurname());
            System.out.println("Email: " + ticket.getPerson().getEmail());
            System.out.println("Row: " + ticket.getRow() + ",Seat:" + ticket.getSeat());
            System.out.println("Price: " + ticket.getPrice());
            total += ticket.getPrice();
        }
        System.out.println("Total price of all tickets: " + total);
    }
    private static void sort_tickets(ArrayList<Ticket> ticketList){
        ArrayList<Ticket> sorted_list = new ArrayList<>(ticketList);
        int n = sorted_list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (sorted_list.get(j).getPrice() > sorted_list.get(j + 1).getPrice()) {
                    Ticket temp = sorted_list.get(j);
                    sorted_list.set(j, sorted_list.get(j + 1));
                    sorted_list.set(j + 1, temp);
                }
            }
        }
        double total = 0.0;
        for (Ticket ticket : sorted_list) {
            System.out.println("Name: " + ticket.getPerson().getName() + " " + ticket.getPerson().getSurname());
            System.out.println("Email: " + ticket.getPerson().getEmail());
            System.out.println("Row: " + ticket.getRow() + ",Seat:" + ticket.getSeat());
            System.out.println("Price: " + ticket.getPrice());
            total += ticket.getPrice();
        }
        System.out.println("Total price of all tickets: " + total);
    }
}







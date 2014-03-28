//  Franklin Leung
package cosc5319.assignment2;

import java.util.Scanner;

public class Cosc5319Assignment2 {

    public static void main(String[] args) {
        widget wid;
        Scanner sc = new Scanner(System.in);
        int menuChoice, widgetChoice;
        System.out.print("How many widgets will be stored? ");
        widgetyList wl = new widgetyList(sc.nextInt());
        
        while(true) {
            displayMainMenu();
            System.out.print("Enter choice: ");
            menuChoice = sc.nextInt();
            switch(menuChoice) {
                case 1:
                    wl.printList();
                    break;
                case 2:
                    while(true) {
                        System.out.print("Enter widget ID: ");
                        int widgetID = sc.nextInt();
                        System.out.print("Enter widget description: ");
                        String tempDesc = sc.next();
                        System.out.print("Enter widget price: ");
                        wl.insertWidget(new widget(widgetID, tempDesc, sc.nextInt()));
                        System.out.print("Add another widget? \n(1. yes, 2. no)> ");
                        if (sc.nextInt() != 1) {
                            break;
                        }
                    }
                    break;
                case 3:
                    while(true) {
                        if (wl.isEmpty()) {
                            System.out.println("List is empty! Reverting to main menu.");
                            break;
                        }
                        wl.printList();
                        System.out.print("Which widget (0 to cancel)? ");
                        widgetChoice = sc.nextInt();
                        if (widgetChoice != 0) {
                            if (widgetChoice < wl.numWidgets()+1) {
                                wid = wl.accessWidget(widgetChoice-1);
                                System.out.print("Change description? (1. yes, 2. no)> ");
                                if (sc.nextInt() == 1) {
                                    System.out.print("Enter description: ");
                                    wid.setDescription(sc.next());
                                }
                                System.out.print("Change price? (1. yes, 2. no)> ");
                                if (sc.nextInt() == 1) {
                                    System.out.print("Enter price: ");
                                    wid.setPrice(sc.nextInt());
                                }
                            } else {
                                System.out.println("Invalid widget selection.");
                            }
                        } else {
                            System.out.println("Leaving edit widget menu.");
                            break;
                        }
                    }
                    break;
                case 4:
                    while(true) {
                        if (wl.isEmpty()) {
                            System.out.println("List is empty! Reverting to main menu.");
                            break;
                        }
                        wl.printList();
                        System.out.print("Which widget to delete? (0 to cancel)> ");
                        widgetChoice = sc.nextInt();
                            if (widgetChoice != 0) {
                                if (widgetChoice < wl.numWidgets()+1) {
                                    wl.retrieveWidget(widgetChoice-1);
                                } else {
                                    System.out.println("Invalid widget selection.");
                                }
                            } else {
                                System.out.println("Leaving delete widget menu.");
                                break;
                            }
                    }
                    break;
                case 5:
                    System.out.println("Terminating program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid menu selection.");
            }
        }
    }
    
    public static void displayMainMenu() {
        System.out.println("-------------------------");
        System.out.println("1. View widget list");
        System.out.println("2. Add widget");
        System.out.println("3. Edit widget");
        System.out.println("4. Delete widget");
        System.out.println("5. Exit program");
        System.out.println("-------------------------");
    }
}

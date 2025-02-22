package src;

import java.util.Scanner;

public class MUDController {

    private boolean running;
    private final Scanner scanner;


    public MUDController() {
        this.running = true;
        this.scanner = new Scanner(System.in);
    }


    public void runGameLoop() {
        System.out.println("Welcome player! Type 'help' for a list of commands.");

        while (running) {
            System.out.print("> ");
            String input = scanner.nextLine().trim().toLowerCase();
            handleInput(input);
        }
    }


    public void handleInput(String input) {
        if (input.isEmpty()) {
            return;
        }

        String[] parts = input.split(" ", 2);
        String command = parts[0];
        String argument = (parts.length > 1) ? parts[1] : "";

        switch (command) {
            case "look":
                lookAround();
                break;
            case "move":
                move(argument);
                break;
            case "pick":
                if (argument.startsWith("up ")) {
                    pickUp(argument.substring(3));
                } else {
                    System.out.println("Error. Did you mean 'pick up [item]'?");
                }
                break;
            case "inventory":
                checkInventory();
                break;
            case "help":
                showHelp();
                break;
            case "quit":
            case "exit":
                running = false;
                System.out.println("Bye Bye, Hope You'll return.");
                break;
            default:
                System.out.println("Don't know this command. Type 'help' for a list of commands.");
                break;
        }
    }

    private void lookAround() {
        System.out.println("You are in a dark, empty room.");
    }


    private void move(String direction) {
        if (direction.isEmpty()) {
            System.out.println("Please specify your direction (forward, back, left, right).");
            return;
        }
        System.out.println("You move " + direction + ", but sadly there's nothing there.");
    }


    private void pickUp(String itemName) {
        System.out.println("You pick up the " + itemName + ", or at least you try.");
    }


    private void checkInventory() {
        System.out.println("Your inventory is empty.");
    }


    private void showHelp() {
        System.out.println("Available commands:");
        System.out.println("- look: Describe the current location.");
        System.out.println("- move [forward|back|left|right]: Move in a specified direction.");
        System.out.println("- pick up [item]: Pick up an item.");
        System.out.println("- inventory: Show your inventory.");
        System.out.println("- help: Show this help message.");
        System.out.println("- quit/exit: Exit the game.");
    }


    public static void main(String[] args) {
        MUDController controller = new MUDController();
        controller.runGameLoop();
    }
}

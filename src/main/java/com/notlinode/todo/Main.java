package com.notlinode.todo;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        TaskBoard taskBoard = new TaskBoard();

        Scanner sc = new Scanner(System.in);
        boolean run = true;

        while (run) {
            System.out.print("Enter a command:\n> ");
            String command = sc.next();

            switch (command) {
                case "help":
                    System.out.println("List of all commands: " +
                            "[add|+] <todo description>, [remove|-] <todo id>, [check|x] <todo id>, show, quit.\n");
                    break;

                case "+":
                case "add":
                    String description = sc.nextLine().trim();
                    taskBoard.add(description);
                    taskBoard.render();
                    break;

                case "-":
                case "remove":
                    try {
                        int id = sc.nextInt();
                        taskBoard.remove(id);
                        taskBoard.render();
                    }
                    catch (IndexOutOfBoundsException e) {
                        System.out.println("Invalid id.\n");
                    }
                    break;

                case "x":
                case "check":
                    try {
                        int id = sc.nextInt();
                        taskBoard.check(id);
                        taskBoard.render();
                    }
                    catch (IndexOutOfBoundsException e) {
                        System.out.println("Invalid id.\n");
                    }
                    break;

                case "show":
                case "render":
                    taskBoard.render();
                    break;

                case "q":
                case "quit":
                    run = false;
                    break;

                default:
                    System.out.println("Invalid command.\nList of all commands: " +
                            "add <todo description>, remove <todo id>, check <todo id>, show, quit.\n");
            }
        }
    }

}
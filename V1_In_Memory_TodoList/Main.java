package V1_In_Memory_TodoList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;

public class Main {
   static String[] FunctionalCommands = new String[] {"add", "list", "remove", "complete", "clear"};

    public static void main(String[] args) {
        System.out.println("This is a running memory version only. Nothing persists upon exit.\n 'help' for a list of commands.");
        boolean run_flag = true; 
        ToDoList list = new ToDoList();
       
        while (run_flag) {
            System.out.println("\nEnter Command:");
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, System.getProperty("stdin.encoding")));
            String command = reader.readLine();
            String[] command_args = command.split(" ");
            switch (command_args[0]) {
                case "add":
                    addItem(command_args, reader, list);               
                    break; 
                case "list":
                    iterateList(list.getList());
                    break;
                case "remove":
                   System.out.println("Remove by Item Number: ");                  
                   removeItem(reader, list);
                   break;
                case "complete": 
                   markComplete(command_args, reader, list);
                   break;
                case "clear": 
                   clearScreen();
                   break;
                case "exit": 
                   run_flag = false;
                   break;
                case "?":
                case "help":           
                    printHelp();
                    break;
                default: 
                    System.out.println("Unknown command. use '?' or 'help' for guidance.");
                    break;
                }
             } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
        System.out.println("Goodbye User. (ó﹏ò｡)");
        
    }

    private static void clearScreen(){
        String[] commands = new String[1];
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                commands[0] = "cls";
                Runtime.getRuntime().exec(commands);
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (RuntimeException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private static void markComplete(String[] command_args, BufferedReader reader, ToDoList list) {
        int id;
        boolean state = true;

        try {
            if (command_args.length < 2) {
                System.out.println("Enter Item Number: ");
                id = Integer.valueOf(reader.readLine());
            } else if (command_args.length == 2) {
                id = Integer.valueOf(command_args[1]);
            } else if (command_args[1].contains("-r") && command_args.length == 3) {
                id = Integer.valueOf(command_args[2]);
                state = false;
            } else {
                System.out.println("Error: Too many arguments");
                return;
            }
            list.markComplete(id, state);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void removeItem(BufferedReader reader, ToDoList list) {
        try {
            String i = reader.readLine();
            int id = Integer.valueOf(i);
            list.removeItem(id);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e){
            System.out.println("Not a Number! Try again");
            removeItem(reader, list);
        }
    }

    private static void addItem(String[] command_args, BufferedReader reader, ToDoList list){
         if (command_args.length == 1){
            System.out.print("Enter Task: ");
            try {
                String task = reader.readLine();
                list.addItem(task);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            StringBuilder task = new StringBuilder();
            for (int i = 1; i < command_args.length; i++){
                task.append(command_args[i] + " "); 
            }
            list.addItem(task.toString());
        }

    }

    private static void iterateList(List<Task> list){
        for (int i = 0; i < list.size(); i++){
            var task = list.get(i);
            System.out.printf("[%s] Item %d: %s\n", task.isCompleted() ? "X" : "", i + 1, task.getDesc());
        }
    }

    private static void printHelp() {
        System.out.println("Commands:");
        for (String s : FunctionalCommands) {
            System.out.printf("%s\n", s);
        }
    }   
}



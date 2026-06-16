package V1_In_Memory_TodoList;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;

public class Main {
   static String[] FunctionalCommands = new String[] {"add", "list", "remove", "complete"};

    public static void main(String[] args) {
        System.out.println("This is a running memory version only. Nothing persists after exit. Demonstration only.");
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
                   System.out.println("Update by Item Number: ");
                   markComplete(reader, list);
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
        
    }

    private static void markComplete(BufferedReader reader, ToDoList list) {
        try {
            String i = reader.readLine();
            int id = Integer.valueOf(i);
            list.markComplete(id);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e){
            System.out.println("Not a Number! Try Again");
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



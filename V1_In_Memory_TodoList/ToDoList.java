package V1_In_Memory_TodoList;
import java.util.ArrayList;



public class ToDoList {
    ArrayList<Task> todoList;
    int id = 0;


    public ToDoList() {
        this.todoList = new ArrayList<Task>();
    }

    public void addItem(String desc) {
        Task task = new Task(id, desc);
        this.todoList.add(task);
        this.id += 1; 
    }

    public void markComplete(int id) {
        if (id - 1 < 0 || id - 1 > this.todoList.size()) {
            System.out.println("Error: Task number does not exist.");
        } else {
            id -= 1;
            Task task = this.todoList.get(id);
            task.completed = true;
        }

    }

    public ArrayList<Task> getList(){
        return this.todoList;
    }

    public void removeItem(int i) { 
        if (i == 0 || i - 1 > this.todoList.size()) {
            System.out.println("Error: Not a real item number");
        } else {
            i -= 1;
            this.todoList.remove(i);
        }
        System.out.printf("Removed Item %d", i + 1);
    }
}

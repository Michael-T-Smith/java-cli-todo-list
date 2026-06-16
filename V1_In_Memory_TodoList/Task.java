package V1_In_Memory_TodoList;

public class Task {
    int id;
    String desc; 
    boolean completed; 

    public Task(int id, String desc) {
        this.id = id; 
        this.desc = desc;
        this.completed = false;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setCompleted(boolean state) {
        this.completed = state;
    }
}

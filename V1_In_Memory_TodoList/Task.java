package V1_In_Memory_TodoList;

public class Task {
    private int id;
    private String desc; 
    private boolean completed; 

    public Task(int id, String desc) {
        this.id = id; 
        this.desc = desc;
        this.completed = false;
    }

    public String getDesc() {
        return this.desc;
    }

    public boolean isCompleted() {
       return this.completed; 
    }

    public void setCompleted(boolean state) {
        this.completed = state;
    }
}

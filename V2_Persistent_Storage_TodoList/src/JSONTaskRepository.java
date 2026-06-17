package V2_Persistent_Storage_TodoList.src;
import java.util.List;
import java.util.ArrayList;

public class JSONTaskRepository implements TaskRepository {
    
    @Override
    public void save(Task task) {
    
    }
    
    @Override
    public void delete(int id){
        
    }
    
    @Override
    public List<Task> findAll(){
      List<Task> tasks = new ArrayList<Task>();
      return tasks;
    }
}

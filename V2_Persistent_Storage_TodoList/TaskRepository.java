package V2_Persistent_Storage_TodoList;
import java.util.List;

public interface TaskRepository{
    List<Task> findAll();
    void save(Task task);
    void delete(int id);
}

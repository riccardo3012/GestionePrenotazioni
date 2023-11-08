package repository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import entities.User;
import exception.ItemNotFoundException;

@Service
public class UserService {
    @Autowired
    private UserRepository usersRepo;
    public void create(User u) {
        usersRepo.save(u);
    }

    public List<User> find() {
        return usersRepo.findAll();
    }

    public User findById(long id) {
        return (User) usersRepo.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
    }

    public void findByIdAndDelete(String id) {
        User found = this.findById(Long.parseLong(id));
        usersRepo.delete(found);
    }

    public long count() {
        return usersRepo.count();
    }
}

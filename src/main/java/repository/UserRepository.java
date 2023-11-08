package repository;
import entities.User;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Id> {

    @Query("SELECT u FROM User u ORDER BY RANDOM()")
    User getRandUser();
    Optional<Object> findById(long id);
}
package pl.polskisklep.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.polskisklep.model.User;

public interface UserRepository extends JpaRepository<User,Long> {

}

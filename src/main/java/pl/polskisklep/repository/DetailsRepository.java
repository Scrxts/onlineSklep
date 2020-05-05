package pl.polskisklep.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.polskisklep.model.UserDetails;

public interface DetailsRepository extends JpaRepository<UserDetails,Long> {
}

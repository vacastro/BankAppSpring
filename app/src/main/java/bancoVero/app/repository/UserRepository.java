package bancoVero.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import bancoVero.app.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	@Query("select u from User u where id =?1")
	Optional<User> getUserById(int id);

	@Query("select u from User u where username =?1")
	Optional <User> findByUsername (String username);

}

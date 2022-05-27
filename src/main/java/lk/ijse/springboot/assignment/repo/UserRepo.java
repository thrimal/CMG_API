package lk.ijse.springboot.assignment.repo;

import lk.ijse.springboot.assignment.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends MongoRepository<User,String> {
    Optional<User> findByUserNameAndPassword(String userName, String password);
    List<User> findAllByUserName(String userName);
}

package pl.tomaszewski.demospringbootimageuploader.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.tomaszewski.demospringbootimageuploader.model.User;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    User findByUserName(String username);
}

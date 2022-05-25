package sd_project.score_dei;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query(value="select * from client where username = :username and password = :password", nativeQuery = true)
    public Client login(String username, String password);

    @Query(value="select * from client where username = :username", nativeQuery = true)
    public Client find_by_username(String username);
}

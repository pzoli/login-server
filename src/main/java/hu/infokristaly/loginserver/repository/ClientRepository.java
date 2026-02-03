package hu.infokristaly.loginserver.repository;

import hu.infokristaly.loginserver.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    public List<Client>  findAllByOrderByNameAsc();
}

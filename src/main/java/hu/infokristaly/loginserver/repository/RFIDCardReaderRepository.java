package hu.infokristaly.loginserver.repository;

import hu.infokristaly.loginserver.entity.RFIDCardReader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RFIDCardReaderRepository extends JpaRepository<RFIDCardReader, Long> {
    RFIDCardReader findByReaderId(String readerId);
    public List<RFIDCardReader> findAllByOrderById();
}

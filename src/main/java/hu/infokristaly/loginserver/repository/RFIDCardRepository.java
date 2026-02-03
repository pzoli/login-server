package hu.infokristaly.loginserver.repository;

import hu.infokristaly.loginserver.entity.RFIDCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RFIDCardRepository extends JpaRepository<RFIDCard, Long> {
    public RFIDCard findByRfidAndType(String rfid,  String type);

    public List<RFIDCard> findAllByOrderById();
}

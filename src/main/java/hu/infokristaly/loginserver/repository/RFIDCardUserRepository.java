package hu.infokristaly.loginserver.repository;

import hu.infokristaly.loginserver.entity.RFIDCard;
import hu.infokristaly.loginserver.entity.RFIDCardUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;

@Repository
public interface RFIDCardUserRepository extends JpaRepository<RFIDCardUser, Long> {

    public RFIDCardUser findByRfidCardAndPeriodStartBeforeAndPeriodEndAfter(RFIDCard rfidCard, Date periodStart, Date periodEnd);

    public List<RFIDCardUser> findAllByOrderByClientNameAsc();
}

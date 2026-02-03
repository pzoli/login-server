package hu.infokristaly.loginserver.service;

import hu.infokristaly.loginserver.entity.RFIDCard;
import hu.infokristaly.loginserver.entity.RFIDCardUser;
import hu.infokristaly.loginserver.repository.RFIDCardUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RFIDCardUserService {

    @Autowired
    private RFIDCardUserRepository rfidCardUserRepository;

    public List<RFIDCardUser> findAll() {
        return rfidCardUserRepository.findAllByOrderByClientNameAsc();
    }

    public RFIDCardUser findByRFIDCardAndDate(RFIDCard rfidCard, Date date) {
        return rfidCardUserRepository.findByRfidCardAndPeriodStartBeforeAndPeriodEndAfter(rfidCard, date, date);
    }

    public RFIDCardUser save(RFIDCardUser rfidCardUser) {
        return rfidCardUserRepository.save(rfidCardUser);
    }

    public void delete(RFIDCardUser rfidCardUser) {
        rfidCardUserRepository.delete(rfidCardUser);
    }

    public RFIDCardUser findById(Long id) {
        return rfidCardUserRepository.findById(id).orElse(null);
    }
}

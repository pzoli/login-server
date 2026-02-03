package hu.infokristaly.loginserver.service;

import hu.infokristaly.loginserver.entity.RFIDCard;
import hu.infokristaly.loginserver.repository.RFIDCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RFIDCardService {

    @Autowired
    private RFIDCardRepository rfidCardRepository;

    public List<RFIDCard> getAll() {
        return rfidCardRepository.findAllByOrderById();
    }

    public RFIDCard getByRFID(String rfid, String type) {
        return rfidCardRepository.findByRfidAndType(rfid, type);
    }

    public RFIDCard save(RFIDCard rfidCard) {
        return rfidCardRepository.save(rfidCard);
    }

    public void delete(RFIDCard rfidCard) {
        rfidCardRepository.delete(rfidCard);
    }

    public RFIDCard findById(Long id) {
        return  rfidCardRepository.findById(id).orElse(null);
    }
}

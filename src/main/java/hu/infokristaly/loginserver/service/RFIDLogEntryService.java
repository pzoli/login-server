package hu.infokristaly.loginserver.service;

import hu.infokristaly.loginserver.entity.*;
import hu.infokristaly.loginserver.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
public class RFIDLogEntryService {

    @Autowired
    private RFIDLogEntryRepository rfidLogEntryRepository;

    @Autowired
    private RFIDCardRepository rfidCardRepository;

    @Autowired
    private RFIDCardUserRepository  rfidCardUserRepository;

    @Autowired
    private RFIDCardReaderRepository rfidCardReaderRepository;

    public boolean logCardEntry(String readerId, String cardId, String cardType) throws IOException {
        boolean result = false;
        RFIDCardReader reader = rfidCardReaderRepository.findByReaderId(readerId);
        if  (reader == null) {
            throw new IOException("Reader not found");
        }
        RFIDCard card = rfidCardRepository.findByRfidAndType(cardId, cardType);
        if  (card == null) {
            throw new IOException("Card not found");
        }
        Date now = new Date();
        RFIDCardUser user = rfidCardUserRepository.findByRfidCardAndPeriodStartBeforeAndPeriodEndAfter(card,now,now);
        if   (user == null) {
            throw new IOException("User not found");
        }
        RFIDLogEntry entry = new RFIDLogEntry();
        entry.setLogDate(new Date());
        entry.setRfidCardReader(reader);
        entry.setRfidCardUser(user);
        entry = rfidLogEntryRepository.save(entry);
        result = entry.getId() != null;
        return result;
    }

    public List<RFIDLogEntry> findAll() {
        return rfidLogEntryRepository.findAllByOrderByLogDateDesc();
    }

    public RFIDLogEntry save(RFIDLogEntry rfidFailedLog) {
        return rfidLogEntryRepository.save(rfidFailedLog);
    }

    public void delete(RFIDLogEntry rfidFailedLog) {
        rfidLogEntryRepository.delete(rfidFailedLog);
    }

    public RFIDLogEntry findById(Long id) {
        return  rfidLogEntryRepository.findById(id).orElse(null);
    }


}

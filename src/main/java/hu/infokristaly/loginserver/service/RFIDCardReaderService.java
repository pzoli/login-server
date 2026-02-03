package hu.infokristaly.loginserver.service;

import hu.infokristaly.loginserver.entity.RFIDCard;
import hu.infokristaly.loginserver.entity.RFIDCardReader;
import hu.infokristaly.loginserver.repository.RFIDCardReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RFIDCardReaderService {

    @Autowired
    private RFIDCardReaderRepository rfidCardReaderRepository;

    public RFIDCardReader getRFIDCardReaderByReaderId(String readerId) {
        return rfidCardReaderRepository.findByReaderId(readerId);
    }

    public RFIDCardReader save(RFIDCardReader rfidCardReader) {
        return rfidCardReaderRepository.save(rfidCardReader);
    }

    public void delete(RFIDCardReader rfidCardReader) {
        rfidCardReaderRepository.delete(rfidCardReader);
    }

    public List<RFIDCardReader> findAll() {
        return rfidCardReaderRepository.findAllByOrderById();
    }

    public RFIDCardReader findByID(Long id) {
        return rfidCardReaderRepository.findById(id).orElse(null);
    }
}

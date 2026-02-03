package hu.infokristaly.loginserver.service;

import hu.infokristaly.loginserver.entity.RFIDFailedLog;
import hu.infokristaly.loginserver.repository.RFIDFailedLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RFIDFailedLogService {

    @Autowired
    private RFIDFailedLogRepository rfidFailedLogRepository;

    public List<RFIDFailedLog> getAll() {
        return rfidFailedLogRepository.findAllByOrderByLogDateDesc();
    }

    public RFIDFailedLog save(RFIDFailedLog rfidFailedLog) {
        return rfidFailedLogRepository.save(rfidFailedLog);
    }

    public void delete(RFIDFailedLog rfidFailedLog) {
        rfidFailedLogRepository.delete(rfidFailedLog);
    }

    public RFIDFailedLog findById(Long id) {
        return  rfidFailedLogRepository.findById(id).orElse(null);
    }

}

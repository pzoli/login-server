package hu.infokristaly.loginserver.controller;

import hu.infokristaly.loginserver.entity.RFIDFailedLog;
import hu.infokristaly.loginserver.entity.RFIDLogEntry;
import hu.infokristaly.loginserver.repository.RFIDLogEntryRepository;
import hu.infokristaly.loginserver.service.RFIDLogEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rfid/logentry")
class RFIDLogEntryController {

    @Autowired
    RFIDLogEntryService rfidLogEntryService;

    @GetMapping
    public List<RFIDLogEntry> findAll() {
        return rfidLogEntryService.findAll();
    }

    @PostMapping()
    public RFIDLogEntry save(@RequestBody RFIDLogEntry rfidFailedLog) {
        return rfidLogEntryService.save(rfidFailedLog);
    }

    @PutMapping()
    public RFIDLogEntry update(@RequestBody RFIDLogEntry rfidFailedLog)
    {
        RFIDLogEntry result = rfidLogEntryService.findById(rfidFailedLog.getId());
        if (result != null) {
            result = rfidLogEntryService.save(rfidFailedLog);
        }
        return result;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        RFIDLogEntry rfidFailedLog = rfidLogEntryService.findById(id);
        if (rfidFailedLog != null) {
            rfidLogEntryService.delete(rfidFailedLog);
        }
    }

}

package hu.infokristaly.loginserver.controller;

import hu.infokristaly.loginserver.entity.RFIDFailedLog;
import hu.infokristaly.loginserver.entity.RFIDLogEntry;
import hu.infokristaly.loginserver.repository.RFIDLogEntryRepository;
import hu.infokristaly.loginserver.service.RFIDLogEntryService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rfid/logentry")
@SecurityRequirement(name = "Keycloak")
class RFIDLogEntryController {

    @Autowired
    RFIDLogEntryService rfidLogEntryService;

    @GetMapping
    @PreAuthorize("hasRole('user')")
    public List<RFIDLogEntry> findAll() {
        return rfidLogEntryService.findAll();
    }

    @PostMapping()
    @PreAuthorize("hasRole('manager')")
    public RFIDLogEntry save(@RequestBody RFIDLogEntry rfidFailedLog) {
        return rfidLogEntryService.save(rfidFailedLog);
    }

    @PutMapping()
    @PreAuthorize("hasRole('manager')")
    public RFIDLogEntry update(@RequestBody RFIDLogEntry rfidFailedLog)
    {
        RFIDLogEntry result = rfidLogEntryService.findById(rfidFailedLog.getId());
        if (result != null) {
            result = rfidLogEntryService.save(rfidFailedLog);
        }
        return result;
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('manager')")
    public void delete(@PathVariable Long id) {
        RFIDLogEntry rfidFailedLog = rfidLogEntryService.findById(id);
        if (rfidFailedLog != null) {
            rfidLogEntryService.delete(rfidFailedLog);
        }
    }

}

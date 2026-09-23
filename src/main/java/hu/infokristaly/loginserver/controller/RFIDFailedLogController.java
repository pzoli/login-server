package hu.infokristaly.loginserver.controller;

import hu.infokristaly.loginserver.entity.Client;
import hu.infokristaly.loginserver.entity.RFIDFailedLog;
import hu.infokristaly.loginserver.service.RFIDFailedLogService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rfid/failedlog")
@SecurityRequirement(name = "Keycloak")
class RFIDFailedLogController {

    @Autowired
    private RFIDFailedLogService rfidFailedLogService;

    @GetMapping()
    @PreAuthorize("hasRole('user')")
    public List<RFIDFailedLog> findAll(Pageable pageable) {
        return rfidFailedLogService.getAll(pageable);
    }
    @GetMapping("total-row-count")
    @PreAuthorize("hasRole('user')")
    public long getTotalRowCount() {
        long rowc = rfidFailedLogService.getTotalRowCount();
        return rowc;
    }

    @PostMapping()
    @PreAuthorize("hasRole('manager')")
    public RFIDFailedLog save(@RequestBody RFIDFailedLog rfidFailedLog) {
        return rfidFailedLogService.save(rfidFailedLog);
    }

    @PutMapping()
    @PreAuthorize("hasRole('manager')")
    public RFIDFailedLog update(@RequestBody RFIDFailedLog rfidFailedLog)
    {
        RFIDFailedLog result = rfidFailedLogService.findById(rfidFailedLog.getId());
        if (result != null) {
            result = rfidFailedLogService.save(rfidFailedLog);
        }
        return result;
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('manager')")
    public void delete(@PathVariable Long id) {
        RFIDFailedLog rfidFailedLog = rfidFailedLogService.findById(id);
        if (rfidFailedLog != null) {
            rfidFailedLogService.delete(rfidFailedLog);
        }
    }

}

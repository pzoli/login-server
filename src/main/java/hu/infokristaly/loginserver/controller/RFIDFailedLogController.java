package hu.infokristaly.loginserver.controller;

import hu.infokristaly.loginserver.entity.Client;
import hu.infokristaly.loginserver.entity.RFIDFailedLog;
import hu.infokristaly.loginserver.service.RFIDFailedLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rfid/failedlog")
class RFIDFailedLogController {

    @Autowired
    private RFIDFailedLogService rfidFailedLogService;

    @GetMapping()
    public List<RFIDFailedLog> findAll() {
        return rfidFailedLogService.getAll();
    }

    @PostMapping()
    public RFIDFailedLog save(@RequestBody RFIDFailedLog rfidFailedLog) {
        return rfidFailedLogService.save(rfidFailedLog);
    }

    @PutMapping()
    public RFIDFailedLog update(@RequestBody RFIDFailedLog rfidFailedLog)
    {
        RFIDFailedLog result = rfidFailedLogService.findById(rfidFailedLog.getId());
        if (result != null) {
            result = rfidFailedLogService.save(rfidFailedLog);
        }
        return result;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        RFIDFailedLog rfidFailedLog = rfidFailedLogService.findById(id);
        if (rfidFailedLog != null) {
            rfidFailedLogService.delete(rfidFailedLog);
        }
    }

}

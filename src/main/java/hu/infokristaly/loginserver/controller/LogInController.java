package hu.infokristaly.loginserver.controller;

import hu.infokristaly.loginserver.entity.RFIDFailedLog;
import hu.infokristaly.loginserver.service.RFIDFailedLogService;
import hu.infokristaly.loginserver.service.RFIDLogEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@RestController
@RequestMapping("/forras-admin/rest")
class LogInController {

    @Autowired
    private RFIDLogEntryService logEntityService;

    @Autowired
    private RFIDFailedLogService rfidFailedLogService;

    @GetMapping(value = "/createNFCLog", produces = "text/plain")
    public ResponseEntity<String> createNFCLog(@RequestParam("rfid") String rfid, @RequestParam("type") String type, @RequestParam("readerid") String readerid) {

        System.out.println("Creating NFC Log [rfid: " + rfid + "] [type: " + type + "] [reader: " + readerid + "]");
        String result = "{\"RESPONSE\":\"OK\"}";

        try {
            boolean success = logEntityService.logCardEntry(readerid,rfid,type);
            if (!success) {
                RFIDFailedLog rfidFailedLog = new RFIDFailedLog();
                rfidFailedLog.setLogDate(new Date());
                rfidFailedLog.setRfidCardRfId(rfid);
                rfidFailedLog.setRfidCardReaderId(readerid);
                rfidFailedLogService.save(rfidFailedLog);
                result = "{\"RESPONSE\":\"ERROR\"}";
                return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            RFIDFailedLog rfidFailedLog = new RFIDFailedLog();
            rfidFailedLog.setLogDate(new Date());
            rfidFailedLog.setRfidCardRfId(rfid);
            rfidFailedLog.setRfidCardReaderId(readerid);
            rfidFailedLogService.save(rfidFailedLog);
            result = "{\"RESPONSE\":\"ERROR\"}";
            return new ResponseEntity<>(result, HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}

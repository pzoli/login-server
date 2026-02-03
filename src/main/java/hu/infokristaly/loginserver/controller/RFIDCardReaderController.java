package hu.infokristaly.loginserver.controller;

import hu.infokristaly.loginserver.entity.RFIDCardReader;
import hu.infokristaly.loginserver.service.RFIDCardReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rfid/card-reader")
class RFIDCardReaderController {

    @Autowired
    RFIDCardReaderService rfidCardReaderService;

    @GetMapping
    public List<RFIDCardReader> findAll() {
        return rfidCardReaderService.findAll();
    }

    @PostMapping
    public RFIDCardReader save(@RequestBody RFIDCardReader rfidCardReader) {
        return rfidCardReaderService.save(rfidCardReader);
    }

    @PutMapping
    public RFIDCardReader update(@RequestBody RFIDCardReader rfidCardReader) {
        RFIDCardReader reader = rfidCardReaderService.findByID(rfidCardReader.getId());
        if  (reader != null) {
            reader = rfidCardReaderService.save(rfidCardReader);
        }
        return reader;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        RFIDCardReader reader = rfidCardReaderService.findByID(id);
        if (reader != null) {
            rfidCardReaderService.delete(reader);
        }
    }
}

package hu.infokristaly.loginserver.controller;

import hu.infokristaly.loginserver.entity.RFIDCardReader;
import hu.infokristaly.loginserver.service.RFIDCardReaderService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rfid/card-reader")
@SecurityRequirement(name = "Keycloak")
class RFIDCardReaderController {

    @Autowired
    RFIDCardReaderService rfidCardReaderService;

    @GetMapping
    @PreAuthorize("hasRole('user')")
    public List<RFIDCardReader> findAll() {
        return rfidCardReaderService.findAll();
    }

    @PostMapping
    @PreAuthorize("hasRole('manager')")
    public RFIDCardReader save(@RequestBody RFIDCardReader rfidCardReader) {
        return rfidCardReaderService.save(rfidCardReader);
    }

    @PutMapping
    @PreAuthorize("hasRole('manager')")
    public RFIDCardReader update(@RequestBody RFIDCardReader rfidCardReader) {
        RFIDCardReader reader = rfidCardReaderService.findByID(rfidCardReader.getId());
        if  (reader != null) {
            reader = rfidCardReaderService.save(rfidCardReader);
        }
        return reader;
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('manager')")
    public void delete(@PathVariable Long id) {
        RFIDCardReader reader = rfidCardReaderService.findByID(id);
        if (reader != null) {
            rfidCardReaderService.delete(reader);
        }
    }
}

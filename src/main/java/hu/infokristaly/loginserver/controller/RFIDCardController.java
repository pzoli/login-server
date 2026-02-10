package hu.infokristaly.loginserver.controller;

import hu.infokristaly.loginserver.entity.RFIDCard;
import hu.infokristaly.loginserver.service.RFIDCardService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rfid/card")
@SecurityRequirement(name = "Keycloak")
class RFIDCardController {

    @Autowired
    private RFIDCardService rfidCardService;

    @GetMapping
    @PreAuthorize("hasRole('user')")
    public List<RFIDCard> findAll() {
        return rfidCardService.getAll();
    }

    @PostMapping
    @PreAuthorize("hasRole('manager')")
    public RFIDCard save(@RequestBody RFIDCard rfidCard) {
        return rfidCardService.save(rfidCard);
    }

    @PutMapping
    @PreAuthorize("hasRole('manager')")
    public RFIDCard update(@RequestBody RFIDCard rfidCard) {
        RFIDCard card = rfidCardService.findById(rfidCard.getId());
        if (card != null ) {
            card = rfidCardService.save(rfidCard);
        }
        return card;
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('manager')")
    public void delete(@PathVariable Long id) {
        RFIDCard card = rfidCardService.findById(id);
        if (card != null) {
            rfidCardService.delete(card);
        }
    }
}

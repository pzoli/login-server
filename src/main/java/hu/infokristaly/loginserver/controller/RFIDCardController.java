package hu.infokristaly.loginserver.controller;

import hu.infokristaly.loginserver.entity.RFIDCard;
import hu.infokristaly.loginserver.service.RFIDCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rfid/card")
class RFIDCardController {

    @Autowired
    private RFIDCardService rfidCardService;

    @GetMapping
    public List<RFIDCard> findAll() {
        return rfidCardService.getAll();
    }

    @PostMapping
    public RFIDCard save(@RequestBody RFIDCard rfidCard) {
        return rfidCardService.save(rfidCard);
    }

    @PutMapping
    public RFIDCard update(@RequestBody RFIDCard rfidCard) {
        RFIDCard card = rfidCardService.findById(rfidCard.getId());
        if (card != null ) {
            card = rfidCardService.save(rfidCard);
        }
        return card;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        RFIDCard card = rfidCardService.findById(id);
        if (card != null) {
            rfidCardService.delete(card);
        }
    }
}

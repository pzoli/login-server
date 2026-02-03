package hu.infokristaly.loginserver.controller;

import hu.infokristaly.loginserver.entity.RFIDCardUser;
import hu.infokristaly.loginserver.repository.RFIDCardUserRepository;
import hu.infokristaly.loginserver.service.RFIDCardUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rfid/card-user")
class RFIDCardUserController {

    @Autowired
    private RFIDCardUserService rfidCardUserService;

    @GetMapping
    public List<RFIDCardUser> findAll() {
        return rfidCardUserService.findAll();
    }

    @PostMapping
    public RFIDCardUser save(@RequestBody RFIDCardUser rfidCardUser) {
        return rfidCardUserService.save(rfidCardUser);
    }

    @PutMapping
    public RFIDCardUser update(@RequestBody RFIDCardUser rfidCardUser) {
        RFIDCardUser user = rfidCardUserService.findById(rfidCardUser.getId());
        if (user != null) {
            user = rfidCardUserService.save(rfidCardUser);
        }
        return user;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        RFIDCardUser user = rfidCardUserService.findById(id);
        if (user != null) {
            rfidCardUserService.delete(user);
        }
    }
}

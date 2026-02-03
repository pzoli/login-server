package hu.infokristaly.loginserver.controller;

import hu.infokristaly.loginserver.entity.Client;
import hu.infokristaly.loginserver.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rfid/client")
class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping()
    public List<Client> findAll() {
        return clientService.getAllClient();
    }

    @PostMapping()
    public Client save(@RequestBody Client client) {
        return clientService.save(client);
    }

    @PutMapping()
    public Client update(@RequestBody Client client)
    {
        Client result = clientService.findById(client.getId());
        if (result != null) {
            result = clientService.save(client);
        }
        return result;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        Client client = clientService.findById(id);
        if (client != null) {
            clientService.delete(client);
        }
    }

}

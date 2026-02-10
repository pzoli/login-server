package hu.infokristaly.loginserver.controller;

import hu.infokristaly.loginserver.entity.Client;
import hu.infokristaly.loginserver.service.ClientService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rfid/client")
@SecurityRequirement(name = "Keycloak")
class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping()
    @PreAuthorize("hasRole('user')")
    public List<Client> findAll() {
        return clientService.getAllClient();
    }

    @PostMapping()
    @PreAuthorize("hasRole('manager')")
    public Client save(@RequestBody Client client) {
        return clientService.save(client);
    }

    @PutMapping()
    @PreAuthorize("hasRole('manager')")
    public Client update(@RequestBody Client client)
    {
        Client result = clientService.findById(client.getId());
        if (result != null) {
            result = clientService.save(client);
        }
        return result;
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('manager')")
    public void delete(@PathVariable Long id) {
        Client client = clientService.findById(id);
        if (client != null) {
            clientService.delete(client);
        }
    }

}

package hu.infokristaly.loginserver.service;

import hu.infokristaly.loginserver.entity.Client;
import hu.infokristaly.loginserver.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClient() {
        return clientRepository.findAllByOrderByNameAsc();
    }

    public Client save(Client client) {
        return clientRepository.save(client);
    }

    public void delete(Client client) {
        clientRepository.delete(client);
    }

    public Client findById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }
}

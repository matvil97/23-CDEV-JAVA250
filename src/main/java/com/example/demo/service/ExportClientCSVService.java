package com.example.demo.service;

import java.io.PrintWriter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dto.ClientDto;

@Service
public class ExportClientCSVService {

    @Autowired
    private ClientService clientService;

    public void export(PrintWriter writer) {
        writer.println("Nom;Prenom;Age");
        List<ClientDto> clientDtoList = clientService.findAll();
        for (ClientDto clientDto : clientDtoList) {
            writer.println(clientDto.getNom() + ";" + clientDto.getPrenom() + ";" + clientDto.getAge());
        }
    }

    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }
}

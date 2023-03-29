package com.example.demo.service.mapper;

import java.time.LocalDate;

import org.springframework.stereotype.Component;
import com.example.demo.dto.ClientDto;
import com.example.demo.entity.Client;

@Component
public class ClientMapper {

    public ClientDto clientDto(Client client, Integer age) {
        return new ClientDto(client.getId(), client.getNom(), client.getPrenom(), age);
    }

}

package com.example.demo.service.impl;

import static java.util.stream.Collectors.toList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.dto.ClientDto;
import com.example.demo.entity.Client;
import com.example.demo.repository.ClientRepository;
import com.example.demo.service.ClientService;
import com.example.demo.service.mapper.ClientMapper;

/**
 * Service contenant les actions métiers liées aux clients.
 */
@Service
@Transactional
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ClientMapper clientMapper;

    @Override
    public List<ClientDto> findAll() {
        List<ClientDto> dtos = new ArrayList<>();
        for (Client client : clientRepository.findAll()) {
            Integer age = LocalDate.now().getYear() - client.getDateNaissance().getYear();
            ClientDto dto = clientMapper.clientDto(client, age);
            dtos.add(dto);
        }
        return dtos;

        // return clientRepository.findAll().stream().map(client -> {
        //     Integer age = LocalDate.now().getYear() - client.getDateNaissance().getYear();
        //     return clientMapper.clientDto(client, age);
        // }).collect(toList());
    }

}

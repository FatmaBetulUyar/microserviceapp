package com.haydikodlayalim.service.impl;

import com.haydikodlayalim.dto.TicketDto;
import com.haydikodlayalim.model.PriorityType;
import com.haydikodlayalim.model.Ticket;
import com.haydikodlayalim.model.TicketStatus;
import com.haydikodlayalim.model.es.TicketModel;
import com.haydikodlayalim.repository.TicketRepository;
import com.haydikodlayalim.repository.es.TicketElasticRepository;
import com.haydikodlayalim.service.TicketService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketElasticRepository ticketElasticRepository;
    private final TicketRepository ticketRepository;
    private final ModelMapper modelMapper;

    public TicketServiceImpl(TicketElasticRepository ticketElasticRepository, TicketRepository ticketRepository, ModelMapper modelMapper) {
        this.ticketElasticRepository = ticketElasticRepository;
        this.ticketRepository = ticketRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public TicketDto save(TicketDto ticketDto) {
        Ticket ticket = new Ticket();
        //TODO Account API den doğrula
        // ticket.setAssigne();

        if (ticketDto.getDescription() == null)
            throw new IllegalArgumentException("Description bos olamaz");

            ticket.setDescription(ticketDto.getDescription());
        ticket.setNotes(ticketDto.getNotes());
        ticket.setTicketDate(ticketDto.getTicketDate());
        ticket.setTicketStatus(TicketStatus.valueOf(ticketDto.getTicketStatus()));
        ticket.setPriorityType(PriorityType.valueOf(ticketDto.getPriorityType()));


        //mysql e kaydet
        ticket = ticketRepository.save(ticket);

        // ticket model nesnesi yarat
        TicketModel model = TicketModel.builder()
                .description(ticket.getDescription())
                .notes(ticket.getNotes())
                .id(String.valueOf(ticket.getId()))
                .priorityType(ticket.getPriorityType().getLabel())
                .ticketStatus(ticket.getTicketStatus().getLabel())
                .ticketDate(ticket.getTicketDate()).build();

        // elastic kaydet
        ticketElasticRepository.save(model);

        // oluşan nesneyi döndür
        ticketDto.setId(String.valueOf(ticket.getId()));
        return ticketDto;
    }

    @Override
    public TicketDto update(String id,TicketDto ticketDto) {
        return null;
    }

    @Override
    public TicketDto getById(String ticketId) {
        return null;
    }

    @Override
    public Page<TicketDto> getPagination(Pageable pageable) {
        return null;
    }
}

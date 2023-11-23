package com.haydikodlayalim.repository;

import com.haydikodlayalim.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,String> {
}

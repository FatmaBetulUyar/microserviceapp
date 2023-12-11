package com.haydikodlayalim.service;

import com.haydikodlayalim.model.Ticket;

public interface TicketNotificationService {
    void sendToQueue(Ticket ticket);
}

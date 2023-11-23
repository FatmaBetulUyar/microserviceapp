package com.haydikodlayalim.model.es;

import com.haydikodlayalim.model.PriorityType;
import com.haydikodlayalim.model.TicketStatus;
import lombok.*;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@EqualsAndHashCode(of = {"id"})
@Document(indexName = "ticket")
@AllArgsConstructor
@NoArgsConstructor
public class TicketModel implements Serializable {

    @Id
    private String id;

    private String description;

    private String notes;

    private String assignee;

    private Date ticketDate;

    private String priorityType;

    private String  ticketStatus;
}

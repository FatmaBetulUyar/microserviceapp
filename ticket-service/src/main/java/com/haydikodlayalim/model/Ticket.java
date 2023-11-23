package com.haydikodlayalim.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "ticket")
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor
@AllArgsConstructor
public class Ticket extends BaseEntityModel {

    @Getter
    @Column(name = "id")
    @Id
    private String id = UUID.randomUUID().toString();

//    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
//    private UUID id;

    @Getter
    @Setter
    @Column(name = "description",length = 600)
    private String description;

    @Getter
    @Setter
    @Column(name = "notes",length = 4000)
    private String notes;

    @Getter
    @Setter
    @Column(name = "assignee",length = 50)
    private String assignee;

    @Getter
    @Setter
    @Column(name = "ticket_date" )
    private Date ticketDate;

    @Getter
    @Setter
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "priority_type")
    private PriorityType priorityType;

    @Getter
    @Setter
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "ticket_status")
    private TicketStatus ticketStatus;

}

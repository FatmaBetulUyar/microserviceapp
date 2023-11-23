package com.haydikodlayalim.repository.es;

import com.haydikodlayalim.model.es.TicketModel;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface TicketElasticRepository extends ElasticsearchRepository<TicketModel,String> {
}

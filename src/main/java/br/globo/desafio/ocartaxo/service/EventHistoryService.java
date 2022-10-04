package br.globo.desafio.ocartaxo.service;

import br.globo.desafio.ocartaxo.dto.EventHistoryDTO;
import br.globo.desafio.ocartaxo.mapper.EventHistoryMapper;
import br.globo.desafio.ocartaxo.model.EventHistory;
import br.globo.desafio.ocartaxo.repository.EventHistoryRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Service
public class EventHistoryService {

    private EventHistoryRepository repository;
    private EventHistoryMapper mapper = Mappers.getMapper(EventHistoryMapper.class);

    public EventHistoryService(EventHistoryRepository repository) {
        this.repository = repository;
    }

    public EventHistoryDTO registerEvent(EventHistory eh) {
        EventHistory newEventHistory = repository.save(eh);
        return mapper.toDTO(newEventHistory);
    }
}

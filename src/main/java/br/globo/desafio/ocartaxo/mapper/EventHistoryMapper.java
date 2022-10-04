package br.globo.desafio.ocartaxo.mapper;

import br.globo.desafio.ocartaxo.dto.EventHistoryDTO;
import br.globo.desafio.ocartaxo.model.EventHistory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface EventHistoryMapper {

    @Mappings({
            @Mapping(source="id", target="subscriptionId"),
            @Mapping(source="type", target="notificationType")
    })
    EventHistoryDTO toDTO(EventHistory eh);

}

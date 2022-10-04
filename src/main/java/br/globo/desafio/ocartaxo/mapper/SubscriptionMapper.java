package br.globo.desafio.ocartaxo.mapper;

import br.globo.desafio.ocartaxo.dto.SubscriptionDTO;
import br.globo.desafio.ocartaxo.model.Subscription;
import org.mapstruct.Mapper;

@Mapper
public interface SubscriptionMapper {

    SubscriptionDTO toDTO(Subscription subscription);

}

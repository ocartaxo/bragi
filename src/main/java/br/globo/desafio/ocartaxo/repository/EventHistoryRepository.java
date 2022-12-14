package br.globo.desafio.ocartaxo.repository;

import br.globo.desafio.ocartaxo.model.EventHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventHistoryRepository extends JpaRepository<EventHistory, Integer> {
}

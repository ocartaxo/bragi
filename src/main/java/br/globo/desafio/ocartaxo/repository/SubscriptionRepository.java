package br.globo.desafio.ocartaxo.repository;

import br.globo.desafio.ocartaxo.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, String> {

    @Query("SELECT s FROM Subscription s WHERE s.id = :id")
    Optional<Subscription> findBySubscriptionId(String id);


}

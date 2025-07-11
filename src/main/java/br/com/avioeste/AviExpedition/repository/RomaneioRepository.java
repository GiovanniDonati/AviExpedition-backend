package br.com.avioeste.AviExpedition.repository;

import br.com.avioeste.AviExpedition.entity.Romaneio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RomaneioRepository extends JpaRepository<Romaneio,UUID> {
    Optional<Romaneio> findByRomaneio(int romaneio);
}

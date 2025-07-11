package br.com.avioeste.AviExpedition.service;

import br.com.avioeste.AviExpedition.entity.Romaneio;
import br.com.avioeste.AviExpedition.repository.RomaneioRepository;
import br.com.avioeste.AviExpedition.web.exception.BadRequestException;

import br.com.avioeste.AviExpedition.web.exception.ResourceNotFoundException;
import org.springframework.transaction.annotation.Transactional;


public class RomaneioService {

    private final RomaneioRepository romaneioRepository;


    public RomaneioService(RomaneioRepository romaneioRepository){
        this.romaneioRepository = romaneioRepository;
    }

    @Transactional(readOnly = true)
    public Romaneio findByRomaneio(int romaneio){
        if (romaneio <= 0) {
            throw new BadRequestException("Romaneio must be provided");
        }
        Romaneio romaneio_db = romaneioRepository.findByRomaneio(romaneio)
                .orElseThrow(() -> new ResourceNotFoundException("Romaneio not Found"));

                return romaneio_db;
    }
}

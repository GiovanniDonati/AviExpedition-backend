package br.com.avioeste.AviExpedition.service;

import br.com.avioeste.AviExpedition.entity.Romaneio;
import br.com.avioeste.AviExpedition.repository.RomaneioRepository;
import br.com.avioeste.AviExpedition.web.dto.RomaneioDto;
import br.com.avioeste.AviExpedition.web.exception.BadRequestException;

import br.com.avioeste.AviExpedition.web.exception.ResourceAlreadyExistsException;
import br.com.avioeste.AviExpedition.web.exception.ResourceNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
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

    @Transactional
    public Romaneio create(RomaneioDto dto){
        Optional<Romaneio> existingRomaneio = romaneioRepository.findByRomaneio(dto.romaneio());

        if (existingRomaneio.isPresent()) {
            throw new ResourceAlreadyExistsException("Romaneio already exists.");
        } else {
            Romaneio newRomaneio = new Romaneio();
            BeanUtils.copyProperties(dto, newRomaneio);
            romaneioRepository.save(newRomaneio);
            return newRomaneio;
        }
        }
}

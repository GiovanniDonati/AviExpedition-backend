package br.com.avioeste.AviExpedition.web.controller;

import br.com.avioeste.AviExpedition.entity.Romaneio;
import br.com.avioeste.AviExpedition.repository.RomaneioRepository;
import br.com.avioeste.AviExpedition.web.dto.RomaneioDto;
import br.com.avioeste.AviExpedition.service.RomaneioService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("/api/v1/romaneios")
public class RomaneioController {

    @Autowired
    RomaneioRepository romaneioRepository;

    private final RomaneioService romaneioService;

    public RomaneioController(RomaneioService romaneioService) {
        this.romaneioService = romaneioService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Romaneio>> searchAllRomaneios(){
        return ResponseEntity.status(HttpStatus.OK).body(romaneioRepository.findAll());
    }

    @GetMapping("/{romaneio}")
    public ResponseEntity<Object> searchRomaneio(@PathVariable(value = "romaneio") int romaneio){
        Optional<Romaneio> romanei0 = romaneioRepository.findByRomaneio(romaneio);
        if(romanei0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Romaneio not found!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(romanei0.get());
    }

    @PostMapping("/")
    public ResponseEntity<Romaneio> createRomaneio(@RequestBody @Valid RomaneioDto romaneioDto) {
        Romaneio romaneioEntity = romaneioService.create(romaneioDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(romaneioEntity);
    }

    @DeleteMapping("/")
    public HttpStatus deleteRomaneio(@RequestBody UUID id ){
        romaneioRepository.deleteById(id);
        return HttpStatus.OK;
    }
}

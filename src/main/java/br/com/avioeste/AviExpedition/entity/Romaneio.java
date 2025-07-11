package br.com.avioeste.AviExpedition.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_romaneio")
public class Romaneio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID Id;
    private int romaneio;

}

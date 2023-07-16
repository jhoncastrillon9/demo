package backend.com.example.entidades;

import jakarta.persistence.*;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Caso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String delito;

    private LocalDateTime fechaHora;

    private double latitud;

    private double longitud;

    private double altitud;

    private String descripcion;

    private Long usuarioId;
}
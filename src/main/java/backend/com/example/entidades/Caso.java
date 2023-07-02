package backend.com.example.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
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

    @NotNull
    private String delito;

    @NotNull
    private LocalDateTime fechaHora;

    @NotNull
    private double latitud;

    @NotNull
    private double longitud;

    private double altitud;

    private String descripcion;

    @ManyToOne
    private Usuario usuario;
}
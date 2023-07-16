package backend.com.example.entidades;

import jakarta.persistence.*;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String contraseña;

    private Boolean isAdmin;

    // Otros atributos y relaciones

    @OneToMany(mappedBy = "usuarioId")
    private List<Caso> casos;
}
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

    // Otros atributos y relaciones

    @OneToMany(mappedBy = "usuario")
    private List<Caso> casos;
}
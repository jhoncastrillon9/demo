package backend.com.example.repositorios;

import backend.com.example.entidades.Caso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CasoRepository extends JpaRepository<Caso, Long> {
}
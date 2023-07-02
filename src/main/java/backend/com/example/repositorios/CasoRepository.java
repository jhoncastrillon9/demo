package backend.com.example.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import backend.com.example.entidades.Caso;

@Repository
public interface CasoRepository extends JpaRepository<Caso, Long> {
}
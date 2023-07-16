package backend.com.example.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import backend.com.example.repositorios.CasoRepository;
import backend.com.example.entidades.Caso;

import java.util.List;

@RestController
@RequestMapping("/casos")
public class CasoController {

    private final CasoRepository casoRepository;

    @Autowired
    public CasoController(CasoRepository casoRepository) {
        this.casoRepository = casoRepository;
    }

    @GetMapping
    public ResponseEntity<List<Caso>> obtenerTodosLosCasos() {
        List<Caso> casos = casoRepository.findAll();
        return ResponseEntity.ok(casos);
    }

    @PostMapping
    public ResponseEntity<Caso> crearCaso(@RequestBody Caso caso) {
        Caso nuevoCaso = casoRepository.save(caso);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCaso);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Caso> obtenerCasoPorId(@PathVariable Long id) {
        Caso caso = casoRepository.findById(id).orElse(null);
        if (caso != null) {
            return ResponseEntity.ok(caso);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Caso> actualizarCaso(@PathVariable Long id, @RequestBody Caso casoActualizado) {
        Caso casoExistente = casoRepository.findById(id).orElse(null);
        if (casoExistente != null) {
            casoExistente.setDelito(casoActualizado.getDelito());
            casoExistente.setFechaHora(casoActualizado.getFechaHora());
            casoExistente.setLatitud(casoActualizado.getLatitud());
            casoExistente.setLongitud(casoActualizado.getLongitud());
            casoExistente.setAltitud(casoActualizado.getAltitud());
            casoExistente.setDescripcion(casoActualizado.getDescripcion());
            casoExistente.setUsuarioId(casoActualizado.getUsuarioId());
            Caso casofinalActualizado = casoRepository.save(casoExistente);
            return ResponseEntity.ok(casofinalActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCaso(@PathVariable Long id) {
        if (casoRepository.existsById(id)) {
            casoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
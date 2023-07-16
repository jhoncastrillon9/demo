package backend.com.example.controladores;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import backend.com.example.repositorios.UsuarioRepository;
import backend.com.example.entidades.Usuario;

@RestController
@RequestMapping("/login")
public class LoginController {
    private final UsuarioRepository usuarioRepository;

    public LoginController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping
    public ResponseEntity<Usuario> login(@RequestBody Usuario usuario) {
        Usuario usuarioEncontrado = usuarioRepository.findByNombre(usuario.getNombre());
        if (usuarioEncontrado != null) {
            // Verificar si la contraseña es correcta
            if (usuarioEncontrado.getContraseña().equals(usuario.getContraseña())) {
                return ResponseEntity.ok(usuarioEncontrado); // Contraseña correcta, retornar el usuario
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); // Contraseña incorrecta, retornar error
                                                                               // de autenticación
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Usuario no encontrado, retornar error de no
                                                                        // encontrado
        }
    }
}

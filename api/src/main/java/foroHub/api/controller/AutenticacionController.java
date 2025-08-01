package foroHub.api.controller;

import foroHub.api.DTO.DatosAutenticacionUsuario;
import foroHub.api.DTO.DatosTokenJWT;
import foroHub.api.model.Usuario;
import foroHub.api.service.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AutenticacionController {
    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<DatosTokenJWT> login(@RequestBody @Valid DatosAutenticacionUsuario datos) {
        var authToken = new UsernamePasswordAuthenticationToken(datos.login(), datos.password());
        var authentication = authManager.authenticate(authToken);
        var jwtToken = tokenService.generarToken((Usuario) authentication.getPrincipal());
        return ResponseEntity.ok(new DatosTokenJWT(jwtToken));
    }
}

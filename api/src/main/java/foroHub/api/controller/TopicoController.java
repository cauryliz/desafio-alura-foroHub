package foroHub.api.controller;

import foroHub.api.DTO.DatosRegistroTopico;
import foroHub.api.DTO.DatosRespuestaTopico;
import foroHub.api.model.Topico;
import foroHub.api.repository.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
    @Autowired
    private TopicoRepository repository;

    @PostMapping
    public ResponseEntity<DatosRespuestaTopico> registrar(@RequestBody @Valid DatosRegistroTopico datos) {
        Topico topico = new Topico();
        BeanUtils.copyProperties(datos, topico);
        repository.save(topico);
        System.out.println(topico);
        return ResponseEntity.ok(new DatosRespuestaTopico(
                topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getAutor(),
                topico.getCurso(), topico.getEstatus(), topico.getFechaCreacion()));
    }

    @GetMapping
    public List<DatosRespuestaTopico> listar() {
        return repository.findAll().stream().map(t ->
                        new DatosRespuestaTopico(
                                t.getId(), t.getTitulo(), t.getMensaje(), t.getAutor(),
                                t.getCurso(), t.getEstatus(), t.getFechaCreacion()))
                .toList();

    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopico> detalle(@PathVariable Long id) {
        var topico = repository.findById(id).orElseThrow();
        return ResponseEntity.ok(new DatosRespuestaTopico(
                topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getAutor(),
                topico.getCurso(), topico.getEstatus(), topico.getFechaCreacion()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopico> actualizar(@PathVariable Long id, @RequestBody @Valid DatosRegistroTopico datos) {
        var topico = repository.findById(id).orElseThrow();
        BeanUtils.copyProperties(datos, topico, "id", "fechaCreacion", "estatus");
        repository.save(topico);
        return ResponseEntity.ok(new DatosRespuestaTopico(
                topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getAutor(),
                topico.getCurso(), topico.getEstatus(), topico.getFechaCreacion()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

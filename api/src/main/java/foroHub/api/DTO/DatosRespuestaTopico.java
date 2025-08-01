package foroHub.api.DTO;

import java.time.LocalDateTime;

public record DatosRespuestaTopico(
        Long id,
        String titulo,
        String mensaje,
        String autor,
        String curso,
        String estatus,
        LocalDateTime fechaCreacion
) {
}

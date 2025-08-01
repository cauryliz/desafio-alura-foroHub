package foroHub.api;

import foroHub.api.model.Usuario;
import foroHub.api.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ApiForoHubApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiForoHubApplication.class, args);
	}

//	@Bean
//	CommandLineRunner init(UsuarioRepository repository) {
//		return args -> {
//			if (repository.findByLogin("usuario").isEmpty()) {
//				Usuario user = new Usuario();
//				user.setLogin("usuario");
//				user.setPassword(new BCryptPasswordEncoder().encode("123456"));
//				repository.save(user);
//			}
//		};
//}
}

package student.studentCore.configurations;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import student.studentCore.entities.Student;
import student.studentCore.repositories.StudentRepository;

@Configuration
@Slf4j
public class InitDatabase {

    @Bean
    CommandLineRunner initialize(StudentRepository studentRepository) {
        return args -> {
            log.info("Database initialisation with : " + studentRepository.save(new Student("Tintin", "Bachelor 3", 1L)));
            log.info("Database initialisation with : " + studentRepository.save(new Student("Billy", "Master 1", 1L)));
            log.info("Database initialisation with : " + studentRepository.save(new Student("Tintin", "Bachelor 3", 1L)));
            log.info("Database initialisation with : " + studentRepository.save(new Student("Billy", "Master 1", 2L)));
        };
    }

}

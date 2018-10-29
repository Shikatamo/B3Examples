package course.courseCore.configurations;

import course.courseCore.entities.Course;
import course.courseCore.repositories.CourseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class InitDatabase {

    @Bean
    CommandLineRunner initialize(CourseRepository courseRepository) {
        return args -> {
            log.info("Database initialisation with : " + courseRepository.save(new Course("Java")));
            log.info("Database initialisation with : " + courseRepository.save(new Course("NodeJS")));

        };
    }

}

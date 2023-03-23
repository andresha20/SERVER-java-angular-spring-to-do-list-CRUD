package project.tech.crud.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import project.tech.crud.models.Task;

public interface Tasks extends MongoRepository<Task, String> {

}

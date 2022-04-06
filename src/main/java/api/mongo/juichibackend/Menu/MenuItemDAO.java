package api.mongo.juichibackend.Menu;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MenuItemDAO extends MongoRepository<MenuItem, String> {
    boolean existsByName(String name);
}

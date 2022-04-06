package api.mongo.juichibackend.Menu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class MenuItem {

    @Id
    @JsonIgnore
    private String id;

    @Indexed(unique = true)
    private String menuId;

//    @Indexed(unique = true)
    private String name;

    private String description;
    private Float price;
    private MenuType type;
    private String imageSource;
}

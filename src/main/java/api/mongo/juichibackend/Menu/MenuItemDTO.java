package api.mongo.juichibackend.Menu;

import lombok.Data;

@Data
public class MenuItemDTO {

    private String menuId;
    private String name;
    private String description;
    private Float price;
    private MenuType type;
    private String imageSource;

    public MenuItemDTO( MenuItem menuItem){
        this.menuId = menuItem.getMenuId();
        this.name = menuItem.getName();
        this.description = menuItem.getDescription();
        this.price = menuItem.getPrice();
        this.type = menuItem.getType();
        this.imageSource = menuItem.getImageSource();
    }

}

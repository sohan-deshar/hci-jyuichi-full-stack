package api.mongo.juichibackend.Menu;

import api.mongo.juichibackend.Exceptions.MenuNameAlreadyTakenException;
import api.mongo.juichibackend.Utils.Utils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
@AllArgsConstructor
public class MenuItemService {
    private final MenuItemDAO menuItemDAO;

    public List<MenuItemDTO> getAllMenuItem(){
        return this.menuItemDAO
                .findAll()
                .stream()
                .map(MenuItemDTO::new)
                .toList();
    }

    public MenuItemDTO addMenuItem(MenuItem menuItem){

        int MENU_ID_RANDOM_LENGTH = 5;
        String sb = menuItem.getType().toValue() +
                '-' +
                Utils.generateRandomString(MENU_ID_RANDOM_LENGTH).toUpperCase(Locale.ROOT);
        menuItem.setMenuId(sb);

        // checking if the menu with same name exists
        if(this.menuItemDAO.existsByName(menuItem.getName())){
            throw new MenuNameAlreadyTakenException("The requested name for the menu is already taken.\n Be little creative, will you?");
        }

        MenuItem savedItem = this.menuItemDAO.save(menuItem);
        return new MenuItemDTO(savedItem);
    }

    public MenuItem updateMeunItem(MenuItem menuItem){
        return this.menuItemDAO.save(menuItem);
    }



}

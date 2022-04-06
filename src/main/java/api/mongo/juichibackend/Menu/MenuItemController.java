package api.mongo.juichibackend.Menu;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menu")
@AllArgsConstructor
@Slf4j
public class MenuItemController {
    private final MenuItemService menuItemService;


    @GetMapping("/get-all")
    public ResponseEntity<List<MenuItemDTO>> getAllMenuItem(){
        List<MenuItemDTO> item = this.menuItemService.getAllMenuItem();
        return ResponseEntity.ok().body(item);
    }

    @PostMapping("/add")
    public ResponseEntity<MenuItemDTO> addMenuItem(@RequestBody MenuItem menuItem){
        MenuItemDTO addedItem = this.menuItemService.addMenuItem(menuItem);
        log.info("Added menu item: "+ addedItem);
        return ResponseEntity.ok().body(addedItem);
    }

    @PutMapping("/update")
    public ResponseEntity<MenuItem> updateMenuItem(@RequestBody MenuItem menuItem){
        log.info("Received: " + menuItem);
        MenuItem updatedItem = this.menuItemService.updateMeunItem(menuItem);
        log.info("Updated: " + updatedItem);
        return ResponseEntity.ok().body(updatedItem);
    }
}

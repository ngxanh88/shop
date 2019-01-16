package de.ngxa.restaurant.controller;

import de.ngxa.restaurant.entity.Menu;
import de.ngxa.restaurant.entity.MenuItem;
import de.ngxa.restaurant.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/manager/api/{shopName}/menu")
public class MenuManagerController {

    private MenuService menuService;

    @Autowired
    public MenuManagerController(MenuService menuService) {
        this.menuService = menuService;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List<Menu> getMenuByShopName(@PathVariable String shopName) {
        return menuService.getMenus(shopName);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Menu getMenuById(@RequestParam long id) {
        return menuService.getMenuById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Menu createMenu(@Valid @RequestBody Menu menu) {
        return menuService.createOrUpdateMenu(menu);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public Menu updateMenu(@Valid @RequestBody Menu menu) {
        return menuService.updateCustomizedMenuInfo(menu);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    public boolean deleteMenu(@RequestParam long id) {
        return menuService.deleteMenu(id);
    }

    @RequestMapping(value = "/{menuId}/item/list", method = RequestMethod.GET)
    @ResponseBody
    public List<MenuItem> getMenuItems(@PathVariable String shopName, @PathVariable Long menuId) {
        return menuService.getMenuItems(shopName, menuId);
    }

    @RequestMapping(value = "/{menuId}/item", method = RequestMethod.GET)
    @ResponseBody
    public MenuItem getMenuItemById(@RequestParam long id) {
        return menuService.getMenuItemById(id);
    }

    @RequestMapping(value = "/{menuId}/item", method = RequestMethod.POST)
    @ResponseBody
    public MenuItem createMenuItem(@PathVariable Long menuId, @Valid @RequestBody MenuItem menuItem) {
        return menuService.createMenuItem(menuId, menuItem);
    }

    @RequestMapping(value = "/{menuId}/item", method = RequestMethod.PUT)
    @ResponseBody
    public MenuItem updateMenuItem(@Valid @RequestBody MenuItem menuItem) {
        return menuService.updateMenuItem(menuItem);
    }

    @RequestMapping(value = "/{menuId}/item", method = RequestMethod.DELETE)
    @ResponseBody
    public boolean deleteMenuItem(@RequestParam long id) {
        return menuService.deleteMenuItem(id);
    }
}

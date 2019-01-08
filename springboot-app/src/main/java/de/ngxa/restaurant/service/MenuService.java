package de.ngxa.restaurant.service;

import de.ngxa.restaurant.dao.GroupOptionDao;
import de.ngxa.restaurant.dao.MenuDao;
import de.ngxa.restaurant.dao.MenuItemDao;
import de.ngxa.restaurant.entity.GroupOption;
import de.ngxa.restaurant.entity.Menu;
import de.ngxa.restaurant.entity.MenuItem;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class MenuService {
	
	private static final String DEFAULT_PARENT_MENU = "other";

	private MenuDao menuDao;

	private MenuItemDao menuItemDao;

	private GroupOptionDao groupOptionDao;

	@Autowired
    public MenuService(MenuDao menuDao, MenuItemDao menuItemDao, GroupOptionDao groupOptionDao) {
        this.menuDao = menuDao;
        this.menuItemDao = menuItemDao;
        this.groupOptionDao = groupOptionDao;
    }

    public Menu createOrUpdateMenu(Menu menu) {
	    if(menu.getId() != null) {
	        return menuDao.update(menu);
        }
		return menuDao.create(menu);
	}

	public Menu updateCustomizedMenuInfo(Menu customizedMenu){
		final Menu updatedEntity = menuDao.getByID(customizedMenu.getId(), Menu.class);
		updatedEntity.setName(customizedMenu.getName());
		updatedEntity.setDescription(customizedMenu.getDescription());
		updatedEntity.setParentMenu(getParentMenuOrDefault(customizedMenu.getParentMenu()));
		updatedEntity.setIndex(customizedMenu.getIndex());
        updatedEntity.setUrlName(customizedMenu.getUrlName());

        return menuDao.update(customizedMenu);
	}

	public boolean deleteMenu(Long menuId) {
		return menuDao.endDeleteById(menuId, Menu.class);
	}

	public MenuItem createMenuItem(Long menuId, MenuItem item) {
		final Menu menu = menuDao.getByID(menuId, Menu.class);

        item.setMenu(menu);

		menu.getItems().add(item);
		menuDao.update(menu);
		return menu.getItems().get(menu.getItems().size() - 1);
	}

	public MenuItem updateMenuItem(MenuItem item) {
		return menuItemDao.update(item);
	}

	public boolean deleteMenuItem(Long menuItemId) {
		return menuItemDao.endDeleteById(menuItemId, MenuItem.class);
	}

	public List<Menu> getMenus(String shopName) {
		if(StringUtils.isEmpty(shopName)){
            return new ArrayList<>();
		}

        return menuDao.findByShopName(shopName);
	}

	public List<MenuItem> getMenuItems(String shopName, Long menuId) {
		if(StringUtils.isEmpty(shopName) || menuId == null){
			return new ArrayList<>();
		}
		
		return menuItemDao.findByShopNameAndMenuId(shopName, menuId);
	}

	public GroupOption createOrUpdateGroupOption(GroupOption groupOption) {
	    if(groupOption.getId() != null) {
	        return groupOptionDao.update(groupOption);
        }
		return groupOptionDao.create(groupOption);
	}

	public MenuItem addGroupOptionInMenuItem(Long menuItemId, GroupOption groupOption) {
		final MenuItem menuItem = menuItemDao.getByID(menuItemId, MenuItem.class);

        menuItem.getGroupOptions().add(groupOption);
        return menuItemDao.update(menuItem);
	}

	public List<GroupOption> getAllGroupOptions(String shopName) {
		return groupOptionDao.findByShopName(shopName);
	}

	public MenuItem getMenuItem(String shopName, String menuItemNumber) {
		if(StringUtils.isEmpty(shopName) || StringUtils.isEmpty(menuItemNumber)) {
			return null;
		}
        return menuItemDao.findByItemNumber(shopName, menuItemNumber);
	}

	public boolean deleteGroupOption(Long groupOptionId) {
		return groupOptionDao.endDeleteById(groupOptionId, GroupOption.class);
	}

    private String getParentMenuOrDefault(String parentMenu) {
        if(StringUtils.isEmpty(parentMenu)) {
            return DEFAULT_PARENT_MENU;
        }
        return parentMenu;
    }
}

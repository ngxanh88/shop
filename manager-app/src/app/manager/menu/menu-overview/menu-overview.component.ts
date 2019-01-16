import { Component, OnInit } from '@angular/core';
import {routerTransition} from '../../../router.animations';
import {Menu} from '../../../dto/menu';
import {MenuDao} from '../../../shared/dao';

@Component({
  selector: 'app-menu-overview',
  templateUrl: './menu-overview.component.html',
  styleUrls: ['./menu-overview.component.scss'],
  animations: [routerTransition()]
})
export class MenuOverviewComponent implements OnInit {

  menus: Array<Menu> = [];
  selectedMenu: Menu;

  constructor(private menuDao: MenuDao) { }

  ngOnInit() {
    this.menus.push(<Menu> {
      id: 1,
      name: 'Rindersteak',
      description: 'menu description sdasd asd asd',
      items: [
        {
          id: 1,
          number: 'L23',
          name: 'Chop Suey arg Rindersteak',
          shortDecs: 'des of this menu item',
          grossBasePrice: 23.45
        }
      ]
    });
    this.menus.push(<Menu> {
      id: 2,
      name: 'Sushi',
      description: 'menu description sdasd asd asd',
      items: []
    });
    this.menus.push(<Menu> {
      id: 3,
      name: 'Salate',
      description: 'menu description sdasd asd asd',
      items: [
        {
          id: 1,
          number: 'B23',
          name: 'Salate Chop Suey arg Rindersteak',
          shortDecs: 'des of this menu item',
          grossBasePrice: 23.45
        },
        {
          id: 1,
          number: 'B24',
          name: 'Salate Chop Suey arg Rindersteak',
          shortDecs: 'des of this menu item',
          grossBasePrice: 23.45
        }
      ]
    });

    this.selectedMenu = this.menus[0];

    this.menuDao.getAll().subscribe((data) => console.log(data));
  }

}

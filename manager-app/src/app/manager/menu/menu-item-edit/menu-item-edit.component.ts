import { Component, OnInit } from '@angular/core';
import {routerTransition} from '../../../router.animations';

@Component({
  selector: 'app-menu-item-edit',
  templateUrl: './menu-item-edit.component.html',
  styleUrls: ['./menu-item-edit.component.scss'],
  animations: [routerTransition()]
})
export class MenuItemEditComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}

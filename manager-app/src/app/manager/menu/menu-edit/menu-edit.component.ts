import { Component, OnInit } from '@angular/core';
import {routerTransition} from '../../../router.animations';

@Component({
  selector: 'app-menu-edit',
  templateUrl: './menu-edit.component.html',
  styleUrls: ['./menu-edit.component.scss'],
  animations: [routerTransition()]
})
export class MenuEditComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}

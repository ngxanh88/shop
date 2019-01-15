import { Component, OnInit } from '@angular/core';
import {routerTransition} from '../../../router.animations';

@Component({
  selector: 'app-shop-overview',
  templateUrl: './shop-overview.component.html',
  styleUrls: ['./shop-overview.component.scss'],
  animations: [routerTransition()]
})
export class ShopOverviewComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}

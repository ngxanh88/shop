import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MenuRoutingModule } from './menu-routing.module';
import { MenuOverviewComponent } from './menu-overview/menu-overview.component';
import {PageHeaderModule} from '../../shared/modules';
import { MenuEditComponent } from './menu-edit/menu-edit.component';
import { MenuItemEditComponent } from './menu-item-edit/menu-item-edit.component';

@NgModule({
  declarations: [MenuOverviewComponent, MenuEditComponent, MenuItemEditComponent],
  imports: [
    CommonModule,
    MenuRoutingModule,
    PageHeaderModule
  ]
})
export class MenuModule { }

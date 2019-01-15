import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {MenuOverviewComponent} from './menu-overview/menu-overview.component';
import {MenuEditComponent} from './menu-edit/menu-edit.component';
import {MenuItemEditComponent} from './menu-item-edit/menu-item-edit.component';

const routes: Routes = [
  { path: '', component: MenuOverviewComponent },
  { path: 'edit/:menuId', component: MenuEditComponent },
  { path: 'item/edit/:menuItemId', component: MenuItemEditComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MenuRoutingModule { }

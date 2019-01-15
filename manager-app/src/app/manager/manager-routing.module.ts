import {RouterModule, Routes} from '@angular/router';
import {NgModule} from '@angular/core';
import {ManagerComponent} from './manager.component';

const routes: Routes = [
  {
    path: '',
    component: ManagerComponent,
    children: [
      { path: '', redirectTo: 'dashboard', pathMatch: 'prefix' },
      { path: 'dashboard', loadChildren: './dashboard/dashboard.module#DashboardModule' },
      { path: 'media', loadChildren: './media/media.module#MediaModule' },
      { path: 'menu', loadChildren: './menu/menu.module#MenuModule' },
      { path: 'general', loadChildren: './general/general.module#GeneralModule' },
      { path: 'order', loadChildren: './order/order.module#OrderModule' },
      // { path: 'grid', loadChildren: './grid/grid.module#GridModule' },
      // { path: 'components', loadChildren: './bs-component/bs-component.module#BsComponentModule' },
      // { path: 'blank-page', loadChildren: './blank-page/blank-page.module#BlankPageModule' }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ManagerRoutingModule {}

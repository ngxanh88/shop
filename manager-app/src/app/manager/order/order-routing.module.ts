import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {OrderOverviewComponent} from './order-overview/order-overview.component';

const routes: Routes = [
  { path: '', component: OrderOverviewComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class OrderRoutingModule { }

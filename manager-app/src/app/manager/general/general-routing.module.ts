import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ShopOverviewComponent} from './shop-overview/shop-overview.component';

const routes: Routes = [
  { path: '', component: ShopOverviewComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class GeneralRoutingModule { }

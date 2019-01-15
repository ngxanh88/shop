import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {GeneralRoutingModule} from './general-routing.module';
import {ShopOverviewComponent} from './shop-overview/shop-overview.component';
import {PageHeaderModule} from '../../shared/modules';

@NgModule({
  declarations: [ShopOverviewComponent],
  imports: [
    CommonModule,
    GeneralRoutingModule,
    PageHeaderModule
  ]
})
export class GeneralModule { }

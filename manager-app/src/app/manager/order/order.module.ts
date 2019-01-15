import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {OrderRoutingModule} from './order-routing.module';
import {OrderOverviewComponent} from './order-overview/order-overview.component';
import {PageHeaderModule} from '../../shared/modules';

@NgModule({
  declarations: [OrderOverviewComponent],
  imports: [
    CommonModule,
    OrderRoutingModule,
    PageHeaderModule
  ]
})
export class OrderModule { }

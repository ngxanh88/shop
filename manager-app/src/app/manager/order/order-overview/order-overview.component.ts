import {Component, OnInit} from '@angular/core';
import {routerTransition} from '../../../router.animations';
import {Order} from '../../../dto/order';
import {OrderStatus} from '../../../dto/enum/order-status.enum';

@Component({
  selector: 'app-order-overview',
  templateUrl: './order-overview.component.html',
  styleUrls: ['./order-overview.component.scss'],
  animations: [routerTransition()]
})
export class OrderOverviewComponent implements OnInit {

  orders: Array<Order> = [];
  selectedOrder: Order;

  constructor() { }

  ngOnInit() {
    this.orders.push(<Order> {
      id: 1,
      orderNumber: 'ABC123',
      status: OrderStatus.INCOMING,
      lines: []
    });

    this.orders.push(<Order> {
      id: 2,
      orderNumber: 'ABC124',
      status: OrderStatus.INCOMING,
      lines: []
    });
    this.orders.push(<Order> {
      id: 3,
      orderNumber: 'ABC124',
      status: OrderStatus.INCOMING,
      lines: []
    });
    this.orders.push(<Order> {
      id: 4,
      orderNumber: 'ABC124',
      status: OrderStatus.INCOMING,
      lines: []
    });
  }

}

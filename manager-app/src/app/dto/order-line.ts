import {BaseDto} from './base-dto';
import {OrderOption} from './order-option';

export class OrderLine extends BaseDto {

  // for internal order
  itemName: string;
  itemDesc: string;
  itemNumber: string;

  options: Array<OrderOption> = [];

  // for external orderlines
  externalItemName: string;
  externalItemDesc: string;
  externalItemNumber: string;
  externalItemPrice = 0.0;
  quantity = 0;

  isInternal = true;
}

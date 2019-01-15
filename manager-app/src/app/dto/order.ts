import {BaseDto} from './base-dto';
import {OrderLine} from './order-line';
import {OrderStatus} from './enum/order-status.enum';

export class Order extends BaseDto {

  shopName: string;

  lines: Array<OrderLine> = [];

  orderNumber: string;

  status = OrderStatus.INCOMING;

  // Order Info
  isPickup = false;
  isInternal = true;
  contactName: string;
  contactPhone: string;
  contactEmail: string;
  contactAddress: string;

  targetShopOwnerMail: string;

  // address in details
  contactCity: string;
  contactPostalCode: string;
  contactStreet: string;
  contactStreetNr: string;

  notice: string;

  // Order Region
  regionName: string;
  regionAdditionalPrice: number;
}

import {BaseDto} from './base-dto';
import {ExtInfo} from './ext-info';
import {MetaInfo} from './meta-info';
import {Contact} from './contact';
import {OrderRegion} from './order-region';
import {ShopType} from './enum/shop-type.enum';

export class Shop extends BaseDto {

  owner: string;
  name: string;

  alias: string;
  longDesc: string;
  shortDesc: string;
  openingTime: string;
  privacy: string;
  actualInfo: string;
  minOrderValue = 0;

  extInfo: Array<ExtInfo> = [];
  metaInfo: MetaInfo;

  contact: Contact;

  orderRegions: Array<OrderRegion> = [];

  isOrderAble = true;
  needIndex = true;
  shopType = ShopType.RESTAURANT;

  latitude: string;
  longitude: string;
}

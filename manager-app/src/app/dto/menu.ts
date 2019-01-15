import {BaseDto} from './base-dto';
import {MenuItem} from './menu-item';

export class Menu extends BaseDto {

  shopName: string;
  parentMenu: string;

  name: string;
  description: string;
  urlName: string;
  index = 1;

  items: Array<MenuItem> = [];
}

import {BaseDto} from './base-dto';
import {Menu} from './menu';

export class MenuItem extends BaseDto {

  shopName: string;

  number: string;
  name: string;

  longDecs: string;
  shortDecs: string;
  mainImgURL: string;
  grossBasePrice: number;
  orderCounter = 0;

  menu: Menu;
}

import {BaseDto} from './base-dto';

export class OrderRegion extends BaseDto {
  country: string;
  city: string;
  district: string;
  postal: string;

  price: number;
}

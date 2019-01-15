import {BaseDto} from './base-dto';

export class RecommendEntity extends BaseDto {

  shopName: string;

  name: string;
  alias: string;
  imgUrl: string;

  description: string;
  address: string;
  city: string;
}

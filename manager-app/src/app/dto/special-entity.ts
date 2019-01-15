import {BaseDto} from './base-dto';

export class SpecialEntity extends BaseDto {

  title: string;
  description: string;
  imageUrl: string;
  validFrom: Date;
  validTo: Date;
  city: string;

}

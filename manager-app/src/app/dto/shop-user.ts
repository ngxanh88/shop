import {BaseDto} from './base-dto';
import {UserType} from './enum/user-type.enum';

export class ShopUser extends BaseDto {

  shopName: string;

  username: string;

  firstName: string;
  lastName: string;
  email: string;

  userType = UserType.ADMIN;
}

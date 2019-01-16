import {Injectable} from '@angular/core';
import {BaseDaoImpl} from './base-dao-impl';
import {Menu} from '../../dto/menu';
import {HttpClient} from '@angular/common/http';

@Injectable()
export class MenuDao extends BaseDaoImpl<Menu> {

  constructor(protected http: HttpClient) {
    super(http);
  }

  protected getBaseEntryUrl(): string {
    return '/manager/api/test_shop/menu';
  }
}

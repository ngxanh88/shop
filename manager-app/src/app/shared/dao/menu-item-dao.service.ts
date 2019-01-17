import {Injectable} from '@angular/core';
import {BaseDaoImpl} from './base-dao-impl';
import {MenuItem} from '../../dto/menu-item';
import {HttpClient} from '@angular/common/http';

@Injectable()
export class MenuItemDao extends BaseDaoImpl<MenuItem> {

  private menuId: String;

  constructor(protected http: HttpClient) {
    super(http);
  }

  public setMenuId(menuId: String): void {
    this.menuId = menuId;
  }

  protected getBaseEntryUrl(): string {
    return '/manager/api/test_shop/menu/' + this.menuId + '/item';
  }
}

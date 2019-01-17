import { TestBed } from '@angular/core/testing';

import { MenuItemDao } from './menu-item-dao.service';

describe('MenuItemDao', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: MenuItemDao = TestBed.get(MenuItemDao);
    expect(service).toBeTruthy();
  });
});

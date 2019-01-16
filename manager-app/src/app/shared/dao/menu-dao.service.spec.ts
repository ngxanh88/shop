import { TestBed } from '@angular/core/testing';

import { MenuDao } from './menu-dao.service';

describe('MenuDao', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: MenuDao = TestBed.get(MenuDao);
    expect(service).toBeTruthy();
  });
});

import { TestBed } from '@angular/core/testing';

import { CcService } from './cc.service';

describe('CcService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CcService = TestBed.get(CcService);
    expect(service).toBeTruthy();
  });
});

import { TestBed } from '@angular/core/testing';

import { CarloanService } from './carloan.service';

describe('CarloanService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CarloanService = TestBed.get(CarloanService);
    expect(service).toBeTruthy();
  });
});

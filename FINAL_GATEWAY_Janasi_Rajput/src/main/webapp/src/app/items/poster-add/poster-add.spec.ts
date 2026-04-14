import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PosterAdd } from './poster-add';

describe('PosterAdd', () => {
  let component: PosterAdd;
  let fixture: ComponentFixture<PosterAdd>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PosterAdd],
    }).compileComponents();

    fixture = TestBed.createComponent(PosterAdd);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

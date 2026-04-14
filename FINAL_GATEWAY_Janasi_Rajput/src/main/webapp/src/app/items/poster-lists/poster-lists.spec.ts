import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PosterLists } from './poster-lists';

describe('PosterLists', () => {
  let component: PosterLists;
  let fixture: ComponentFixture<PosterLists>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PosterLists],
    }).compileComponents();

    fixture = TestBed.createComponent(PosterLists);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

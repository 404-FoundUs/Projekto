import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SideNavigationbarBoard } from './side-navigationbar-board';

describe('SideNavigationbarBoard', () => {
  let component: SideNavigationbarBoard;
  let fixture: ComponentFixture<SideNavigationbarBoard>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SideNavigationbarBoard]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SideNavigationbarBoard);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

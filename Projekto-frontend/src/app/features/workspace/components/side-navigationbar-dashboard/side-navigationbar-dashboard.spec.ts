import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SideNavigationbarDashboard } from './side-navigationbar-dashboard';

describe('SideNavigationbarDashboard', () => {
  let component: SideNavigationbarDashboard;
  let fixture: ComponentFixture<SideNavigationbarDashboard>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SideNavigationbarDashboard]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SideNavigationbarDashboard);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

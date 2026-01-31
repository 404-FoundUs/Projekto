import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SideNavigationbarWorkspace } from './side-navigationbar-workspace';

describe('SideNavigationbarWorkspace', () => {
  let component: SideNavigationbarWorkspace;
  let fixture: ComponentFixture<SideNavigationbarWorkspace>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SideNavigationbarWorkspace]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SideNavigationbarWorkspace);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

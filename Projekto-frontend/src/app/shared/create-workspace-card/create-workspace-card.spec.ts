import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateWorkspaceCard } from './create-workspace-card';

describe('CreateWorkspaceCard', () => {
  let component: CreateWorkspaceCard;
  let fixture: ComponentFixture<CreateWorkspaceCard>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CreateWorkspaceCard]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreateWorkspaceCard);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateModelCard } from './create-model-card';

describe('CreateModelCard', () => {
  let component: CreateModelCard;
  let fixture: ComponentFixture<CreateModelCard>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CreateModelCard]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreateModelCard);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

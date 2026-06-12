import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateBaordCard } from './create-baord-card';

describe('CreateBaordCard', () => {
  let component: CreateBaordCard;
  let fixture: ComponentFixture<CreateBaordCard>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CreateBaordCard]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreateBaordCard);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

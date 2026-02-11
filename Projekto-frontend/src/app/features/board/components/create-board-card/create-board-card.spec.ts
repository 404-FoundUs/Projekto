import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateBoardCard } from './create-board-card';

describe('CreateBoardCard', () => {
  let component: CreateBoardCard;
  let fixture: ComponentFixture<CreateBoardCard>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CreateBoardCard]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreateBoardCard);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

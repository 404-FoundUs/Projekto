import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MytasksCard } from './mytasks-card';

describe('MytasksCard', () => {
  let component: MytasksCard;
  let fixture: ComponentFixture<MytasksCard>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MytasksCard]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MytasksCard);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

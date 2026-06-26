import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BoardSettingsPage } from './board-settings-page';

describe('BoardSettingsPage', () => {
  let component: BoardSettingsPage;
  let fixture: ComponentFixture<BoardSettingsPage>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BoardSettingsPage]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BoardSettingsPage);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

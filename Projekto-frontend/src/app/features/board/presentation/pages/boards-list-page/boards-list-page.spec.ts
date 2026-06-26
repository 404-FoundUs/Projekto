import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BoardsListPage } from './boards-list-page';

describe('BoardsListPage', () => {
  let component: BoardsListPage;
  let fixture: ComponentFixture<BoardsListPage>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BoardsListPage]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BoardsListPage);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

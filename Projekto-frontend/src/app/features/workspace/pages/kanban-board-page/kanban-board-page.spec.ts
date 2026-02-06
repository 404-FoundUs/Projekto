import { ComponentFixture, TestBed } from '@angular/core/testing';

import { KanbanBoardPage } from './kanban-board-page';

describe('KanbanBoardPage', () => {
  let component: KanbanBoardPage;
  let fixture: ComponentFixture<KanbanBoardPage>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [KanbanBoardPage]
    })
    .compileComponents();

    fixture = TestBed.createComponent(KanbanBoardPage);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

/* eslint-disable @angular-eslint/prefer-inject */
import { BoardService } from './../../services/boards-service';
import { Component, OnInit } from '@angular/core';
import {
  ɵInternalFormsSharedModule,
  ReactiveFormsModule,
  FormGroup,
  Validators,
  FormBuilder,
} from '@angular/forms';
import { BoardRequestDto, Visibility } from '../../models/board.model';

@Component({
  selector: 'app-create-board-card',
  imports: [ɵInternalFormsSharedModule, ReactiveFormsModule],
  templateUrl: './create-board-card.html',
  styleUrl: './create-board-card.scss',
})
export class CreateBoardCard implements OnInit {
  private userid = '1eb8083f-cda4-4c7b-9a11-74bdb4389765';
  private workspaceid = '5d2871fe-5984-4110-bd40-a337db158897';

  form!: FormGroup;

  constructor(
    private fb: FormBuilder,
    private boardService: BoardService,
  ) {}

  ngOnInit(): void {
    this.form = this.fb.nonNullable.group({
      name: ['', Validators.required],
      description: ['', Validators.required],
      isWorkspace: [true], // default to workspace
    });
  }

  submit(): void {
    if (this.form.invalid) {
      this.form.markAllAsTouched();
      return;
    }

    // workspace type toggle has a bug it's sends only workspace value
    const dto: BoardRequestDto = {
      name: this.form.value.name!,
      description: this.form.value.description!,
      visibility: this.form.value.isWorkspace ? Visibility.WORKSPACE : Visibility.PRIVATE ,
      workspaceId: this.workspaceid,
      createdBy: this.userid,
    };

    this.boardService.createBoard(dto).subscribe({
      next: (workspace) => {
        console.log('Workspace created:', workspace);
      },
      error: (err) => {
        console.error('Error creating workspace:', err);
      },
    });
  }

  // Helper to check validation
  isControlInvalid(controlName: string): boolean {
    const control = this.form.get(controlName);
    return !!control && control.invalid && control.touched;
  }
}

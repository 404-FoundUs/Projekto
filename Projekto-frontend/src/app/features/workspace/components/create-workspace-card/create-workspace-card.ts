/* eslint-disable @angular-eslint/prefer-inject */
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { CreateWorkspaceDto, Visibility } from '../../models/workspace.model';
import { Workspace } from '../../services/workspace';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-create-workspace-card',
  imports: [ReactiveFormsModule, CommonModule],
  templateUrl: './create-workspace-card.html',
  styleUrl: './create-workspace-card.scss',
})
export class CreateWorkspaceCard implements OnInit {
  form!: FormGroup;
  Visibility = Visibility; // for template binding

  constructor(
    private fb: FormBuilder,
    private workspaceService: Workspace,
  ) {}

  ngOnInit(): void {
    this.form = this.fb.nonNullable.group({
      name: ['', Validators.required],
      description: ['', Validators.required],
      isPrivate: [true], // default to private
    });
  }

  submit(): void {
    if (this.form.invalid) {
      this.form.markAllAsTouched();
      return;
    }

    const dto: CreateWorkspaceDto = {
      name: this.form.value.name!,
      description: this.form.value.description!,
      visibility: this.form.value.isPrivate ? Visibility.PRIVATE : Visibility.PUBLIC,
      ownerId: '65ef429c-1697-4403-bbb5-f698456b2879', //check the user id issue here | solve this with jwt auth!
    };

    this.workspaceService.createWorkspace(dto).subscribe({
      next: (workspace) => {
        console.log('Workspace created:', workspace);
        this.form.reset({ isPrivate: true });        
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

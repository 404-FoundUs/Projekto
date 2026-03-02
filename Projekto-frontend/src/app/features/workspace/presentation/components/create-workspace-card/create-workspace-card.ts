/* eslint-disable @typescript-eslint/no-explicit-any */
import { Visibility } from './../../../domain/entities/workspace.model';
/* eslint-disable @angular-eslint/prefer-inject */
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { CreateWorkspaceDto } from '../../../domain/entities/workspace.model';
import { CreateWorkspaceUseCase } from '../../../application/use-cases/createWorkspace.usecase';
import { WorkspaceHttpRepository } from '../../../infrastructure/api/workspace-http.repository';

@Component({
  selector: 'app-create-workspace-card',
  imports: [ReactiveFormsModule, CommonModule],
  templateUrl: './create-workspace-card.html',
  styleUrl: './create-workspace-card.scss',
})
export class CreateWorkspaceCard implements OnInit {
  form!: FormGroup;
  visibility: Visibility | undefined;

  private createworkspace: CreateWorkspaceUseCase;

  constructor(
    private fb: FormBuilder,
    private repo: WorkspaceHttpRepository,
  ) {
    this.createworkspace = new CreateWorkspaceUseCase(repo);
  }

  ngOnInit(): void {
    this.form = this.fb.nonNullable.group({
      name: ['', Validators.required],
      description: ['', Validators.required],
      isPrivate: [true], // default to private
    });
  }

  isControlInvalid(controlName: string): boolean {
    const control = this.form.get(controlName);
    return !!(control && control.invalid && control.touched);
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

    console.log("DTO=>",dto)

    this.createworkspace.execute(dto).subscribe({
      next: (response) => {
        console.log('Workspace created:', response);
        this.form.reset({ isPrivate: true });
      },
      error: (error) => {
        console.error('Error creating workspace:', error);
      },
    });
  }
}

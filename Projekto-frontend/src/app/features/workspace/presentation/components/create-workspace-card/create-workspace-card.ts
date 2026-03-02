/* eslint-disable @typescript-eslint/no-explicit-any */
import { Visibility } from './../../../domain/entities/workspace.model';
/* eslint-disable @angular-eslint/prefer-inject */
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { CreateWorkspacePayload } from '../../../domain/entities/workspace.model';
import { CreateWorkspaceUseCase } from '../../../application/use-cases/createWorkspace.usecase';
import { WorkspaceHttpRepository } from '../../../infrastructure/api/workspace-http.repository';

@Component({
  selector: 'app-create-workspace-card',
  standalone:true,
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
      description: [''],
      isPrivate: [true], // default to private
    });
  }

  isControlInvalid(controlName: string): boolean {
    const control = this.form.get(controlName);
    return !!(control && control.invalid && control.touched);
  }

  submit(): void {
    console.log("button clicked");
    if (this.form.invalid) {
      this.form.markAllAsTouched();
      return;
    }

    const createPayload: CreateWorkspacePayload = {
      name: this.form.value.name!,
      description: this.form.value.description!,
      visibility: this.form.value.isPrivate ? Visibility.PRIVATE : Visibility.PUBLIC,
      ownerId: '65ef429c-1697-4403-bbb5-f698456b2879', //check the user id issue here | solve this with jwt auth!
    };

    this.createworkspace.execute(createPayload).subscribe({
      next: (response: any) => {
        console.log('Workspace created:', response);
        this.form.reset({ isPrivate: true });
      },
      error: (error:any) => {
        console.error('Error creating workspace:', error);
      },
    });
  }
}

import { GetUserWorkspacesUsecase } from '../../../../application/use-cases/get-user-workspaces.usecase';
/* eslint-disable @typescript-eslint/no-unused-expressions */
/* eslint-disable @angular-eslint/prefer-inject */
import { Component, OnInit } from '@angular/core';
import { SideNavigationbarDashboard } from '../../../../../dashboard/components/side-navigationbar-dashboard/side-navigationbar-dashboard';
import { WorkspaceCard } from '../../../components/workspace-card/workspace-card';
import { RouterLink } from '@angular/router';
import { WorkspaceDto } from '../../../../domain/entities/workspace.model';
import { NgForOf } from '@angular/common';
import { Subject, takeUntil } from 'rxjs';
import { WorkspaceHttpRepository } from '../../../../infrastructure/api/workspace-http.repository';

@Component({
  selector: 'app-workspace-page',
  imports: [SideNavigationbarDashboard, WorkspaceCard, RouterLink, NgForOf],
  templateUrl: './workspace-page.html',
  styleUrl: './workspace-page.scss',
})
export class WorkspacePage implements OnInit {
  private destroy$ = new Subject<void>();
  userId = '65ef429c-1697-4403-bbb5-f698456b2879';

  workspace: WorkspaceDto[] = [];

  private getUserWorkspaces: GetUserWorkspacesUsecase;

  constructor(private repo: WorkspaceHttpRepository) {
    this.getUserWorkspaces = new GetUserWorkspacesUsecase(repo);
  }
  ngOnInit(): void {
    this.loadData();
  }

  loadData() {
    this.getUserWorkspaces
      .execute(this.userId)
      .pipe(takeUntil(this.destroy$))
      .subscribe({
        next: (response) => {
          this.workspace = response;
          console.log('success response', response);
        },
        error: (err) => {
          console.error('error' + err);
        },
      });
  }

  trackById(_: number, ws: WorkspaceDto): string {
    return ws.id;
  }
}

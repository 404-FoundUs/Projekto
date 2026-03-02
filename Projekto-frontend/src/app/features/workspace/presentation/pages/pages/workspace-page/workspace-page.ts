/* eslint-disable @typescript-eslint/no-explicit-any */
import {} from '../../../../application/use-cases/getByUserId.usecase';
/* eslint-disable @typescript-eslint/no-unused-expressions */
/* eslint-disable @angular-eslint/prefer-inject */
import { Component, OnInit } from '@angular/core';
import { SideNavigationbarDashboard } from '../../../../../dashboard/components/side-navigationbar-dashboard/side-navigationbar-dashboard';
import { WorkspaceCard } from '../../../components/workspace-card/workspace-card';
import { RouterLink } from '@angular/router';
import { Workspace } from '../../../../domain/entities/workspace.model';
import { NgForOf } from '@angular/common';
import { Subject, takeUntil } from 'rxjs';
import { WorkspaceHttpRepository } from '../../../../infrastructure/api/workspace-http.repository';
import { GetByWorkspaceIdUsecase } from '../../../../application/use-cases/getByWorkspaceId.usecase';

@Component({
  selector: 'app-workspace-page',
  imports: [SideNavigationbarDashboard, WorkspaceCard, RouterLink, NgForOf],
  templateUrl: './workspace-page.html',
  styleUrl: './workspace-page.scss',
})
export class WorkspacePage implements OnInit {
  private destroy$ = new Subject<void>();
  userId = '65ef429c-1697-4403-bbb5-f698456b2879';

  workspace: Workspace[] = [];

  private getByWorkspaceIdUsecase: GetByWorkspaceIdUsecase;

  constructor(private repo: WorkspaceHttpRepository) {
    this.getByWorkspaceIdUsecase = new GetByWorkspaceIdUsecase(repo);
  }

  ngOnInit(): void {
    this.loadData();
  }

  loadData() {
    this.getByWorkspaceIdUsecase
      .execute(this.userId)
      .pipe(takeUntil(this.destroy$))
      .subscribe({
        next: (response: any) => {
          this.workspace = response;
          console.log('success response', response);
        },
        error: (err: any) => {
          console.error('error' + err.message);
        },
      });
  }

  trackById(_: number, ws: Workspace): string {
    return ws.id;
  }
}

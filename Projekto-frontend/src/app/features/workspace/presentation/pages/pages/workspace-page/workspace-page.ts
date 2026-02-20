/* eslint-disable @typescript-eslint/no-unused-expressions */
/* eslint-disable @angular-eslint/prefer-inject */
import { Component, OnInit } from '@angular/core';
import { SideNavigationbarDashboard } from '../../../../../dashboard/components/side-navigationbar-dashboard/side-navigationbar-dashboard';
import { WorkspaceCard } from '../../../components/workspace-card/workspace-card';
import { RouterLink } from '@angular/router';
import { WorkspaceDto } from '../../../../domain/entities/workspace.model';
import { Workspace } from '../../../../infrastructure/api/workspace';
import { NgForOf } from '@angular/common';

@Component({
  selector: 'app-workspace-page',
  imports: [SideNavigationbarDashboard, WorkspaceCard, RouterLink, NgForOf],
  templateUrl: './workspace-page.html',
  styleUrl: './workspace-page.scss',
})
export class WorkspacePage implements OnInit {
  userId = '65ef429c-1697-4403-bbb5-f698456b2879';

  workspaces: WorkspaceDto[] = [];

  constructor(private workspaceService: Workspace) {}

  ngOnInit(): void {
    this.loadData();
  }

  loadData() {
    this.workspaceService.getWorkspaces(this.userId).subscribe({
      next: (response) => {
        this.workspaces = response;
      },
      error: (error) => {
        console.error('error', error);
      },
    });
  }

  trackById(_: number, ws: WorkspaceDto): string {
    return ws.id;
  }
}

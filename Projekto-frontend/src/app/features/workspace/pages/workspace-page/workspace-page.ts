/* eslint-disable @typescript-eslint/no-unused-expressions */
/* eslint-disable @angular-eslint/prefer-inject */
import { Component, OnInit } from '@angular/core';
import { SideNavigationbarDashboard } from '../../../dashboard/components/side-navigationbar-dashboard/side-navigationbar-dashboard';
import { WorkspaceCard } from '../../components/workspaces/workspace-card/workspace-card';
import { RouterLink } from '@angular/router';
import { WorkspaceDto } from '../../models/workspace.model';
import { Workspace } from '../../services/workspace';
import { NgForOf } from '@angular/common';

@Component({
  selector: 'app-workspace-page',
  imports: [SideNavigationbarDashboard, WorkspaceCard, RouterLink, NgForOf],
  templateUrl: './workspace-page.html',
  styleUrl: './workspace-page.scss',
})
export class WorkspacePage implements OnInit {
  userId = '1eb8083f-cda4-4c7b-9a11-74bdb4389765';
  workspaceid = 'b5ddb9bf-e8c6-430b-bfba-3152fe6ba54b';

  workspaces: WorkspaceDto[] = [];

  constructor(private workspaceService: Workspace) {}

  ngOnInit(): void {
    this.loadData();
  }

  loadData() {
    this.workspaceService.getWorkspaces(this.userId).subscribe({
      next: (response) => {
        this.workspaces = response;
        console.log('success', response);
      },
      error: (error) => {
        console.error('error', error);
      },
    });
  }

  // load data by workspace id
  // loadDataById() {
  //   this.workspaceService.getWorkspacesById(this.workspaceid).subscribe({
  //     next: (response) => {
  //       // this.workspaces = response;
  //       console.log('success', response);
  //     },
  //     error: (error) => {
  //       console.error('error', error);
  //     },
  //   });
  // }

  // works but need some changes and checks
  // deleteById() {
  //   this.workspaceService.deleteWorkspace(this.workspaceid).subscribe({
  //     next: (response) => {
  //       console.log('success', response);
  //     },
  //     error: (error) => {
  //       console.log('error', error);
  //     },
  //   });
  // }

  trackById(_: number, ws: WorkspaceDto): string {
    return ws.id;
  }
}

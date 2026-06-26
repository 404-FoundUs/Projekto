import { Component, Input, Output, EventEmitter } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

interface Board {
  id: string;
  name: string;
  description?: string;
  color: string;
  icon?: string;
  pinned: boolean;
  progress?: number;
  totalTasks?: number;
  completedTasks?: number;
  members?: string[];
  updatedAt: Date;
  createdAt: Date;
  lastActiveAt?: Date;
}

@Component({
  selector: 'app-board-card',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './board-card.html',
  styleUrls: ['./board-card.scss']
})
export class BoardCardComponent {
  @Input() board!: Board;
  @Input() workspaceId!: string;
  @Input() isPinned = false;

  @Output() togglePin = new EventEmitter<Board>();

  // Maximum members to show before "+X"
  private readonly MAX_VISIBLE_MEMBERS = 3;

  /**
   * Get visible member avatars (first 3)
   */
  get visibleMembers(): string[] {
    if (!this.board.members) return [];
    return this.board.members.slice(0, this.MAX_VISIBLE_MEMBERS);
  }

  /**
   * Get count of remaining members
   */
  get remainingMembersCount(): number {
    if (!this.board.members) return 0;
    const remaining = this.board.members.length - this.MAX_VISIBLE_MEMBERS;
    return remaining > 0 ? remaining : 0;
  }

  /**
   * Calculate progress percentage
   */
  getProgressPercentage(): number {
    if (!this.board.totalTasks || this.board.totalTasks === 0) {
      return 0;
    }
    
    const completed = this.board.completedTasks || 0;
    return Math.round((completed / this.board.totalTasks) * 100);
  }

  /**
   * Get human-readable last active text
   */
  getLastActiveText(): string {
    const lastActive = this.board.lastActiveAt || this.board.updatedAt;
    const now = new Date();
    const diff = now.getTime() - new Date(lastActive).getTime();

    // Convert to minutes, hours, days
    const minutes = Math.floor(diff / 60000);
    const hours = Math.floor(minutes / 60);
    const days = Math.floor(hours / 24);

    if (minutes < 60) {
      return minutes <= 1 ? 'Just now' : `${minutes}m ago`;
    } else if (hours < 24) {
      return `${hours}h ago`;
    } else if (days < 7) {
      return `${days}d ago`;
    } else {
      return new Date(lastActive).toLocaleDateString('en-US', {
        month: 'short',
        day: 'numeric'
      });
    }
  }

  /**
   * Handle pin toggle
   */
  onTogglePin(event: Event): void {
    event.preventDefault();
    event.stopPropagation();
    this.togglePin.emit(this.board);
  }
}
import { Component } from '@angular/core';
import { SideNavigationbarDashboard } from "../../components/side-navigationbar-dashboard/side-navigationbar-dashboard";
import { QuickAccessCard } from "../../components/quick-access-card/quick-access-card";
import { MytasksCard } from "../../components/mytasks-card/mytasks-card";
import { RecentActivityCard } from "../../components/recent-activity-card/recent-activity-card";
import { CalendarCard } from "../../components/calendar-card/calendar-card";

@Component({
  selector: 'app-dashboard-page',
  imports: [SideNavigationbarDashboard, QuickAccessCard, MytasksCard, RecentActivityCard, CalendarCard],
  templateUrl: './dashboard-page.html',
  styleUrl: './dashboard-page.scss',
})
export class DashboardPage {

}

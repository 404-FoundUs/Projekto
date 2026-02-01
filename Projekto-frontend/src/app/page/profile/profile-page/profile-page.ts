import { Component } from '@angular/core';
import { ProfileHeader } from "../../../core/profile-header/profile-header";
import { RouterLink } from "@angular/router";

@Component({
  selector: 'app-profile-page',
  imports: [ProfileHeader, RouterLink],
  templateUrl: './profile-page.html',
  styleUrl: './profile-page.scss',
})
export class ProfilePage {

}

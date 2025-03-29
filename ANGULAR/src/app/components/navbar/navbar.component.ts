import { Component } from '@angular/core';
import { RouterLink, RouterLinkActive } from '@angular/router';
import { AuthService } from '../../services/auth.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [CommonModule, RouterLink, RouterLinkActive],
  template: `
    <nav class="navbar">
      <div class="container">
        <a routerLink="/" class="navbar-brand">TravelBlog</a>
        <div class="nav-links">
          <a routerLink="/destinations" routerLinkActive="active" class="nav-link">Destinations</a>
          <a routerLink="/posts" routerLinkActive="active" class="nav-link">Posts</a>
          <ng-container *ngIf="authService.currentUser$ | async; else loginLink">
            <a routerLink="/profile" routerLinkActive="active" class="nav-link">Profile</a>
            <a (click)="logout()" class="nav-link">Logout</a>
          </ng-container>
          <ng-template #loginLink>
            <a routerLink="/login" routerLinkActive="active" class="nav-link">Login</a>
          </ng-template>
        </div>
      </div>
    </nav>
  `
})
export class NavbarComponent {
  constructor(public authService: AuthService) {}

  logout(): void {
    this.authService.logout();
  }
}
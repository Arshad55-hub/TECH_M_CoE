import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AuthService } from '../../services/auth.service';
import { User } from '../../models/destination.model';

@Component({
  selector: 'app-profile',
  standalone: true,
  imports: [CommonModule, FormsModule],
  template: `
    <div class="container">
      <div class="card" style="max-width: 600px; margin: 40px auto;">
        <div style="text-align: center; margin-bottom: 20px;">
          <img
            [src]="(user$ | async)?.avatar || 'https://api.dicebear.com/7.x/avataaars/svg?seed=default'"
            alt="Profile"
            style="width: 150px; height: 150px; border-radius: 50%;"
          >
        </div>

        <form #profileForm="ngForm" (ngSubmit)="updateProfile()">
          <div class="form-group">
            <label for="name">Name</label>
            <input
              type="text"
              id="name"
              name="name"
              class="form-control"
              [(ngModel)]="profile.name"
              required
            >
          </div>

          <div class="form-group">
            <label for="email">Email</label>
            <input
              type="email"
              id="email"
              name="email"
              class="form-control"
              [(ngModel)]="profile.email"
              required
              email
            >
          </div>

          <div class="form-group">
            <label for="bio">Bio</label>
            <textarea
              id="bio"
              name="bio"
              class="form-control"
              [(ngModel)]="profile.bio"
              rows="4"
            ></textarea>
          </div>

          <button
            type="submit"
            class="btn btn-primary"
            [disabled]="profileForm.invalid || loading"
          >
            {{ loading ? 'Saving...' : 'Save Changes' }}
          </button>
        </form>
      </div>
    </div>
  `
})
export class ProfileComponent {
  user$ = this.authService.currentUser$;
  loading = false;
  profile = {
    name: '',
    email: '',
    bio: ''
  };

  constructor(private authService: AuthService) {
    this.user$.subscribe(user => {
      if (user) {
        this.profile = {
          name: user.name,
          email: user.email,
          bio: user.bio || ''
        };
      }
    });
  }

  updateProfile(): void {
    this.loading = true;
    // Simulate API call
    setTimeout(() => {
      this.loading = false;
    }, 1000);
  }
}
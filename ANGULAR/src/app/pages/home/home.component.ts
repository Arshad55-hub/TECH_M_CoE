import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, RouterLink],
  template: `
    <div class="container">
      <div class="hero" style="text-align: center; padding: 60px 0;">
        <h1 style="font-size: 2.5rem; margin-bottom: 1rem;">Welcome to Travel Blog</h1>
        <p style="font-size: 1.2rem; color: #666; margin-bottom: 2rem;">
          Discover amazing destinations and share your travel experiences
        </p>
        <a routerLink="/destinations" class="btn btn-primary">Explore Destinations</a>
      </div>

      <div style="margin-top: 40px;">
        <h2>Why Travel Blog?</h2>
        <div class="grid" style="margin-top: 20px;">
          <div class="card">
            <h3>Discover</h3>
            <p>Find amazing destinations from travelers around the world</p>
          </div>
          <div class="card">
            <h3>Share</h3>
            <p>Share your own travel experiences and tips</p>
          </div>
          <div class="card">
            <h3>Connect</h3>
            <p>Connect with fellow travelers and plan your next adventure</p>
          </div>
        </div>
      </div>
    </div>
  `
})
export class HomeComponent {}
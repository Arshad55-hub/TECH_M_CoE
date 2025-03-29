import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-posts',
  standalone: true,
  imports: [CommonModule, FormsModule],
  template: `
    <div class="container">
      <h1>Travel Posts</h1>
      
      <div class="card" style="margin-bottom: 20px;">
        <h3>Create New Post</h3>
        <form (ngSubmit)="createPost()" #postForm="ngForm">
          <div class="form-group">
            <label for="title">Title</label>
            <input
              type="text"
              id="title"
              name="title"
              class="form-control"
              [(ngModel)]="newPost.title"
              required
              #titleInput="ngModel"
            >
          </div>

          <div class="form-group">
            <label for="content">Content</label>
            <textarea
              id="content"
              name="content"
              class="form-control"
              [(ngModel)]="newPost.content"
              required
              rows="4"
              #contentInput="ngModel"
            ></textarea>
          </div>

          <button
            type="submit"
            class="btn btn-primary"
            [disabled]="postForm.invalid || loading"
          >
            {{ loading ? 'Creating...' : 'Create Post' }}
          </button>
        </form>
      </div>

      <div class="grid">
        <div class="card" *ngFor="let post of posts">
          <h3>{{ post.title }}</h3>
          <p>{{ post.content }}</p>
          <small>Posted on {{ post.createdAt | date }}</small>
        </div>
      </div>
    </div>
  `
})
export class PostsComponent {
  loading = false;
  newPost = {
    title: '',
    content: ''
  };
  
  posts = [
    {
      title: 'My Paris Adventure',
      content: 'Exploring the beautiful streets of Paris...',
      createdAt: new Date('2025-01-15')
    },
    {
      title: 'Beach Life in Bali',
      content: 'Discovering hidden beaches and local culture...',
      createdAt: new Date('2025-01-10')
    }
  ];

  createPost(): void {
    this.loading = true;
    // Simulate API call
    setTimeout(() => {
      this.posts.unshift({
        title: this.newPost.title,
        content: this.newPost.content,
        createdAt: new Date()
      });
      this.newPost = {
        title: '',
        content: ''
      };
      this.loading = false;
    }, 1000);
  }
}
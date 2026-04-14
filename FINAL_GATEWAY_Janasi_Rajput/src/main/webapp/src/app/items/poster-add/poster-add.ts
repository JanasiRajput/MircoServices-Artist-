import { Component, OnInit, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-poster-add',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './poster-add.html',
  styleUrl: './poster-add.css',
})
export class PosterAdd implements OnInit {
  item: any = { name: '', price: null, quantity: null, employeeName: '' };
  artists: any[] = [];
  
  private http = inject(HttpClient);
  private router = inject(Router);

  ngOnInit() {
    this.http.get<any[]>('/api/v1/gateway/artists').subscribe(
      (data) => this.artists = data
    );
  }

  addItem() {
    this.http.post('/api/v1/gateway/posters', this.item).subscribe(() => {
      this.router.navigate(['/items']);
    });
  }
}

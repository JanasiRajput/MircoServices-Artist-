import { Component, OnInit, inject, ChangeDetectorRef } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { NgIf } from '@angular/common';

@Component({
  selector: 'app-poster-lists',
  standalone: true,
  imports: [NgIf],
  templateUrl: './poster-lists.html',
  styleUrl: './poster-lists.css',
})
export class PosterLists implements OnInit {
  items: any[] = [];
  private http = inject(HttpClient);
  private cdr = inject(ChangeDetectorRef);

  ngOnInit() {
    this.fetchItems();
  }

  fetchItems() {
    this.http.get<any[]>('/api/v1/gateway/posters').subscribe(
      (data) => {
        this.items = data;
        this.cdr.detectChanges();
      }
    );
  }

  deleteItem(id: number) {
    this.http.delete(`/api/v1/gateway/posters/${id}`).subscribe(() => {
      this.fetchItems();
    });
  }

  purchaseItem(id: number) {
    this.http.put(`/api/v1/gateway/posters/${id}/purchase`, {}).subscribe(() => {
      this.fetchItems();
    });
  }
}

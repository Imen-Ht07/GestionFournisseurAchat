import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LigneCommandeAchat } from '../models/ligne-commande-achat';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LigneServiceService {

  private apiUrl = 'http://localhost:8083/api/ligneCommande'; // URL de base de ton backend

  constructor(private http: HttpClient) {}

  getAllLignes(): Observable<LigneCommandeAchat[]> {
    return this.http.get<LigneCommandeAchat[]>(this.apiUrl);
  }

  getLigneById(id: number): Observable<LigneCommandeAchat> {
    return this.http.get<LigneCommandeAchat>(`${this.apiUrl}/${id}`);
  }

  createLigne(ligne: LigneCommandeAchat): Observable<LigneCommandeAchat> {
    return this.http.post<LigneCommandeAchat>(this.apiUrl, ligne);
  }

  updateLigne(id: number, ligne: LigneCommandeAchat): Observable<LigneCommandeAchat> {
    return this.http.put<LigneCommandeAchat>(`${this.apiUrl}/${id}`, ligne);
  }

  deleteLigne(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}

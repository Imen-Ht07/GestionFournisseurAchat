import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CommandeAchat } from '../models/commande-achat';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CommandeServiceService {

 private apiUrl = 'http://localhost:8083/api/commandes'; 

  constructor(private http: HttpClient) {}

  getAllCommandes(): Observable<CommandeAchat[]> {
    return this.http.get<CommandeAchat[]>(this.apiUrl);
  }

  getCommandeById(id: number): Observable<CommandeAchat> {
    return this.http.get<CommandeAchat>(`${this.apiUrl}/${id}`);
  }

  createCommande(commande: CommandeAchat): Observable<CommandeAchat> {
    return this.http.post<CommandeAchat>(this.apiUrl, commande);
  }

  updateCommande(id: number, commande: CommandeAchat): Observable<CommandeAchat> {
    return this.http.put<CommandeAchat>(`${this.apiUrl}/${id}`, commande);
  }

  deleteCommande(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
  affecterFournisseurACommande(commandeId: number, fournisseurId: number): Observable<CommandeAchat> {
    return this.http.put<CommandeAchat>(
      `${this.apiUrl}/${commandeId}/fournisseur/${fournisseurId}`,
      {} // body vide (ou un objet si le backend en exige un)
    );
  }
}

import { Component } from '@angular/core';
import { FourniseurServiceService } from '../service/fourniseur-service.service';
import { Fournisseur } from '../models/fournisseur';

@Component({
  selector: 'app-fournisseur',
  templateUrl: './fournisseur.component.html',
  styleUrls: ['./fournisseur.component.css']
})
export class FournisseurComponent {
  fournisseurs: Fournisseur[] = [];
  searchTerm: string = '';

  constructor(private FourniseurServiceService: FourniseurServiceService) {}

  ngOnInit(): void {
    this.getFournisseurs();
  }

  getFournisseurs() {
    this.FourniseurServiceService.getFournisseurs().subscribe({
      next: (data) => {
        this.fournisseurs = data;
      },
      error: (err) => {
        console.error('Erreur lors de la récupération des fournisseurs', err);
      }
    });
  }

  supprimerFournisseur(fournisseur: any) {
    this.fournisseurs = this.fournisseurs.filter(f => f !== fournisseur);
    // Ou appelle ton service pour suppression côté serveur si besoin.
  }

  get filteredFournisseurs(): Fournisseur[] {
    if (!this.searchTerm) {
      return this.fournisseurs;
    }
    const term = this.searchTerm.trim().toLowerCase();
    return this.fournisseurs.filter(f =>
      (f.nom && f.nom.toLowerCase().includes(term)) ||
      (f.contact && f.contact.toLowerCase().includes(term)) ||
      (f.qualiteService && f.qualiteService.toLowerCase().includes(term))
    );
  }
}
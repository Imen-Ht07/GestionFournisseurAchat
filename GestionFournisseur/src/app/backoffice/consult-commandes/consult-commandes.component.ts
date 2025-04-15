import { Component } from '@angular/core';
import { CommandeAchat, StatutCommande } from '../models/commande-achat';
import { Fournisseur } from '../models/fournisseur';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CommandeServiceService } from '../service/commande-service.service';

@Component({
  selector: 'app-consult-commandes',
  templateUrl: './consult-commandes.component.html',
  styleUrls: ['./consult-commandes.component.css']
})
export class ConsultCommandesComponent {
   commandes: CommandeAchat[] = [];
  loading = false;
  errorMessage = '';

  constructor(
    private commandeService: CommandeServiceService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.getCommandes();
  }

  getCommandes() {
    this.loading = true;
    this.commandeService.getAllCommandes().subscribe({
      next: (data) => {
        this.commandes = data;
        this.loading = false;
      },
      error: () => {
        this.errorMessage = "Erreur lors du chargement des commandes.";
        this.loading = false;
      }
    });
  }

  annulerCommande(commande: CommandeAchat) {
    const commandeAnnulee = { ...commande, statut: 'ANNULEE' as StatutCommande };
    this.commandeService.updateCommande(commande.id, commandeAnnulee).subscribe({
      next: () => {
        commande.statut = 'ANNULEE';
      },
      error: () => {
        alert("Erreur lors de l'annulation !");
      }
    });
  }

  modifierCommande(commande: CommandeAchat) {
    this.router.navigate(['/edit-commande', commande.id]);
  }

  supprimerCommande(commande: CommandeAchat) {
    if (!confirm('Voulez-vous vraiment supprimer cette commande ?')) return;
    this.commandeService.deleteCommande(commande.id).subscribe({
      next: () => {
        this.commandes = this.commandes.filter(c => c.id !== commande.id);
      },
      error: () => {
        alert("Erreur lors de la suppression !");
      }
    });
  }
}

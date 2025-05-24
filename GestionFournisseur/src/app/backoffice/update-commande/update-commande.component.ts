import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { OnInit } from '@angular/core';
import { CommandeServiceService } from '../service/commande-service.service';
import { CommandeAchat } from '../models/commande-achat';
import { FourniseurServiceService} from '../service/fourniseur-service.service';
import { Fournisseur } from '../models/fournisseur';


@Component({
  selector: 'app-update-commande',
  templateUrl: './update-commande.component.html',
  styleUrls: ['./update-commande.component.css']
})
export class UpdateCommandeComponent implements OnInit {
  commandeId!: number;
  commande: CommandeAchat = {
    id: 0,
    date: '',
    statut: 'EN_ATTENTE',
    montant: 0,
    fournisseur: undefined,
    lignes: []
  };

  fournisseurs: Fournisseur[] = [];

  constructor(
    private route: ActivatedRoute,
    private commandeService: CommandeServiceService,
    private fournisseurService: FourniseurServiceService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.commandeId = Number(this.route.snapshot.paramMap.get('id'));

    this.commandeService.getCommandeById(this.commandeId).subscribe({
      next: (data) => this.commande = data,
      error: (err) => console.error('Erreur chargement commande:', err)
    });

    this.fournisseurService.getAllFournisseurs().subscribe({
      next: (data) => this.fournisseurs = data,
      error: (err) => console.error('Erreur chargement fournisseurs:', err)
    });
     const id = +this.route.snapshot.paramMap.get('id')!;
  this.commandeService.getCommandeById(id).subscribe((commande) => {
    this.commande = commande;
  });
  }
compareFournisseur(f1: Fournisseur, f2: Fournisseur): boolean {
  return f1 && f2 ? f1.id === f2.id : f1 === f2;
}
  onSubmit(): void {
    this.commandeService.updateCommande(this.commandeId, this.commande).subscribe({
      next: () => {
        alert('Commande mise à jour avec succès !');
        this.router.navigate(['/liste-commandes']);
      },
      error: (err) => console.error('Erreur lors de la mise à jour :', err)
    });
  }
  
}
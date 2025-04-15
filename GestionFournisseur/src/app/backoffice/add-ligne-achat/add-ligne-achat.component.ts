import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { LigneServiceService } from '../service/ligne-service.service';
import { LigneCommandeAchat } from '../models/ligne-commande-achat';
import { CommandeAchat, StatutCommande } from '../models/commande-achat';
import { CommandeServiceService } from '../service/commande-service.service';
import { Fournisseur } from '../models/fournisseur';
import { FourniseurServiceService } from '../service/fourniseur-service.service';

@Component({
  selector: 'app-add-ligne-achat',
  templateUrl: './add-ligne-achat.component.html',
  styleUrls: ['./add-ligne-achat.component.css']
})
export class AddLigneAchatComponent implements OnInit {
   commandeForm: FormGroup;
  statutOptions: StatutCommande[] = ['EN_ATTENTE', 'LIVREE', 'ANNULEE', 'EN_COURS'];
  fournisseurs: Fournisseur[] = [];
  successMessage = '';
  errorMessage = '';

  constructor(
    private fb: FormBuilder,
    private commandeService:CommandeServiceService,
    private ligneService: LigneServiceService,
    private fournisseurService:FourniseurServiceService
  ) {
    this.commandeForm = this.fb.group({
      fournisseur: [null, Validators.required],
      date: ['', Validators.required],
      statut: ['EN_ATTENTE', Validators.required],
      montant: [{ value: 0, disabled: true }, [Validators.required, Validators.min(0)]],
      lignes: this.fb.array([])
    });
  }

  ngOnInit() {
    this.fournisseurService.getAllFournisseurs().subscribe({
      next: data => this.fournisseurs = data,
      error: () => this.fournisseurs = []
    });
    this.recalculerMontant();
  }

  get lignes(): FormArray {
    return this.commandeForm.get('lignes') as FormArray;
  }

  addLigne(): void {
    const ligneGroup = this.fb.group({
      produit: ['', Validators.required],
      quantite: [0, [Validators.required, Validators.min(0)]],
      prixUnitaire: [0, [Validators.required, Validators.min(0)]]
    });

    ligneGroup.valueChanges.subscribe(() => this.recalculerMontant());

    this.lignes.push(ligneGroup);
    this.recalculerMontant();
  }

  removeLigne(index: number): void {
    this.lignes.removeAt(index);
    this.recalculerMontant();
  }

  private recalculerMontant(): void {
    const lignes = this.lignes.controls;
    let total = 0;
    for (let ligne of lignes) {
      const quantite = ligne.get('quantite')?.value || 0;
      const prixUnitaire = ligne.get('prixUnitaire')?.value || 0;
      total += quantite * prixUnitaire;
    }
    this.commandeForm.get('montant')?.setValue(total, { emitEvent: false });
  }

  async onSubmit() {
    this.successMessage = '';
    this.errorMessage = '';
    if (this.commandeForm.valid) {
      const commandeData = { ...this.commandeForm.getRawValue() }; // getRawValue pour lire les champs disabled
      const fournisseur: Fournisseur = commandeData.fournisseur;
      const lignesData = commandeData.lignes;
      delete commandeData.lignes;
      delete commandeData.fournisseur;

      // 1. Créer la commande (sans fournisseur)
      this.commandeService.createCommande(commandeData).subscribe({
        next: (commande: CommandeAchat) => {
          // 2. Affecter le fournisseur via l’API dédiée
          this.commandeService.affecterFournisseurACommande(commande.id!, fournisseur.id!).subscribe({
            next: async (commandeMaj: CommandeAchat) => {
              // 3. Ajouter les lignes de commande
              if (lignesData && lignesData.length > 0) {
                const lignesToSave = lignesData.map((ligne: any) => ({
                  ...ligne,
                  commande: commandeMaj
                }));

                try {
                  await Promise.all(
                    lignesToSave.map((ligne: LigneCommandeAchat) =>
                      this.ligneService.createLigne(ligne).toPromise()
                    )
                  );
                  this.successMessage = "Commande et lignes ajoutées avec succès !";
                  this.commandeForm.reset();
                  this.lignes.clear();
                  this.recalculerMontant();
                } catch (e) {
                  this.errorMessage = "Erreur lors de l’ajout des lignes.";
                }
              } else {
                this.successMessage = "Commande ajoutée sans lignes.";
                this.commandeForm.reset();
                this.lignes.clear();
                this.recalculerMontant();
              }
            },
            error: () => {
              this.errorMessage = "Erreur lors de l’affectation du fournisseur.";
            }
          });
        },
        error: () => {
          this.errorMessage = "Erreur lors de l’ajout de la commande.";
        }
      });
    }
  }
}
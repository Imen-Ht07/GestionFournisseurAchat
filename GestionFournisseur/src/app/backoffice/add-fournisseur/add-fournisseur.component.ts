import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { FourniseurServiceService } from '../service/fourniseur-service.service';
import { Fournisseur } from '../models/fournisseur';

@Component({
  selector: 'app-add-fournisseur',
  templateUrl: './add-fournisseur.component.html',
  styleUrls: ['./add-fournisseur.component.css']
})
export class AddFournisseurComponent {
  fournisseurForm: FormGroup;
  submitted = false;

  constructor(
    private fb: FormBuilder,
    private fournisseurService: FourniseurServiceService,
    private router: Router
  ) {
    this.fournisseurForm = this.fb.group({
      nom: ['', [Validators.required, Validators.minLength(2)]],
      contact: ['', [
        Validators.required,
        Validators.pattern(/^[\d\s+\-().]{6,}|[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/)
      ]],
      qualiteService: ['', [Validators.maxLength(50)]],
      note: [null, [Validators.required, Validators.min(0), Validators.max(10)]]
    });
  }

  get f() { return this.fournisseurForm.controls; }

  setStarRating(rate: number) {
    this.fournisseurForm.get('note')?.setValue(rate);
    this.fournisseurForm.get('note')?.markAsTouched();
  }

  onSubmit() {
    this.submitted = true;
    if (this.fournisseurForm.valid) {
      const nouveauFournisseur: Fournisseur = this.fournisseurForm.value;
      this.fournisseurService.addFournisseur(nouveauFournisseur).subscribe({
        next: (result) => {
          console.log('Fournisseur ajouté :', result);
          this.fournisseurForm.reset();
          this.submitted = false;
          // Optionnel : naviguer ou afficher un message de succès
        },
        error: (error) => {
          console.error('Erreur lors de l\'ajout du fournisseur :', error);
        }
      });
    } else {
      this.fournisseurForm.markAllAsTouched();
    }
  }
}
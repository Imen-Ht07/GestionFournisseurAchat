import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import { MainBackofficeComponent } from './main-backoffice/main-backoffice.component';
import { FournisseurComponent } from './fournisseur/fournisseur.component';
import { AddFournisseurComponent } from './add-fournisseur/add-fournisseur.component';
import { AddLigneAchatComponent } from './add-ligne-achat/add-ligne-achat.component';
import { ConsultCommandesComponent } from './consult-commandes/consult-commandes.component';

const routes: Routes = [
  {
    path: '',
    component: MainBackofficeComponent,
    children: [
      { path: '', component: DashboardComponent },
      { path: 'fournisseur', component: FournisseurComponent },
      { path: 'addfournisseur', component: AddFournisseurComponent },  
       { path: 'addligne', component:AddLigneAchatComponent  },  
        { path: 'commande', component:ConsultCommandesComponent },  

    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BackofficeRoutingModule { }

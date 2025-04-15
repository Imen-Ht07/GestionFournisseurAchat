import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
// Material Modules
import { MatSnackBarModule } from '@angular/material/snack-bar';

// Routing
import { BackofficeRoutingModule } from './backoffice-routing.module';

// Components
import { DashboardComponent } from './dashboard/dashboard.component';
import { MainBackofficeComponent } from './main-backoffice/main-backoffice.component';
import { BackofficeNavbarComponent } from './backoffice-navbar/backoffice-navbar.component';
import { BackofficeSidebarComponent } from './backoffice-sidebar/backoffice-sidebar.component';
import { BackofficeFooterComponent } from './backoffice-footer/backoffice-footer.component';


// Third-party modules
import { NgxPaginationModule } from 'ngx-pagination';
import { FournisseurComponent } from './fournisseur/fournisseur.component';
import { AddFournisseurComponent } from './add-fournisseur/add-fournisseur.component';
import { AddLigneAchatComponent } from './add-ligne-achat/add-ligne-achat.component';
import { ConsultCommandesComponent } from './consult-commandes/consult-commandes.component';
import { SignupComponent } from './signup/signup.component';
import { SigninComponent } from './signin/signin.component';

@NgModule({
  declarations: [
    DashboardComponent,
    MainBackofficeComponent,
    BackofficeNavbarComponent,
    BackofficeSidebarComponent,
    BackofficeFooterComponent,
    FournisseurComponent,
    AddFournisseurComponent,
    AddLigneAchatComponent,
    ConsultCommandesComponent,
    SigninComponent,
   // SignupComponent,
  
  ],
  imports: [
    CommonModule,
    BackofficeRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    NgxPaginationModule,
    MatSnackBarModule,
  ],

})
export class BackofficeModule { }

import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SignupComponent } from './backoffice/signup/signup.component';
import { SigninComponent } from './backoffice/signin/signin.component';
import { UpdateCommandeComponent } from './backoffice/update-commande/update-commande.component';

const routes: Routes = [
  { path: 'backoffice', loadChildren: () => import('./backoffice/backoffice.module').then(m => m.BackofficeModule) },
  { path: '', redirectTo: '/signin', pathMatch: 'full' },
   { path: 'signup', component: SignupComponent },
     { path: 'signin', component: SigninComponent },
      { path: 'updatecommande/:id', component: UpdateCommandeComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

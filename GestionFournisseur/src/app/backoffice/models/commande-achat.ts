import { Fournisseur } from "./fournisseur";
import { LigneCommandeAchat } from "./ligne-commande-achat";

export class CommandeAchat {
     id!: number;
 fournisseur?: Fournisseur; // ton objet fournisseur, à adapter
  date!: string;             // ou Date, mais string (format ISO) est recommandé pour l’API
  statut!: StatutCommande;
  montant!: number;
  //fournisseure?: Fournisseur; // attention à l’orthographe, à harmoniser côté Java&TS si possible !
  lignes?: LigneCommandeAchat[];
}

export type StatutCommande = 'EN_ATTENTE' | 'LIVREE' | 'ANNULEE'| 'EN_COURS'; 


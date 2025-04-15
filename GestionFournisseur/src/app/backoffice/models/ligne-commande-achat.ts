import { CommandeAchat } from "./commande-achat";

export class LigneCommandeAchat {
      id?: number;
  produit!: string;
  quantite!: number;
  prixUnitaire!: number;
  commande?: CommandeAchat;
}

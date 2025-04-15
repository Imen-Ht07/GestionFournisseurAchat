package com.assurance.assuranceback.Services.UserServices;

import com.assurance.assuranceback.Entity.UserEntity.Fournisseur;
import com.assurance.assuranceback.Entity.UserEntity.HistoriqueAchats;

import java.util.List;

public interface IHistoriqueAchatService {
    public List<HistoriqueAchats> retrieveallHistoriques();
    public HistoriqueAchats retrieveHistoriqueById(long id);
    public HistoriqueAchats addHistoriqueAchats(HistoriqueAchats historiqueAchats);
    public void removeHistoriqueAchats(long id);
    public HistoriqueAchats updateHistoriqueAchats(Long id, HistoriqueAchats historiqueAchats);
}

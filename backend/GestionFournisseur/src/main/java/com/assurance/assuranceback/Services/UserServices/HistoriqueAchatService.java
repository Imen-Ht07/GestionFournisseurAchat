package com.assurance.assuranceback.Services.UserServices;

import com.assurance.assuranceback.Entity.UserEntity.HistoriqueAchats;
import com.assurance.assuranceback.Repository.UserRepositories.HistoriqueAchatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoriqueAchatService implements IHistoriqueAchatService {
   @Autowired
    HistoriqueAchatRepository historiqueAchatRepository;

    @Override
    public List<HistoriqueAchats> retrieveallHistoriques() {
        return historiqueAchatRepository.findAll();
    }

    @Override
    public HistoriqueAchats retrieveHistoriqueById(long id) {
        return historiqueAchatRepository.findById(id).orElse(null);
    }

    @Override
    public HistoriqueAchats addHistoriqueAchats(HistoriqueAchats historiqueAchats) {
        return historiqueAchatRepository.save(historiqueAchats);
    }

    @Override
    public void removeHistoriqueAchats(long id) {
historiqueAchatRepository.deleteById(id);
    }

    @Override
    public HistoriqueAchats updateHistoriqueAchats(Long id, HistoriqueAchats historiqueAchats) {
        return null;
    }
}

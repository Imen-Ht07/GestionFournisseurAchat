package com.assurance.assuranceback.Controller.UserController;

import com.assurance.assuranceback.Entity.UserEntity.CommandeAchat;
import com.assurance.assuranceback.Entity.UserEntity.HistoriqueAchats;
import com.assurance.assuranceback.Services.UserServices.IHistoriqueAchatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/historiques")
@CrossOrigin(origins = "http://localhost:4200")
public class HistoriqueController {
    @Autowired
    IHistoriqueAchatService historiqueAchatService;

    @GetMapping
    public List<HistoriqueAchats> getAllHistoriques(@RequestParam(required = false) String search) {
        return historiqueAchatService.retrieveallHistoriques();
    }

    @GetMapping("/{id}")
    public HistoriqueAchats getHistoriqueById(@PathVariable Long id) {
        return historiqueAchatService.retrieveHistoriqueById(id);
    }

    @PostMapping
    public HistoriqueAchats createHistorique(@RequestBody HistoriqueAchats histAchat) {
        return historiqueAchatService.addHistoriqueAchats(histAchat);
    }

    @PutMapping("/{id}")
    public HistoriqueAchats updateHistorique(@PathVariable Long id, @RequestBody HistoriqueAchats updatedHist) {
        return historiqueAchatService.updateHistoriqueAchats(id, updatedHist);
    }

    @DeleteMapping("/{id}")
    public void deleteHistorique(@PathVariable Long id) {
        historiqueAchatService.removeHistoriqueAchats(id);
    }

}

package com.example.stationdeski.services;

import com.example.stationdeski.entities.Cours;
import com.example.stationdeski.entities.Inscription;
import com.example.stationdeski.entities.Skieur;
import com.example.stationdeski.entities.TypeCours;
import com.example.stationdeski.repositories.CoursRepository;
import com.example.stationdeski.repositories.InscriptionRepository;
import com.example.stationdeski.repositories.SkieurRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class InscriptionService implements IinscriptonService{

    InscriptionRepository inscriptionRepository;
    CoursRepository coursRepository;
    SkieurRepository skieurRepository;

    @Override
    public List<Inscription> retrieveAllInscription() {
        return inscriptionRepository.findAll();
    }

    @Override
    public Inscription addInscription(Inscription i) {
        inscriptionRepository.save(i);
        return i;
    }

    @Override
    public Inscription updateInscription(Inscription i) {
        inscriptionRepository.save(i);
        return i;
    }

    @Override
    public Inscription retrieveInscription(Integer idInscription) {
       return inscriptionRepository.findById(idInscription).get();
    }

    @Override
    public void deleteInscription(Integer idInscription) {
        inscriptionRepository.deleteById(idInscription);

    }

    @Transactional
    public Inscription assignInscriptionToCours(Long numInscription, Long numCours) {
        Inscription ins=inscriptionRepository.GetInsByNum(String.valueOf(numInscription));
        Cours c=coursRepository.getCoursByNum(numCours);
        Set<Inscription> inscriptions= c.getInscriptions();
        for (Inscription inss:inscriptions) {
            inss.setCours(c);

        }
        return ins;
    }

    @Override
    public Inscription addInscriptionAndAssignToSkieurAndCours(Inscription inscription, Long numSkieur, Long numCours) {
        Cours c = coursRepository.getCoursByNum(numCours);
        Skieur s = skieurRepository.GetSkieurByNum(numSkieur);
        Period period=Period.between(s.getDateNaissance(),LocalDate.now());
        int finalDate=period.getYears();
        Long nb=inscriptionRepository.countByCours(c);

        if ((finalDate < 12)&&(finalDate>5 ) &&(c.getTypeCours().equals(TypeCours.COLLECTIF_ENFANT))||
                ( finalDate < 35)&&(finalDate>20)&&(c.getTypeCours().equals(TypeCours.COLLECTIF_ADULTE))){
                if(nb>=6) {
                    inscriptionRepository.save(inscription);
                    inscription.setCours(c);
                    inscription.setSkieur(s);
                }
            }
            return inscription;
        }
}

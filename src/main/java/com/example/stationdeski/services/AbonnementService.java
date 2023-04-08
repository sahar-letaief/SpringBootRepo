package com.example.stationdeski.services;

import com.example.stationdeski.entities.Abonnement;
import com.example.stationdeski.entities.Skieur;
import com.example.stationdeski.entities.typeAbonnement;
import com.example.stationdeski.repositories.AbonnementRepository;
import com.example.stationdeski.repositories.SkieurRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;


@Service
@AllArgsConstructor
@Slf4j
public class AbonnementService implements IAbonnementService{

    AbonnementRepository abonnementRepository;
    SkieurRepository skieurRepository;

    @Override
    public List<Abonnement> retrieveAllAbonnements() {
        return abonnementRepository.findAll();
    }

    @Override
    public Abonnement addAbonnement(Abonnement a) {
        abonnementRepository.save(a);
        return a;
    }

    @Override
    public Abonnement updateAbonnement(Abonnement a) {
        abonnementRepository.save(a);
        return a;
    }

    @Override
    public Abonnement retrieveAbonnement(Integer idAbonnement) {
       return abonnementRepository.findById(idAbonnement).get();

    }

    @Override
    public void deleteAbonnement(Integer idAbonnement) {
        abonnementRepository.deleteById(idAbonnement);

    }

    @Override
    public Set<Abonnement> getAbonnementByType(typeAbonnement type) {
       Set<Abonnement> ab=abonnementRepository.getAbonByType(type);
       return ab;
    }

    @Override
    public List<Abonnement> retrieveAbonnementsByDates(LocalDate startDate, LocalDate endDate) {
        return abonnementRepository.findAbonnementByDateDebutBetween(startDate,endDate);
    }

    @Override
    @Scheduled(cron = "*/15 * * * * *")
    public void retrieveSubscriptions() {
        LocalDate beforedate=LocalDate.now().plusDays(7);
        List<Abonnement> listab=abonnementRepository.findAbonnementByDateFinBefore(beforedate);
        for (Abonnement a:listab) {
            Skieur s=skieurRepository.findbyIdAbon(a.getIdAbonnement());
            System.out.println("Skieur " +s.getNomS() + " " + s.getPrenomS() + " Num Skieur " + s.getNumSkieur()+
                    "Abonnement"+a.getNumAbon());
            log.info("Skieur " +s.getNomS() + " " + s.getPrenomS() + " Num Skieur " + s.getNumSkieur()+
                    "Abonnement"+a.getNumAbon());
        }


    }

    @Override
    @Scheduled(cron = "0 0 0 */1 * *")
    public void showMonthlyRecurringRevenue() {
        List<Abonnement> listab=abonnementRepository.findAll();
        float mmr=0;
        for (Abonnement a:listab
             )
            if(a.getTypeAbon().equals("MENSUEL")){
                mmr+=a.getPrixAbon();
            }
        log.info("les prix des abonnements mensuels sont "+mmr);
        System.out.println("les prix des abonnements mensuels sont "+mmr);
    }


}

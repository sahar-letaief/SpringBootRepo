package tn.esprit.spring.stationskibatch.batch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;
import tn.esprit.spring.stationskibatch.entities.Abonnement;
import tn.esprit.spring.stationskibatch.entities.Skieur;
import tn.esprit.spring.stationskibatch.entities.TypeAbonnement;
import tn.esprit.spring.stationskibatch.repositories.SkieurRepository;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@Component
public class SkieurProcessor implements ItemProcessor<Skieur, Skieur> {

	SkieurRepository skieurRepository;
	/*12. logique métier de notre job*/
	@Override
	public Skieur process(Skieur skieur) {


		// récupérer la date début d'abonnement relative à la date du jour
		//LocalDate dateDebutAbonnement = LocalDate.now();
		// calculer par défaut la date fin pour un abonnement mensuel
		//LocalDate dateFinAbonnement = LocalDate.now().plusMonths(1);
		// affecter par défaut le prix d'abonnement pour un abonnement mensuel

		Long numAbonnement = ThreadLocalRandom.current().nextLong(1000000); // numéro abonnement généré automatiquement

		// calculer la date fin  et affecter  le prix d'abonnement
		// pour les deux autres types d'abonnement

		switch (skieur.getTypeAbon()) {

			case "ANNUEL":
				LocalDate dateDebutAbonnement = LocalDate.now();
				LocalDate dateFinAbonnement = LocalDate.now().plusMonths(12);
				Float prixAbon = 600F;
				Abonnement ab=new Abonnement(0,numAbonnement,dateDebutAbonnement,dateFinAbonnement,prixAbon,TypeAbonnement.ANNUEL);
				Abonnement.builder().build();
				skieur.setAbonnement(ab);

				break;
			case "SEMESTRIEL":
				dateDebutAbonnement = LocalDate.now();
				dateFinAbonnement = LocalDate.now().plusMonths(5);
				prixAbon = 300F;
				Abonnement ab2=new Abonnement(0,numAbonnement,dateDebutAbonnement,dateFinAbonnement,prixAbon,TypeAbonnement.ANNUEL);
				Abonnement.builder().build();
				skieur.setAbonnement(ab2);
			case "MENSUEL":
				 dateDebutAbonnement = LocalDate.now();
				 dateFinAbonnement = LocalDate.now().plusMonths(1);
				prixAbon = 60F;
				Abonnement ab3=new Abonnement(0,numAbonnement,dateDebutAbonnement,dateFinAbonnement,prixAbon,TypeAbonnement.ANNUEL);
				Abonnement.builder().build();
				skieur.setAbonnement(ab3);
				break;
		}

		//TODO 6
		return skieur;
	}
}

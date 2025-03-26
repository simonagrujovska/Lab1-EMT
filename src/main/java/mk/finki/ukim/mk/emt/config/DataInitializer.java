package mk.finki.ukim.mk.emt.config;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.emt.model.domain.Accommodation;
import mk.finki.ukim.mk.emt.model.domain.Country;
import mk.finki.ukim.mk.emt.model.domain.Host;
import mk.finki.ukim.mk.emt.model.enumeration.CategoryEnum;
import mk.finki.ukim.mk.emt.repository.AccommodationRepository;
import mk.finki.ukim.mk.emt.repository.CountryRepository;
import mk.finki.ukim.mk.emt.repository.HostRepository;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    private final AccommodationRepository accommodationRepository;
    private final CountryRepository countryRepository;
    private final HostRepository hostRepository;

    public DataInitializer(AccommodationRepository accommodationRepository, CountryRepository countryRepository, HostRepository hostRepository) {
        this.accommodationRepository = accommodationRepository;
        this.countryRepository = countryRepository;
        this.hostRepository = hostRepository;
    }

    @PostConstruct
    public void init() {

        Country country1 = new Country("Macedonia", "Europe");
        Country country2 = new Country("France", "Europe");
        Country country3 = new Country("Japan", "Asia");
        this.countryRepository.save(country1);
        this.countryRepository.save(country2);
        this.countryRepository.save(country3);

        Host host1 = new Host("Simona", "Grujovska", country1);
        Host host2 = new Host("Matea", "Manova", country2);
        Host host3 = new Host("Oto", "Hoyo", country3);
        this.hostRepository.save(host1);
        this.hostRepository.save(host2);
        this.hostRepository.save(host3);

        Accommodation accommodation1 = new Accommodation("Hotel Simona", CategoryEnum.HOTEL, host1, 13);
        Accommodation accommodation2 = new Accommodation("Motel Matea", CategoryEnum.MOTEL, host2, 7);
        Accommodation accommodation3 = new Accommodation("Flat Japan", CategoryEnum.FLAT, host3, 1);
        this.accommodationRepository.save(accommodation1);
        this.accommodationRepository.save(accommodation2);
        this.accommodationRepository.save(accommodation3);

    }

}

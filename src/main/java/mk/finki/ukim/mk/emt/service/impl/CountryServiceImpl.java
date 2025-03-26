package mk.finki.ukim.mk.emt.service.impl;

import mk.finki.ukim.mk.emt.model.domain.Country;
import mk.finki.ukim.mk.emt.repository.CountryRepository;
import mk.finki.ukim.mk.emt.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> save(Country country) {
        return Optional.of(countryRepository.save(country));
    }

    @Override
    public Optional<Country> update(Long id, Country country) {
        return countryRepository.findById(id).map(existingCategory -> {
            if (country.getName() != null) {
                existingCategory.setName(country.getName());
            }
            return countryRepository.save(existingCategory);
        });
    }

    @Override
    public void deleteById(Long id) {
        countryRepository.deleteById(id);
    }
}

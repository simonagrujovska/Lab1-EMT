package mk.finki.ukim.mk.emt.service;

import mk.finki.ukim.mk.emt.model.domain.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {

    List<Country> findAll();

    Optional<Country> save(Country country);

    Optional<Country> update(Long id, Country country);

    void deleteById(Long id);
}

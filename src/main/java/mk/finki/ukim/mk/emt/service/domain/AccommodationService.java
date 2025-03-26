package mk.finki.ukim.mk.emt.service.domain;

import mk.finki.ukim.mk.emt.model.domain.Accommodation;

import java.util.List;
import java.util.Optional;

import java.util.List;
import java.util.Optional;

public interface AccommodationService {

    List<Accommodation> findAll();

    Optional<Accommodation> save(Accommodation accommodation);

    Optional<Accommodation> findById(Long id);

    Optional<Accommodation> update(Long id, Accommodation accommodation);

    void deleteById(Long id);

}
package mk.finki.ukim.mk.emt.service.application;

import mk.finki.ukim.mk.emt.dto.CreateCountryDto;
import mk.finki.ukim.mk.emt.dto.DisplayCountryDto;

import java.util.List;
import java.util.Optional;

public interface CountryApplicationService {

    List<DisplayCountryDto> findAll();

    Optional<DisplayCountryDto> save(CreateCountryDto createCountryDto);

    Optional<DisplayCountryDto> findById(Long id);

    Optional<DisplayCountryDto> update(Long id, CreateCountryDto createCountryDto);

    void deleteById(Long id);

}
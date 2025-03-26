package mk.finki.ukim.mk.emt.service.application.impl;

import mk.finki.ukim.mk.emt.dto.CreateCountryDto;
import mk.finki.ukim.mk.emt.dto.DisplayCountryDto;
import mk.finki.ukim.mk.emt.service.application.CountryApplicationService;
import mk.finki.ukim.mk.emt.service.domain.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryApplicationServiceImpl implements CountryApplicationService {

    private final CountryService countryService;

    public CountryApplicationServiceImpl(CountryService countryService) {
        this.countryService = countryService;
    }

    @Override
    public List<DisplayCountryDto> findAll() {
        return DisplayCountryDto.from(this.countryService.findAll());
    }

    @Override
    public Optional<DisplayCountryDto> save(CreateCountryDto createCountryDto) {
        return this.countryService.save(createCountryDto.toCountry()).map(DisplayCountryDto::from);
    }

    @Override
    public Optional<DisplayCountryDto> findById(Long id) {
        return this.countryService.findById(id).map(DisplayCountryDto::from);
    }

    @Override
    public Optional<DisplayCountryDto> update(Long id, CreateCountryDto createCountryDto) {
        return this.countryService.update(id, createCountryDto.toCountry()).map(DisplayCountryDto::from);
    }

    @Override
    public void deleteById(Long id) {
        this.countryService.deleteById(id);
    }
}
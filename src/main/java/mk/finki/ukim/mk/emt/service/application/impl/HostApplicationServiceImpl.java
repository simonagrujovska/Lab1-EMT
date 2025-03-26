package mk.finki.ukim.mk.emt.service.application.impl;

import mk.finki.ukim.mk.emt.dto.CreateHostDto;
import mk.finki.ukim.mk.emt.dto.DisplayHostDto;
import mk.finki.ukim.mk.emt.model.domain.Country;
import mk.finki.ukim.mk.emt.service.application.HostApplicationService;
import mk.finki.ukim.mk.emt.service.domain.CountryService;
import mk.finki.ukim.mk.emt.service.domain.HostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HostApplicationServiceImpl implements HostApplicationService {

    private final HostService hostService;
    private final CountryService countryService;

    public HostApplicationServiceImpl(HostService hostService, CountryService countryService) {
        this.hostService = hostService;
        this.countryService = countryService;
    }

    @Override
    public Optional<DisplayHostDto> update(Long id, CreateHostDto createHostDto) {
        Optional<Country> country = this.countryService.findById(createHostDto.countryId());

        return this.hostService.update(id,
                createHostDto.toHost(
                        country.orElse(null)
                )
        ).map(DisplayHostDto::from);
    }

    @Override
    public Optional<DisplayHostDto> save(CreateHostDto createHostDto) {
        Optional<Country> country = this.countryService.findById(createHostDto.countryId());

        if (country.isPresent()) {
            return this.hostService.save(createHostDto.toHost(country.get())).map(DisplayHostDto::from);
        }
        return Optional.empty();
    }

    @Override
    public Optional<DisplayHostDto> findById(Long id) {
        return this.hostService.findById(id).map(DisplayHostDto::from);
    }

    @Override
    public List<DisplayHostDto> findAll() {
        return this.hostService.findAll().stream().map(DisplayHostDto::from).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        this.hostService.deleteById(id);
    }
}

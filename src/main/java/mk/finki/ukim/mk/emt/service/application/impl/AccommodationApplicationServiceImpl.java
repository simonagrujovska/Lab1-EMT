package mk.finki.ukim.mk.emt.service.application.impl;

import mk.finki.ukim.mk.emt.dto.CreateAccommodationDto;
import mk.finki.ukim.mk.emt.dto.DisplayAccommodationDto;
import mk.finki.ukim.mk.emt.model.domain.Host;
import mk.finki.ukim.mk.emt.service.application.AccommodationApplicationService;
import mk.finki.ukim.mk.emt.service.domain.AccommodationService;
import mk.finki.ukim.mk.emt.service.domain.HostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccommodationApplicationServiceImpl implements AccommodationApplicationService {

    private final AccommodationService accommodationService;
    private final HostService hostService;

    public AccommodationApplicationServiceImpl(AccommodationService accommodationService, HostService hostService) {
        this.accommodationService = accommodationService;
        this.hostService = hostService;
    }

    @Override
    public Optional<DisplayAccommodationDto> update(Long id, CreateAccommodationDto createAccommodationDto) {
        Optional<Host> host = this.hostService.findById(createAccommodationDto.hostId());

        return this.accommodationService.update(id,
                createAccommodationDto.toAccommodation(
                        host.orElse(null)
                )
        ).map(DisplayAccommodationDto::from);
    }

    @Override
    public Optional<DisplayAccommodationDto> save(CreateAccommodationDto createAccommodationDto) {
        Optional<Host> host = this.hostService.findById(createAccommodationDto.hostId());

        if (host.isPresent()) {
            return this.accommodationService.save(createAccommodationDto.toAccommodation(host.get())).map(DisplayAccommodationDto::from);
        }
        return Optional.empty();
    }

    @Override
    public Optional<DisplayAccommodationDto> findById(Long id) {
        return this.accommodationService.findById(id).map(DisplayAccommodationDto::from);
    }

    @Override
    public List<DisplayAccommodationDto> findAll() {
        return this.accommodationService.findAll().stream().map(DisplayAccommodationDto::from).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        this.accommodationService.deleteById(id);
    }
}

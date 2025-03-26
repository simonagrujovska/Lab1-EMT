package mk.finki.ukim.mk.emt.service.application;

import mk.finki.ukim.mk.emt.dto.CreateAccommodationDto;
import mk.finki.ukim.mk.emt.dto.DisplayAccommodationDto;

import java.util.List;
import java.util.Optional;

public interface AccommodationApplicationService {

    Optional<DisplayAccommodationDto> update(Long id, CreateAccommodationDto createAccommodationDto);

    Optional<DisplayAccommodationDto> save(CreateAccommodationDto createAccommodationDto);

    Optional<DisplayAccommodationDto> findById(Long id);

    List<DisplayAccommodationDto> findAll();

    void deleteById(Long id);

}

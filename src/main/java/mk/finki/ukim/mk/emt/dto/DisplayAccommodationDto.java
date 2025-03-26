package mk.finki.ukim.mk.emt.dto;

import mk.finki.ukim.mk.emt.model.domain.Accommodation;
import mk.finki.ukim.mk.emt.model.domain.Host;
import mk.finki.ukim.mk.emt.model.enumeration.CategoryEnum;

import java.util.List;
import java.util.stream.Collectors;

public record DisplayAccommodationDto(Long id, String name, CategoryEnum category, Long hostId,
                                      Integer numRooms) {

    public static DisplayAccommodationDto from(Accommodation accommodation) {
        return new DisplayAccommodationDto(accommodation.getId(), accommodation.getName(), accommodation.getCategory(), accommodation.getHost().getId(), accommodation.getNumRooms());
    }

    public static List<DisplayAccommodationDto> from(List<Accommodation> accommodations) {
        return accommodations.stream().map(DisplayAccommodationDto::from).collect(Collectors.toList());
    }

    public Accommodation toAccommodation(Host host) {
        return new Accommodation(name, category, host, numRooms);
    }

}

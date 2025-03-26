package mk.finki.ukim.mk.emt.dto;

import mk.finki.ukim.mk.emt.model.domain.Accommodation;
import mk.finki.ukim.mk.emt.model.domain.Host;
import mk.finki.ukim.mk.emt.model.enumeration.CategoryEnum;
import java.util.List;
import java.util.stream.Collectors;

public record CreateAccommodationDto(String name, CategoryEnum category, Long hostId, Integer numRooms) {

    public static CreateAccommodationDto from(Accommodation accommodation) {
        return new CreateAccommodationDto(accommodation.getName(), accommodation.getCategory(), accommodation.getHost().getId(), accommodation.getNumRooms());
    }

    public static List<CreateAccommodationDto> from(List<Accommodation> accommodations) {
        return accommodations.stream().map(CreateAccommodationDto::from).collect(Collectors.toList());
    }

    public Accommodation toAccommodation(Host host) {
        return new Accommodation(name, category, host, numRooms);
    }

}

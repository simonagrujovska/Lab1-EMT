package mk.finki.ukim.mk.emt.dto;

import mk.finki.ukim.mk.emt.model.domain.Country;
import mk.finki.ukim.mk.emt.model.domain.Host;

import java.util.List;
import java.util.stream.Collectors;

public record CreateHostDto(String name, String surname, Long countryId) {

    public static CreateHostDto from(Host host) {
        return new CreateHostDto(host.getName(), host.getSurname(), host.getCountry().getId());
    }

    public static List<CreateHostDto> from(List<Host> hosts) {
        return hosts.stream().map(CreateHostDto::from).collect(Collectors.toList());
    }

    public Host toHost(Country country) {
        return new Host(name, surname, country);
    }

}
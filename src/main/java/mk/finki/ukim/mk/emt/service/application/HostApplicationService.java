package mk.finki.ukim.mk.emt.service.application;

import  mk.finki.ukim.mk.emt.dto.CreateHostDto;
import  mk.finki.ukim.mk.emt.dto.DisplayHostDto;

import java.util.List;
import java.util.Optional;

public interface HostApplicationService {

    Optional<DisplayHostDto> update(Long id, CreateHostDto createHostDto);

    Optional<DisplayHostDto> save(CreateHostDto createHostDto);

    Optional<DisplayHostDto> findById(Long id);

    List<DisplayHostDto> findAll();

    void deleteById(Long id);

}
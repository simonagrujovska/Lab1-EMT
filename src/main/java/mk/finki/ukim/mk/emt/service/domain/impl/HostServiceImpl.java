package mk.finki.ukim.mk.emt.service.domain.impl;


import mk.finki.ukim.mk.emt.model.domain.Host;
import mk.finki.ukim.mk.emt.repository.HostRepository;
import mk.finki.ukim.mk.emt.service.domain.CountryService;
import mk.finki.ukim.mk.emt.service.domain.HostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HostServiceImpl implements HostService {

    private final CountryService countryService;
    private final HostRepository hostRepository;

    public HostServiceImpl(CountryService countryService, HostRepository hostRepository) {
        this.countryService = countryService;
        this.hostRepository = hostRepository;
    }

    @Override
    public List<Host> findAll() {
        return this.hostRepository.findAll();
    }

    @Override
    public Optional<Host> save(Host host) {
        if (host.getCountry() != null &&
                this.countryService.findById(host.getCountry().getId()).isPresent()) {
            return Optional.of(hostRepository.save(new Host(
                    host.getName(),
                    host.getSurname(),
                    this.countryService.findById(host.getCountry().getId()).get()
            )));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Host> findById(Long id) {
        return this.hostRepository.findById(id);
    }

    @Override
    public Optional<Host> update(Long id, Host host) {
        return this.hostRepository.findById(id).map(existingHost -> {
            if (host.getName() != null) {
                existingHost.setName(host.getName());
            }
            if (host.getSurname() != null) {
                existingHost.setSurname(host.getSurname());
            }
            if (host.getCountry() != null && this.countryService.findById(host.getCountry().getId()).isPresent()) {
                existingHost.setCountry(this.countryService.findById(host.getCountry().getId()).get());
            }
            return this.hostRepository.save(existingHost);
        });
    }

    @Override
    public void deleteById(Long id) {
        this.hostRepository.deleteById(id);
    }
}
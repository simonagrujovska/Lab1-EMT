package mk.finki.ukim.mk.emt.service.impl;


import mk.finki.ukim.mk.emt.model.domain.Host;
import mk.finki.ukim.mk.emt.repository.HostRepository;
import mk.finki.ukim.mk.emt.service.HostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HostServiceImpl implements HostService {

    private final HostRepository hostRepository;

    public HostServiceImpl(HostRepository hostRepository) {
        this.hostRepository = hostRepository;
    }

    @Override
    public List<Host> findAll() {
        return hostRepository.findAll();
    }

    @Override
    public Optional<Host> save(Host host) {
        return Optional.of(hostRepository.save(host));
    }

    @Override
    public Optional<Host> update(Long id, Host host) {
        return hostRepository.findById(id).map(existingCategory -> {
            if (host.getName() != null) {
                existingCategory.setName(host.getName());
            }
            return hostRepository.save(existingCategory);
        });
    }

    @Override
    public void deleteById(Long id) {
        hostRepository.deleteById(id);
    }
}
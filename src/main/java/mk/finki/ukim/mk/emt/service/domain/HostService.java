package mk.finki.ukim.mk.emt.service.domain;

import mk.finki.ukim.mk.emt.model.domain.Host;

import java.util.List;
import java.util.Optional;

public interface HostService {

    List<Host> findAll();

    Optional<Host> save(Host host);

    Optional<Host> findById(Long id);

    Optional<Host> update(Long id, Host host);

    void deleteById(Long id);

}

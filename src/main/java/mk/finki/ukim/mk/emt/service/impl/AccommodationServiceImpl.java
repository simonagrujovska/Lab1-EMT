package mk.finki.ukim.mk.emt.service.impl;

import mk.finki.ukim.mk.emt.model.domain.Accommodation;
import mk.finki.ukim.mk.emt.repository.AccommodationRepository;
import mk.finki.ukim.mk.emt.service.AccommodationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccommodationServiceImpl implements AccommodationService {

    private final AccommodationRepository accommodationRepository;

    public AccommodationServiceImpl(AccommodationRepository accommodationRepository) {
        this.accommodationRepository = accommodationRepository;
    }

    @Override
    public List<Accommodation> findAll() {
        return accommodationRepository.findAll();
    }

    @Override
    public Optional<Accommodation> findById(Long id) {
        return accommodationRepository.findById(id);
    }


    @Override
    public Optional<Accommodation> save(Accommodation accommodation) {
        return Optional.of(accommodationRepository.save(accommodation));
    }

    @Override
    public Optional<Accommodation> update(Long id, Accommodation accommodation) {
        return accommodationRepository.findById(id).map(existingAccommodation -> {
            // Aжурирање на вредностите ако не се null
            if (accommodation.getName() != null) {
                existingAccommodation.setName(accommodation.getName());
            }
            if (accommodation.getCategory() != null) {
                existingAccommodation.setCategory(accommodation.getCategory());
            }
            if (accommodation.getNumRooms() > 0) {
                existingAccommodation.setNumRooms(accommodation.getNumRooms());
            }

            // Ќе ја обновиме верзијата
            return accommodationRepository.save(existingAccommodation);
        });
    }
    @Override
    public void deleteById(Long id) {
        accommodationRepository.deleteById(id);
    }
    public Accommodation markAsRented(Long id) {
        Optional<Accommodation> accommodation = accommodationRepository.findById(id);
        if (accommodation.isPresent()) {
            accommodation.get().setRented(true);
            return accommodationRepository.save(accommodation.get());
        }
        return null;
    }
}

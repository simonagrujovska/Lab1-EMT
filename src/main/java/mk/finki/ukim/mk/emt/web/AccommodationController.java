package mk.finki.ukim.mk.emt.web;

import mk.finki.ukim.mk.emt.model.domain.Accommodation;
import mk.finki.ukim.mk.emt.service.AccommodationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/accommodations")

public class AccommodationController {

    private final AccommodationService accommodationService;

    public AccommodationController(AccommodationService accommodationService) {
        this.accommodationService = accommodationService;
    }


    @GetMapping
    public List<Accommodation> findAll() {
        return accommodationService.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Accommodation> findById(@PathVariable Long id) {
        Optional<Accommodation> accommodation = accommodationService.findById(id);
        return accommodation.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping("/add")
    public ResponseEntity<Accommodation> save(@RequestBody Accommodation accommodation) {
        Optional<Accommodation> savedAccommodation = accommodationService.save(accommodation);
        return savedAccommodation.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
    }


    @PutMapping("/edit/{id}")
    public ResponseEntity<Accommodation> update(@PathVariable Long id, @RequestBody Accommodation accommodation) {
        Optional<Accommodation> updatedAccommodation = accommodationService.update(id, accommodation);
        return updatedAccommodation.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        if (accommodationService.findById(id).isPresent()) {
            accommodationService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/rent/{id}")
    public ResponseEntity<Accommodation> markAsRented(@PathVariable Long id) {
        Optional<Accommodation> rentedAccommodation = Optional.ofNullable(accommodationService.markAsRented(id));
        return rentedAccommodation.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}

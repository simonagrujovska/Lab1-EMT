package mk.finki.ukim.mk.emt.web;

import io.swagger.v3.oas.annotations.tags.Tag;
import mk.finki.ukim.mk.emt.dto.CreateCountryDto;
import mk.finki.ukim.mk.emt.dto.DisplayCountryDto;
import mk.finki.ukim.mk.emt.service.application.CountryApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
@Tag(name = "Country API", description = "Endpoints for managing host countries")
public class CountryController {

    private final CountryApplicationService countryApplicationService;

    public CountryController(CountryApplicationService countryApplicationService) {
        this.countryApplicationService = countryApplicationService;
    }

    @GetMapping
    public List<DisplayCountryDto> findAll() {
        return this.countryApplicationService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisplayCountryDto> findById(@PathVariable Long id) {
        return this.countryApplicationService.findById(id)
                .map(country -> ResponseEntity.ok().body(country))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<DisplayCountryDto> save(@RequestBody CreateCountryDto createCountryDto) {
        return this.countryApplicationService.save(createCountryDto)
                .map(country -> ResponseEntity.ok().body(country))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<DisplayCountryDto> update(@PathVariable Long id, @RequestBody CreateCountryDto createCountryDto) {
        return this.countryApplicationService.update(id, createCountryDto)
                .map(country -> ResponseEntity.ok().body(country))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (this.countryApplicationService.findById(id).isPresent()) {
            this.countryApplicationService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

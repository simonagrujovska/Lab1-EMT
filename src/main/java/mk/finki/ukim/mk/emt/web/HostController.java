package mk.finki.ukim.mk.emt.web;

import io.swagger.v3.oas.annotations.tags.Tag;
import mk.finki.ukim.mk.emt.dto.CreateHostDto;
import mk.finki.ukim.mk.emt.dto.DisplayHostDto;
import mk.finki.ukim.mk.emt.service.application.HostApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hosts")
@Tag(name = "Host API", description = "Endpoints for managing accommodation hosts")
public class HostController {

    private final HostApplicationService hostApplicationService;

    public HostController(HostApplicationService hostApplicationService) {
        this.hostApplicationService = hostApplicationService;
    }

    @GetMapping
    public List<DisplayHostDto> findAll() {
        return this.hostApplicationService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisplayHostDto> findById(@PathVariable Long id) {
        return this.hostApplicationService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<DisplayHostDto> save(@RequestBody CreateHostDto createHostDto) {
        return this.hostApplicationService.save(createHostDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<DisplayHostDto> update(@PathVariable Long id, @RequestBody CreateHostDto createHostDto) {
        return this.hostApplicationService.update(id, createHostDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        if (this.hostApplicationService.findById(id).isPresent()) {
            this.hostApplicationService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

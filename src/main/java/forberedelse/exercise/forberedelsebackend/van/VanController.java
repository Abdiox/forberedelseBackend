package forberedelse.exercise.forberedelsebackend.van;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/van")
public class VanController {
    private final VanService vanService;

    public VanController(VanService vanService) {
        this.vanService = vanService;
    }

   @GetMapping
    public List<Van> getAllVans() {
        return vanService.getAllVans();
    }

    @GetMapping("/id/{id}")
    public Optional<Van> getVanById(@PathVariable int id) {
        return vanService.getVanById(id);
    }

    @PostMapping
    public Van addVan(@RequestBody Van van) {
        return vanService.addVan(van);
    }

    @PutMapping("/id/{id}")
    public Van editVan(@RequestBody Van van, @PathVariable int id) {
        return vanService.editVan(van, id);
    }

    @DeleteMapping("/id/{id}")
    public void deleteVan(@PathVariable int id) {
        vanService.deleteVan(id);
    }
}

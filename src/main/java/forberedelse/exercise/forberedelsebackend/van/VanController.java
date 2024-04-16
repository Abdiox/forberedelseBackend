package forberedelse.exercise.forberedelsebackend.van;

import forberedelse.exercise.forberedelsebackend.delivery.Delivery;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/vans/")
public class VanController {
    private final VanService vanService;

    public VanController(VanService vanService) {
        this.vanService = vanService;
    }

   @GetMapping
    public List<Van> getAllVans() {
        return vanService.getAllVans();
    }

    @GetMapping("{id}")
    public Optional<Van> getVanById(@PathVariable int id) {
        return vanService.getVanById(id);
    }

    @PostMapping
    public Van addVan(@RequestBody Van van) {
        return vanService.addVan(van);
    }

    @PutMapping("{id}")
    public Van editVan(@RequestBody Van van, @PathVariable int id) {
        return vanService.editVan(van, id);
    }

    @DeleteMapping("/id/{id}")
    public void deleteVan(@PathVariable int id) {
        vanService.deleteVan(id);
    }

   // @PostMapping("{id}/deliveries")
   // public ResponseEntity<Van> addDeliveryToVan(@PathVariable Long id, @RequestBody Delivery delivery) {
     //   Van van = vanService.getVanById(id)
       //         .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Van not found with id: " + id));

        //if (vanService.addDeliveryToVan(delivery, van)) {
          //  return ResponseEntity.ok(van);
        //} else {
          //  return ResponseEntity.badRequest().body("Unable to add delivery: van may be full or other constraints failed.");
       // }
    }


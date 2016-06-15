package insuliseweb;

import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/insulise")
public class InsuliseEntryController {

    @Resource
    InsuliseEntryRepository repository;

    @SneakyThrows
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<? extends InsuliseEntry> history() {
        return repository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addHistoryLog(@RequestBody InsuliseEntry entry) {
        repository.save(entry);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") String id) {
        repository.delete(id);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteAll() {
        repository.deleteAll();
    }
}

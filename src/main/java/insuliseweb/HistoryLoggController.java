package insuliseweb;

import lombok.SneakyThrows;
import org.apache.solr.client.solrj.SolrClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/history")
public class HistoryLoggController {

    @Autowired
    private SolrClient solrServer;

    @Resource
    HistoryLoggRepository repository;

    @SneakyThrows
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<HistoryLogg> history() {

        return repository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addHistoryLog(@RequestBody HistoryLogg loggEntry) {
        repository.save(loggEntry);
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

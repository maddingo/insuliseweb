package insuliseweb;

import org.springframework.data.solr.repository.SolrCrudRepository;

public interface HistoryLoggRepository extends SolrCrudRepository<HistoryLogg, String> {

}

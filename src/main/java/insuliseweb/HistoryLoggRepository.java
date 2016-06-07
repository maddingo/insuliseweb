package insuliseweb;

import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

public interface HistoryLoggRepository extends ElasticsearchCrudRepository<HistoryLogg, String> {

}

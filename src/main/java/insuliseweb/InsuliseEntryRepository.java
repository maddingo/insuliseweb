package insuliseweb;

import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

public interface InsuliseEntryRepository extends ElasticsearchCrudRepository<InsuliseEntry, String> {
}

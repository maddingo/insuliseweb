package insuliseweb;

import lombok.SneakyThrows;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.params.SolrParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;

@RestController
public class HistoryLoggController {

    @Autowired
    private SolrClient solrServer;

    @SneakyThrows
    @RequestMapping("/history")
    public Collection<HistoryLogg> history() {

        SolrParams query = new SolrQuery("*:*");
        QueryResponse resp = solrServer.query(query);
        return Collections.emptyList();
    }
}

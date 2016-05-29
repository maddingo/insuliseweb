package insuliseweb;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.util.Date;

@Data
@SolrDocument
public class HistoryLogg {
    private String id;
    private Date loggDate;
    private String message;
    private Double bloodSugar;
    private Double carbs;
}

package insuliseweb;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

@Data
@Document(indexName = "history", type = "history")
public class HistoryLogg {
    private String id;
    private Date loggDate;
    private String message;
    private Double bloodSugar;
    private Double carbs;
}

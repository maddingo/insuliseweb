package insuliseweb;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

@Document(indexName = "insulise", type = "insulise")
@Data
public class InsuliseEntry {

    public enum EntryType {
        BS,
        CARB,
        INSULIN_BASAL,
        INSULIN_BOLUS
    }

    @Id
    private String id;

    @Field
    private java.util.Date timestamp;

    private String message;

    private Double value;

    private EntryType type;
}

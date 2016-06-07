package insuliseweb;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class RestTest {
    @Autowired
    HistoryLoggRepository repository;

    @Test
    public void checkSolrQuery() {

        HistoryLogg logg = new HistoryLogg();
        logg.setId("1");
        logg.setBloodSugar(6.0);
        logg.setCarbs(45.0);
        logg.setLoggDate(new java.util.Date());
        repository.save(logg);

        assertThat(repository.findAll(), hasItem(notNullValue()));
    }
}

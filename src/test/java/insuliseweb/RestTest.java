package insuliseweb;

import mockit.Tested;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
@PropertySource("classpath:application.properties")
public class RestTest {
    @Autowired @Tested
    InsuliseEntryRepository repository;

    @After
    public void cleanup() {
        repository.deleteAll();
    }

    @Before
    public void addEntry() {
        InsuliseEntry entry1 = new InsuliseEntry();
        entry1.setId("1");
        entry1.setValue(6.0);
        entry1.setType(InsuliseEntry.EntryType.BS);
        entry1.setTimestamp(new java.util.Date());
        repository.save(entry1);

        InsuliseEntry entry2 = new InsuliseEntry();
        entry2.setId("1");
        entry2.setValue(60.0);
        entry2.setType(InsuliseEntry.EntryType.CARB);
        entry2.setTimestamp(new java.util.Date());
        repository.save(entry2);

    }

    @Test
    public void checkQuery() {
        assertThat(repository.findAll(), hasItem(notNullValue()));
    }
}

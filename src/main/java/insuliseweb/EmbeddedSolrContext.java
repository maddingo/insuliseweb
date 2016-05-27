package insuliseweb;

import lombok.SneakyThrows;
import org.apache.solr.client.solrj.SolrClient;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;
import org.springframework.data.solr.server.support.EmbeddedSolrServerFactoryBean;
import org.springframework.util.ResourceUtils;

import javax.annotation.Resource;
import java.io.File;

@Configuration
@Profile("dev")
@PropertySource("classpath:application.properties")
@EnableSolrRepositories(basePackages={"insuliseweb"}, multicoreSupport=true)
public class EmbeddedSolrContext {

    @Resource
    private Environment environment;

    @SneakyThrows
    @Bean
    public FactoryBean<SolrClient> solrServer() {
        EmbeddedSolrServerFactoryBean factory = new EmbeddedSolrServerFactoryBean();
        factory.setSolrHome(environment.getRequiredProperty("solr.solr.home"));
        return factory;
    }

    @SneakyThrows
    @Bean
    public SolrTemplate solrTemplate() {
        return new SolrTemplate(solrServer().getObject());
    }
}

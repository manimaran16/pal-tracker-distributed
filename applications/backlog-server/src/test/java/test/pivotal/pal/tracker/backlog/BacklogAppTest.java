package test.pivotal.pal.tracker.backlog;

import io.pivotal.pal.tracker.backlog.App;
import org.junit.Test;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
@EnableEurekaClient
public class BacklogAppTest {

    @Test
    public void embedded() {
        App.main(new String[]{});

        String response = new RestTemplate().getForObject("http://localhost:8181/stories?projectId=0", String.class);
        //String response = new RestTemplate().getForObject("http://registration")
        assertThat(response).isEqualTo("[]");
    }
}

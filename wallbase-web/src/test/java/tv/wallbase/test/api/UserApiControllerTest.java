package tv.wallbase.test.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import tv.wallbase.test.TestBase;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.equalTo;

/**
 * 测试接口的正确性
 * Created by wangkun23 on 2017/9/5.
 */
@AutoConfigureMockMvc
public class UserApiControllerTest extends TestBase {
    @Autowired
    MockMvc mvc;

    //@Test
    public void getHello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/admin/hello").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Greetings from Spring Boot!")));
    }


}

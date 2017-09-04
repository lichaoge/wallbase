package tv.wallbase.tractor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 * Created by wangkun23 on 2017/9/4.
 */
@SpringBootApplication
public class Application implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        System.out.println(this.cityDao.selectCityById(1));
//        System.out.println(this.hotelMapper.selectByCityId(1));
    }
}
package hello.datasource;

import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * @ConfigurationProperties 생성자 주입 장식
 */
@Getter
@ConfigurationProperties("my.datasource")
public class MyDataSourcePropertiesV2 {

    private String url;
    private String username;
    private String password;
    private Etc etc;

    //@DefaultValue는 해당 값을 찾을 수 없는 경우 기번값을 사용
    public MyDataSourcePropertiesV2(String url, String username, String password, @DefaultValue Etc etc) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.etc = etc;
    }

    @Getter
    public static class Etc{
        private int maxConnection;
        private Duration timeout;
        private List<String> options = new ArrayList<>();

        public Etc(int maxConnection, Duration timeout, @DefaultValue("default") List<String> options) {
            this.maxConnection = maxConnection;
            this.timeout = timeout;
            this.options = options;
        }
    }

}

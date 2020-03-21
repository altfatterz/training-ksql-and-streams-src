package streams;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProvider {
    public Properties getConfig() throws Exception {
        final Properties props = new Properties();
        // TODO modify to your path
        InputStream input = new FileInputStream("/Users/zoal/projects/kafka/training-ksql-and-streams-src/solution/security/secure-app/scripts/security/secureapp-sample.properties");
        props.load(input);
        return props;
    }
}

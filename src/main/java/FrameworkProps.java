import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FrameworkProps {
    private String result;
    private InputStream inputStream;
    public String getPropertie(String key)  {
        try {
            Properties properties=new Properties();
            String fileName="framework.properties";
            inputStream=getClass().getClassLoader().getResourceAsStream(fileName);
            if (inputStream!=null){
                properties.load(inputStream);
            }else{
                throw new FileNotFoundException("properties file not found");
            }
            this.result= properties.getProperty(key);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}

import com.mini.spring.context.ClassPathXmlApplicationContext;
import org.junit.jupiter.api.Test;

public class ClassPathXmlApplicationContextTest {

  @Test
  public void test() {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    HelloBean helloBean = (HelloBean) context.getBean("helloWorld");
    helloBean.echo();
  }
}

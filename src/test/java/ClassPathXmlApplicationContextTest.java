import com.mini.spring.beans.BeansException;
import com.mini.spring.context.ClassPathXmlApplicationContext;
import org.junit.jupiter.api.Test;

public class ClassPathXmlApplicationContextTest {

  @Test
  public void test() throws BeansException {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    HelloBean helloBean = (HelloBean) context.getBean("helloWorld");
    helloBean.echo();
  }
}

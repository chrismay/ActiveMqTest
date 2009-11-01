import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class QueueProducer {
public static void main(String[] args) {
	
	ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] {"context.xml"});
	for (int i = 0; i<= 100; i++) {
		QueuedWorkItem item = new QueuedWorkItem();
	}
}}
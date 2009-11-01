import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class QueueConsumer  implements MessageListener {

	    public void onMessage(Message message) {
	        if (message instanceof TextMessage) {
	            try {
	                System.out.println("got messsage: " +((TextMessage) message).getText());
	            }
	            catch (JMSException ex) {
	                throw new RuntimeException(ex);
	            }
	        }
	        else {
	            throw new IllegalArgumentException("Message must be of type TextMessage");
	        }
	    }
	
	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				new String[] { "consumer-context.xml" });
	}
}

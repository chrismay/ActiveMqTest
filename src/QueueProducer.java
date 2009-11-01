import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.Session;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class QueueProducer {

	private JmsTemplate template;
	private Queue q;

	public QueueProducer(JmsTemplate template, Queue queue) {
		this.template = template;
		this.q = queue;
	}

	public void queueStuff() {
		for (int i = 0; i <= 100; i++) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			final int j = i;
			System.out.println("queueing message " +i);
			template.send(this.q, new MessageCreator() {
				public Message createMessage(Session arg0) throws JMSException {
					return arg0.createTextMessage("hello world: message #" + j);
				}
			});
		}
	}

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				new String[] { "context.xml" });
		QueueProducer producer = (QueueProducer) ctx.getBean("producer");
		producer.queueStuff();
	}
}
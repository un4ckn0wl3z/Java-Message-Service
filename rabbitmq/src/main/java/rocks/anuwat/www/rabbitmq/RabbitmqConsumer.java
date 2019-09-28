package rocks.anuwat.www.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import rocks.anuwat.www.rabbitmq.model.Person;

@Service
public class RabbitmqConsumer {
	
	@RabbitListener(queues = Constant.MOBILE_QUEUE)
	public void getMessage(Person person) {
		System.out.println(person.toString());
	}
	
}

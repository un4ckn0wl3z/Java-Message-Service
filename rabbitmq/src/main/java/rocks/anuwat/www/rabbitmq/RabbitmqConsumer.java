package rocks.anuwat.www.rabbitmq;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import rocks.anuwat.www.rabbitmq.model.Person;

@Service
public class RabbitmqConsumer {

//	@RabbitListener(queues = Constant.MOBILE_QUEUE)
//	public void getMessage(Person person) {
//		System.out.println(person.toString());
//	}

	@RabbitListener(queues = Constant.MOBILE_QUEUE)
	public void getMessage(byte[] message) throws IOException, ClassNotFoundException {
		ByteArrayInputStream bis = new ByteArrayInputStream(message);
		ObjectInput in = new ObjectInputStream(bis);
		Person person =  (Person) in.readObject();
		in.close();
		bis.close();
		System.out.println(person.toString());
	}
}

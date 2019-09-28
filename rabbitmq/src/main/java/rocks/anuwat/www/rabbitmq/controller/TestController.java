package rocks.anuwat.www.rabbitmq.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rocks.anuwat.www.rabbitmq.Constant;
import rocks.anuwat.www.rabbitmq.model.Person;

@RestController
@RequestMapping("/api/v1")
public class TestController {

	@Autowired
	RabbitTemplate rabbitTemplate;

//	@GetMapping("/test/{name}")
//	public String testApi(@PathVariable("name") String name) {
//		Person person = new Person(1L, name);
//		rabbitTemplate.convertAndSend(Constant.MOBILE_QUEUE, person);
//		rabbitTemplate.convertAndSend(Constant.DIRECT_EXCHANGE, Constant.MOBILE_RTK, person);
//		rabbitTemplate.convertAndSend(Constant.FANOUT_EXCHANGE, "", person);
//		rabbitTemplate.convertAndSend(Constant.TOPIC_EXCHANGE, "tv.mobile.ac", person);
//
//		return "Success.";
//	}

	@GetMapping("/test/{name}")
	public String testApi(@PathVariable("name") String name) throws IOException {
		Person person = new Person(1L, name);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutput out = new ObjectOutputStream(bos);
		out.writeObject(person);
		out.flush();
		out.close();
		byte[] byteMessage = bos.toByteArray();
		bos.close();
		Message message = MessageBuilder.withBody(byteMessage)
				.setHeader("item1", "mobile")
				.setHeader("item2", "television").build();
		rabbitTemplate.send(Constant.HEADERS_EXCHANGE, "", message);
		return "Success.";
	}

}

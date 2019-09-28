package rocks.anuwat.www.demo.rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class FanoutPubliser {

	public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		
		String message = "Message for Mobile and AC";
		
		channel.basicPublish(Constant.FANOUT_EXCHANGE, "", null, message.getBytes());
		
		channel.close();
		connection.close();

	}

}

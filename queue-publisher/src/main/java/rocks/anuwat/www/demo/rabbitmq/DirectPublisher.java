package rocks.anuwat.www.demo.rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class DirectPublisher {

	public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		
		String message = "This is tv";
		
		channel.basicPublish(Constant.EXCHANGE_NAME, Constant.TV_RTK, null, message.getBytes());
		
		channel.close();
		connection.close();

	}

}

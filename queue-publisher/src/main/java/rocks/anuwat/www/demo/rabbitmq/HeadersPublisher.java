package rocks.anuwat.www.demo.rabbitmq;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class HeadersPublisher {

	public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();

		String message = "Message for Mobile and TV";
		
		Map<String, Object> headersMap = new HashMap<String, Object>();
		headersMap.put("item1", "mobile");
		headersMap.put("item2", "television");
		BasicProperties bp = new BasicProperties();
		bp = bp.builder().headers(headersMap).build();
		channel.basicPublish(Constant.HEADERS_EXCHANGE, "", bp, message.getBytes());
		channel.close();
		connection.close();

	}

}

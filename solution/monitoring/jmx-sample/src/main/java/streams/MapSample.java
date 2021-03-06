package streams;

import java.util.Properties;

import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;


public class MapSample {
    public static void main(String[] args) {
        System.out.println("*** Starting Map Sample Application ***");
	
        Properties settings = new Properties();
        settings.put(StreamsConfig.APPLICATION_ID_CONFIG, "map-sample-v0.1.0");
        settings.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:19092");

        final Serde<String> stringSerde = Serdes.String();
        StreamsBuilder builder = new StreamsBuilder();
        KStream<String, String> lines = builder
            .stream("lines-topic", Consumed.with(stringSerde, stringSerde));
        KStream<String, String> transformed = lines
            .map((key, value) -> KeyValue.pair(key, value.toLowerCase()));
        transformed.to("lines-lower-topic", Produced.with(stringSerde, stringSerde));
        Topology topology = builder.build();

        KafkaStreams streams = new KafkaStreams(topology, settings);
        streams.start();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("### Stopping Map Sample Application ###");
            streams.close();
        }));
    }
}


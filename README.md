## Spring Boot Reactive + Kafka + Server Sent Event.


The proof of concept is divided in two moments:

1. the user connects to the service of SSE (Server Sent Event) via Javascript (EventSource) to listen the events (from kafka).
2. the user interacts with the service sending HTTP requests and generating events (to kafka).

```
user --- access  ---> event-stream.html (EventSource) ------ listen  ---> http://localhost:8080/events (Server Sent Event) --- subscribe ---> kafka

user --- request ---> http://localhost:8080/api/customer --- publish ---> kafka
```

Setup.

```
git clone https://github.com/renatoaguimaraes/spring-reactive-kafka-sse.git spring-reactive-kafka-sse
cd ./spring-reactive-kafka-sse 
```

Starting Cassandra, Zookeeper and Kafka.

```
docker-compose up
```

Accessing Cassandra console to create the keyspace.

```
 docker exec -it some-cassandra bash
```

Execute cqlsh console.

```
cqlsh
```

Create the keyspace 'poc'.

```
CREATE KEYSPACE poc WITH REPLICATION = {'class': 'SimpleStrategy', 'replication_factor': 1};
```




## Spring Boot Reactive + Kafka + Server Sent Event + Cassandra.


The proof of concept is divided in two moments:

1. the user connects to the service of SSE (Server Sent Event) via Javascript (EventSource) to listen the events (from kafka).
2. the user interacts with the service sending HTTP requests and generating events (to kafka).

![Flow](flow.png)

Quick start. 

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

Execute cqlsh console inside the container.

```
cqlsh
```

Create the keyspace 'poc'.

```
CREATE KEYSPACE poc WITH REPLICATION = {'class': 'SimpleStrategy', 'replication_factor': 1};
```




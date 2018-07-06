## Spring Boot Reactive + Kafka + Server Sent Event.


The proof of concept is divided in two moments:

1. the user connects to the service of SSE (Server Sent Event) via Javascript (EventSource) to listen the events (from kafka).
2. the user interacts with the service sending HTTP requests and generating events (to kafka).



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

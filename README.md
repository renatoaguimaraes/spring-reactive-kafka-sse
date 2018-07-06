## Spring Boot Reactive + Kafka + Server Sent Event.

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

Download and run Cassandra docker image. 

```
docker run --name some-cassandra -d cassandra
```

Accessing Cassandra console.

```
 docker exec -it some-cassandra bash
```

```
cqlsh

```

Creating a Keyspace.

```
CREATE KEYSPACE farfetch WITH REPLICATION = {'class': 'SimpleStrategy', 'replication_factor': 1};
```
package com.poc.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractReactiveCassandraConfiguration;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.repository.config.EnableReactiveCassandraRepositories;

@Configuration
@EnableReactiveCassandraRepositories(basePackages = { "com.poc.repository" })
public class CassandraConfig extends AbstractReactiveCassandraConfiguration {

	@Value("${cassandra.contact-points}")
	private String contactPoints;
	@Value("${cassandra.port}")
	private int port;
	@Value("${cassandra.keyspace}")
	private String keyspace;
	@Value("${cassandra.basepackages}")
	private String basePackages;

	@Override
	protected String getKeyspaceName() {
		return keyspace;
	}

	@Override
	protected String getContactPoints() {
		return contactPoints;
	}

	@Override
	protected int getPort() {
		return port;
	}

	@Override
	public SchemaAction getSchemaAction() {
		return SchemaAction.CREATE_IF_NOT_EXISTS;
	}

	@Override
	public String[] getEntityBasePackages() {
		return new String[] { basePackages };
	}
}
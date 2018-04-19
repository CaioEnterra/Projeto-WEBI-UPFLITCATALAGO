package br.com.crudUpFlitCatalago.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped

// Fabrica de conexão abre e fecha a conexao

public class EntityManagerProducer {

	private EntityManagerFactory factory;

	// construtor da fabricar pegando o o valor da persistencia
	public EntityManagerProducer() {
		this.factory = Persistence.createEntityManagerFactory("UPFlitAdmin");

	}

	// Mapeamento no Hibernate para BD
	@Produces
	@RequestScoped
	public EntityManager createEntityManager() {
		return this.factory.createEntityManager();
	}
	//Sempre que finalizar ele deve fechar a conexão
	public void closeEntityManager(@Disposes EntityManager manager) {
		manager.close();

	}

}

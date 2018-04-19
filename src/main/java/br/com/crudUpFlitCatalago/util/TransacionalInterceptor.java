package br.com.crudUpFlitCatalago.util;

import java.io.Serializable;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

@Interceptor
@Transacional
@Priority(Interceptor.Priority.APPLICATION + 1)
public class TransacionalInterceptor implements Serializable {


	private static final long serialVersionUID = 5722374874302085667L;
	@Inject
	private EntityManager manager;

	@AroundInvoke
	public Object invoke(InvocationContext context) throws Exception {
		EntityTransaction trx = manager.getTransaction();
		boolean criador = false;

		try {
			if (!trx.isActive()) {
				// truque para fazer rollback no que j� passou
				// (sen�o, um futuro commit confirmaria at� mesmo opera��es sem transa��o)
				trx.begin();
				trx.rollback();

				// agora sim inicia a transa��o
				trx.begin();

				criador = true;
			}

			return context.proceed();
		} catch (Exception e) {//caso n�o de exces�o vai direto pro finally
			if (trx != null && criador) {
				trx.rollback();
			}

			throw e;
		} finally {
			if (trx != null && trx.isActive() && criador) {
				trx.commit();
			}
		}
	}

}
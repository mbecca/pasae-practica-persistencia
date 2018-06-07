package ar.edu.unlp.pasae.pasaepractica.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import ar.edu.unlp.pasae.pasaepractica.exceptions.BaseException;
import ar.edu.unlp.pasae.pasaepractica.exceptions.UnexpectedException;

@Aspect
@Configuration
public class ExceptionHandlerAspect {

	private static final Logger logger = LoggerFactory.getLogger(ExceptionHandlerAspect.class);

	@AfterThrowing(value = "execution(* ar.edu.unlp.pasae.pasaepractica.services.*.*(..))", throwing = "exception")
	public void after(final JoinPoint joinPoint, final Exception exception) throws Exception {
		if (exception instanceof BaseException == false) {
			logger.info("Convirtiendo excepción no manejada {} en una UnexpectedException",
					exception.getLocalizedMessage());
			throw new UnexpectedException("Excepción no esperada", exception);
		} else
			throw exception;

	}

}

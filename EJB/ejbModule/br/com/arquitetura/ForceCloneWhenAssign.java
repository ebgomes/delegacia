package br.com.arquitetura;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Marca para clonar quando fizer um assign pela implementacao padrao de {@link Assignable}
 * 
 * @author jose.junior
 * 
 */
@Target({ METHOD, TYPE })
@Retention(RUNTIME)
public @interface ForceCloneWhenAssign {

}

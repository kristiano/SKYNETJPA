/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.to.secad.skynet.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
/**
 *
 * @author marceloclaudios
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueUserValidation.class)
public @interface UniqueUser {
    /**
     *
     * @return
     */
    String message() default "{app.UniqueUser.message}";
    /**
     *
     * @return
     */
    Class<?>[] groups() default {};
    /**
     *
     * @return
     */
    Class<? extends Payload>[] payload() default {};
}
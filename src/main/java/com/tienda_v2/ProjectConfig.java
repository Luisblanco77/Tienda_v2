/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda_v2;

import java.util.Locale;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration

public class ProjectConfig implements WebMvcConfigurer {
    // Los siguientes metodos son utilizados para el tema de la internacionalizacion.

    //LocaleResolver ubica informacion del browser local del usuario y fija la informacion a desplegar.
    @Bean
    public LocaleResolver localeResolver() {
        var slr = new SessionLocaleResolver();

        slr.setDefaultLocale(
                Locale.getDefault());

        slr.setLocaleAttributeName(
                "session.current.locale"
        );

        slr.setTimeZoneAttributeName(
                "session.current.timezone");

        return slr;
    }
//Define cual sera la variable que "cambia" el odioma de los textos.

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        var lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }

    //Se agrega un "interceptor" para poder hacer el cambio de idioma de inmediato.
    @Override
    public void addInterceptors(InterceptorRegistry registro) {
        registro.addInterceptor(localeChangeInterceptor());

    }

    //Se utilizara para recuperar los textos dentro de java segun el idioma.
    @Bean("messageSource")
    public MessageSource messageSource() {
        ResourceBundleMessageSource bundleMessageSource
                = new ResourceBundleMessageSource();
        bundleMessageSource.setBasename("messages");
        bundleMessageSource.setDefaultEncoding("UTF-8");

        return bundleMessageSource;
    }

}

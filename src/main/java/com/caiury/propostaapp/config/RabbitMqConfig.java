package com.caiury.propostaapp.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    @Bean
    public Queue criarFilaPropostaPendenteMsAnaliseCredito() {

        return QueueBuilder.durable("proposta-pendente.ms-analise-de-credito").build();

    }

    @Bean
    public Queue criarFilaPropostaPendenteMsNotificacao() {

        return QueueBuilder.durable("proposta-pendente.ms-notificacao").build();

    }

    @Bean
    public Queue criarFilaPropostaConcluidaMsProposta() {

        return QueueBuilder.durable("proposta-concluida.ms-proposta").build();

    }

    @Bean
    public Queue criarFilaPropostaConcluidaMsNotificacao() {

        return QueueBuilder.durable("proposta-concluida.ms-notificacao").build();

    }

    @Bean
    public RabbitAdmin criarRabbitAdmin(ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }

    @Bean
    public ApplicationListener<ApplicationEvent> inicializarAdmin(RabbitAdmin rabbitAdmin) {
        return event -> rabbitAdmin.initialize();
    }


}

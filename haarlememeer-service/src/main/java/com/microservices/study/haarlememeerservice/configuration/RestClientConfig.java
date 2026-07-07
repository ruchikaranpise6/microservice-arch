package com.microservices.study.haarlememeerservice.configuration;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {

  @Bean
  RestClient restClient(ObjectProvider<RestClient.Builder> builderProvider) {
    // If a RestClient.Builder bean is available from auto-configuration use it,
    // otherwise fall back to the static builder() factory so this configuration
    // is safe in tests or when web auto-configuration is not active.
    RestClient.Builder builder = builderProvider.getIfAvailable(RestClient::builder);
    return builder.build();
  }
}

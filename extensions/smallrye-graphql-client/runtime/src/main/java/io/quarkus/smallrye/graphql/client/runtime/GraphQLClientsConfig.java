package io.quarkus.smallrye.graphql.client.runtime;

import java.util.Map;

import io.quarkus.runtime.annotations.ConfigDocMapKey;
import io.quarkus.runtime.annotations.ConfigPhase;
import io.quarkus.runtime.annotations.ConfigRoot;
import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithParentName;

@ConfigMapping(prefix = "quarkus.smallrye-graphql-client")
@ConfigRoot(phase = ConfigPhase.RUN_TIME)
public interface GraphQLClientsConfig {

    /**
     * Configurations of named GraphQL client instances.
     *
     * For dynamic clients, the key here (the client name) is always the same as the value used
     * in the `@GraphQLClient` annotation used for injecting the client.
     *
     * For typesafe clients, the key here can be either the value of the configKey parameter of a
     * `@GraphQLClientApi` annotation, or the name of a class bearing that annotation, in which case
     * it is possible to use the short name, as well as fully qualified.
     */
    @ConfigDocMapKey("config-key")
    @WithParentName
    Map<String, GraphQLClientConfig> clients();
}

package com.example.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
@Profile("cloud")
public class CloudDatabaseConfiguration {

    @Value("${DATABASE_URL}")
    private String databaseRawUrl;
    //postgres://cutejmzvsztlsl:a4628422e68b678b9f0ee6c8c16925ad75e9521e633c388b2aef26bec31faa79@ec2-63-32-248-14.eu-west-1.compute.amazonaws.com:5432/d39j75o6plt4us

    @Bean
    public DataSource dataSource() {

        if (databaseRawUrl == null) {
            throw new IllegalArgumentException("DATABASE_URL cannot be null or empty");
        }

        //postgres://cutejmzvsztlsl:a4628422e68b678b9f0ee6c8c16925ad75e9521e633c388b2aef26bec31faa79@ec2-63-32-248-14.eu-west-1.compute.amazonaws.com:5432/d39j75o6plt4us
        String dataSourceFullUrl = databaseRawUrl.replaceFirst("postgres://", "");

        // jdbc:postgresql://username:password@url:port/database

        //cutejmzvsztlsl:a4628422e68b678b9f0ee6c8c16925ad75e9521e633c388b2aef26bec31faa79@ec2-63-32-248-14.eu-west-1.compute.amazonaws.com:5432/d39j75o6plt4us

        String url =
                String.format("jdbc:postgresql://%s",
                        dataSourceFullUrl.substring(dataSourceFullUrl.indexOf("@") + 1)
                );

        //ec2-63-32-248-14.eu-west-1.compute.amazonaws.com:5432/d39j75o6plt4us

        String username = dataSourceFullUrl.substring(0, dataSourceFullUrl.indexOf(":"));
        //cutejmzvsztlsl (username)

        String password = dataSourceFullUrl.substring(
                dataSourceFullUrl.indexOf(":") + 1,
                dataSourceFullUrl.indexOf("@")
        );

        //a4628422e68b678b9f0ee6c8..... (password)

        return DataSourceBuilder.create()
                .username(username)
                .password(password)
                .url(url)
                .build();
    }

}

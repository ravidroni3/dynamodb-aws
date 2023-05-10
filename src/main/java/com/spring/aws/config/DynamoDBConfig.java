package com.spring.aws.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DynamoDBConfig {

    private static final String SERVICE_ENDPOINT = "dynamodb.ap-south-1.aws.com";
    private static final String REGION = "ap-south-1";
    private static final String ACCESSKEY = "AKIARCZ2MYAHCOO3OR6B";
    public static final String SECRET_KEY = "l4i1ko0Zqs75qH1x + ljeJwCDW4M6f4rDXQA0zfZj";


    @Bean
    DynamoDBMapper mapper() {
        return new DynamoDBMapper(amazonDynamoDBConfig());

    }

    private AmazonDynamoDB amazonDynamoDBConfig() {
        return AmazonDynamoDBClientBuilder.standard().withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(SERVICE_ENDPOINT, REGION))
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(ACCESSKEY, SECRET_KEY))).build();

    }
}

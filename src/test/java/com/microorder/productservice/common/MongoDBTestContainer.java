package com.microorder.productservice.common;

import org.testcontainers.containers.MongoDBContainer;

public class MongoDBTestContainer extends MongoDBContainer
{
    static final String IMAGE_VERSION = "mongo:6.0.4";
    private static MongoDBTestContainer container;

    private MongoDBTestContainer()
    {
        super(IMAGE_VERSION);
    }

    public static MongoDBTestContainer getInstance()
    {
        if (container == null)
        {
            container = new MongoDBTestContainer();
        }
        return container;
    }

    @Override
    public void start()
    {
        super.start();
        System.setProperty("MONGO_URL", container.getReplicaSetUrl());
    }

    @Override
    public void stop()
    {
        //do nothing, JVM handles shut down
    }
}

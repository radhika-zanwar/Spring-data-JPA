package com.radhika.springdata.idGenerators;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.Random;

public class CustomIdGenerator implements IdentifierGenerator {
    @Override
    public Serializable generate(SharedSessionContractImplementor si, Object obj) {
        Random random = new Random();
        int id = random.nextInt(1000);
        return (long) id;
    }
}

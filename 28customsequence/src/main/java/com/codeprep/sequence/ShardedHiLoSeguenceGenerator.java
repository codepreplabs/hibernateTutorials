package com.codeprep.sequence;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.boot.model.relational.Database;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.jdbc.spi.JdbcServices;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.PersistentIdentifierGenerator;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.util.Properties;

public class ShardedHiLoSeguenceGenerator implements
        PersistentIdentifierGenerator, Configurable
{
    private static long id;

    private final SequenceStyleGenerator seqGen = new SequenceStyleGenerator();

    private static Dialect dialect;

    public ShardedHiLoSeguenceGenerator()
    {
    }

    public static void setShardID(int id)
    {
        ShardedHiLoSeguenceGenerator.id = id;
    }

    public static Long getShardId()
    {
        return ShardedHiLoSeguenceGenerator.id;
    }

    @Override
    public Object generatorKey()
    {
        return seqGen.generatorKey();
    }

    @Override
    public String[] sqlCreateStrings(Dialect dialect) throws HibernateException
    {
        ShardedHiLoSeguenceGenerator.dialect = dialect;
        return seqGen.sqlCreateStrings(dialect);
    }

    @Override
    public String[] sqlDropStrings(Dialect dialect) throws HibernateException
    {
        ShardedHiLoSeguenceGenerator.dialect = dialect;
        return seqGen.sqlDropStrings(dialect);
    }

    @Override
    public void registerExportables(Database database) {
        seqGen.registerExportables(database);
    }

    @Override
    public void configure(Type type, Properties properties, ServiceRegistry serviceRegistry) throws MappingException {

        Dialect dialect = serviceRegistry.getService( JdbcServices.class ).getDialect();
        seqGen.configure(type, properties, serviceRegistry);
        ShardedHiLoSeguenceGenerator.dialect = dialect;
    }

    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object object) throws HibernateException {

        PersistentIdentifierGenerator gen = seqGen;
        Serializable identifier = gen.generate(sharedSessionContractImplementor, object);
        if (identifier instanceof Long)
        {
            identifier = (((Long) identifier) * 1000L) + id;
        }
        return identifier;
    }
}
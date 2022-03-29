package com.ers.util;

import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

public class ConnectionFactoryTest {

    private static ConnectionFactory connectionFactory;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        connectionFactory = ConnectionFactory.getInstance();
    }

    @Test
    public void testConnectionFactoryIsAbleToGetConnection() throws SQLException {
        Connection conn = connectionFactory.getConnection();

        assertThat(conn, instanceOf(Connection.class));
    }
}



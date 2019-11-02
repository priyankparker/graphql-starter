package com.oembedler.moon.graphql.boot;

import graphql.servlet.GraphQLWebsocketServlet;
import org.springframework.context.Lifecycle;
import org.springframework.web.socket.server.standard.ServerEndpointRegistration;

import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;

/**
 * @author Andrew Potter
 */
public class GraphQLWsServerEndpointRegistration extends ServerEndpointRegistration implements Lifecycle {

    private final GraphQLWebsocketServlet servlet;

    public GraphQLWsServerEndpointRegistration(String path, GraphQLWebsocketServlet servlet) {
        super(path, servlet);
        this.servlet = servlet;
    }

    @Override
    public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
        super.modifyHandshake(sec, request, response);
        servlet.modifyHandshake(sec, request, response);
    }

    @Override
    public void start() {
    }

    @Override
    public void stop() {
        servlet.beginShutDown();
    }

    @Override
    public boolean isRunning() {
        return !servlet.isShutDown();
    }
}

### Standalone Jetty

#### Steps
* Create the server
* Add/Configure Connectors
* Add/Configure Handlers
* Add/Configure Servlets/Webapps to Handlers
* Start the server
* Wait (join the server to prevent main exiting)


#### Create Server


#### Connectors
* A Connector can be configured with:
    * interface
    * port
    * buffer sizes
    * timeouts

```java
Server server = new Server();
 
SelectChannelConnector connector = new SelectChannelConnector();
connector.setPort(8080);
connector.setMaxIdleTime(30000);
connector.setRequestHeaderSize(8192);

server.setConnectors(new Connector[]{ connector, connector1, ssl_connector });
server.setHandler(new HelloHandler());

server.start();
```
<br>

#### Handlers
* Examine/modify the HTTP request.
* Generate the complete HTTP response.
* Call another Handler (see `API/HandlerWrapper`).
* Select one or many Handlers to call (see `API/HandlerCollection`).

```java
public class HelloHandler extends AbstractHandler
{
    public void handle(String target,Request baseRequest,HttpServletRequest request,HttpServletResponse response) 
        throws IOException, ServletException
    {
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        baseRequest.setHandled(true);
        response.getWriter().println("<h1>Hello World</h1>");
    }
}
```

The parameters passed to the handle method are:

* target–the target of the request, which is either a URI or a name from a named dispatcher.
* baseRequest–the Jetty mutable request object, which is always unwrapped.
* request–the immutable request object, which might have been wrapped.
* response–the response, which might have been wrapped.

The handler sets the response status, content-type and marks the request as handled before it generates the body of the response using a writer.

complex request handling is typically built from multiple Handlers
 
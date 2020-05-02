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

#### Handlers
* Examine/modify the HTTP request.
* Generate the complete HTTP response.
* Call another Handler (see HandlerWrapper).
* Select one or many Handlers to call (see HandlerCollection).

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
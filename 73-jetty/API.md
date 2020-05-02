### Jetty API
#### C
* `ContextHandler` 
    * Collection uses the longest prefix of the request URI (the contextPath) 
    to select a specific ContextHandler to handle the request. 
    * A ContextHandler is a HandlerWrapper that responds only to requests that have a URI prefix 
    that matches the configured context path.
    * Requests that match the context path have their path methods updated accordingly, 
    and the following optional context features applied as appropriate: 
#### H
* `HandlerCollection` 
    * holds a collection of other handlers and calls each handler in order. 
    * This is useful for combining statistics and logging handlers with the handler that generates the response.
* `HandlerList`
    * is a Handler Collection that calls each handler in turn until either an exception is thrown, the response is committed or the request.isHandled() returns true. 
    * It can be used to combine handlers that conditionally handle a request.  
* `HandlerWrapper` 
    * Base class that can be used to daisy chain handlers together in the style of aspect-oriented programming. 
    * For example, a standard web application is implemented by a chain of a context, session, security and servlet handlers.
* `HttpClient` 
    * Provides API to perform HTTP (or HTTPS) requests.
* `HttpServlet`
    * Servlets are the standard way to provide application logic that handles HTTP requests. 
    * Servlets are like constrained Handlers with standard ways to map specific URIs to specific servlets.
#### S
* `ServletContextHandler`
    * A ServletContextHandler is a specialization of ContextHandler with support for standard servlets. The following code from OneServletContext shows three instances of the helloworld servlet registered with a ServletContextHandler: 
* `ServletHandler` 
    * Servlet HttpHandler. This handler maps requests to servlets.
* `ServletHolder` 
    * Holds the name, params and some state of a servlet instance.
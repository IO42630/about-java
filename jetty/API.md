### Jetty API
#### C
* `ContextHandler`
    * Is a `HandlerWrapper` that responds only to requests that matche the configured `ContextPath`.
* `ContextPath` URI
#### H
* `HandlerCollection` 
    * holds a collection of other handlers and calls each handler in order. 
    * This is useful for combining statistics and logging handlers with the handler that generates the response.
* `HandlerList`
    * is a `HandlerCollection` that calls each handler in turn until either an exception is thrown, the response is committed or the request.isHandled() returns true. 
    * Used to combine handlers that conditionally handle a request.  
* `HandlerWrapper` 
    * Used to daisy chain handlers. 
    * E.g. a standard web app is implemented by a chain of a context, session, security and servlet handlers.
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
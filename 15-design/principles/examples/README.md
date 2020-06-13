#### About
This overview is inspired by the normalization levels in relational databases.

<br> 

#### Glossary
* feature : some functionality provided by a service.
* service : an entity providing a feature.
* client : an entity consuming (making use of) a feature.

<br>

#### Levels
* __Level 1__ : single responsibility.
* __Level 2__ : open / close
    * Add featureA and featureB by extending the Service in level 1. 
* level 2 : open / close.
    * looser coupling by using interfaces
* level 4 : 1+2
    * create interface for each separate feature.
* level 5
    * do not declare services in client
    * declare services in main and pass them to client by constructor.

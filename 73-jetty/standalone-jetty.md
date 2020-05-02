###JETTY
#### Files
* src : `app/jetty-9.4-src/` (cloned from github)
* bin : `app/jetty9.4` (downloaded from official website)

<br>

#### PATH(s)

* `$JETTY_HOME` : where jetty is started from.
    * `app/jetty9.4/`
    * contains
        * `/etc` : xml files (read only)
        * `/modules`
* `$JETTY_BASE` : where the config is parsed from.
    * may be identical to `$JETTY_HOME`
    * `/start.d` contains `.ini` files
        * those generate xml for config




<br>

#### CONF
* **list config** : `java -jar $JETTY_HOME/start.jar --list-config`
* config can be stored in either:
    * a single `$JETTY_HOME/start.ini`
    * multiple `<foo>.ini` in `$JETTY_HOME/start.d/`
* create a `start.d`
    * `mkdir <new-base> & cd <new-base>`
    * `java -jar $JETTY_HOME/start.jar --create-startd`
        * this will also replace an existing `start.ini` (if executed from an existing `<base>`)
* add modules to config : `java -jar $JETTY_HOME/start.jar --add-to-start=<module>`
    * `<module` e.g. server,client, webapp, websocket, proxy
    

<br>

<br>

#### RUN
* `cd $JETTY_BASE`
* `java -jar start.jar`
* **list modules**
    * `start.jar --list-modules=logging,-internal`
        * tags : include `logging` , exclude `internal`
* **add modules**
    * `start.jar --add-to-start=logging,-internal`
    

<br>


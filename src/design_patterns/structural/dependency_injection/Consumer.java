package design_patterns.structural.dependency_injection;

/**
 * Consumer of the Service. <p>
 * E.g. Plugin
 */
interface Consumer {

    void processMessages(String msg, String rec);
}


class Plugin implements Consumer {

    private MessageService service;

    public Plugin(MessageService service) {
        this.service = service;
    }

    @Override
    public void processMessages(String msg, String rec) {
        //do some msg validation, manipulation logic etc
        this.service.sendMessage(msg, rec);
    }
}
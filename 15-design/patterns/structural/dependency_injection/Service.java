package patterns.structural.dependency_injection;


/**
 * E.g. Jira Server.
 */
interface MessageService {

    void sendMessage(String msg, String rec);
}


class EmailServiceImpl implements MessageService {

    @Override
    public void sendMessage(String msg, String rec) {
        //logic to send email
        System.out.println("Email sent to " + rec + " with Message=" + msg);
    }

}


class SMSServiceImpl implements MessageService {

    @Override
    public void sendMessage(String msg, String rec) {
        //logic to send SMS
        System.out.println("SMS sent to " + rec + " with Message=" + msg);
    }

}

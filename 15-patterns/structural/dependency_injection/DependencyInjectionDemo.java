package structural.dependency_injection;

public class DependencyInjectionDemo {
    /**
     * Loosely coupled pluginlication
     * Dependency resoultion at runtime
     * DI Components:
     * Service
     * Consumer
     * Injector
     * DI is core of Spring and Google Guice Frameworks
     */

    public static void main(String[] args) {
        String msg = "Hello.";
        String email = "pankaj@abc.com";
        String phone = "4088888888";


        //Send email
        Injector email_injector = new EmailServiceInjector();
        Consumer email_plugin = email_injector.getConsumer(); // Injector returns Consumer(new EmailServiceImpl())
        email_plugin.processMessages(msg, email);

        //Send SMS
        Injector sms_injector = new SMSServiceInjector();
        Consumer sms_plugin = sms_injector.getConsumer();
        sms_plugin.processMessages(msg, phone);
    }
}



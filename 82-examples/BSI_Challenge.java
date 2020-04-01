package examples;

import java.util.stream.*;

public class BSI_Challenge {
    private String task;
    private String company = "BSI";
    private Stream<String> hiring = Stream.of("sucht", "Software Engineers", "zur", "Verstärkung");

    public BSI_Challenge(String scope) {
        task = "CODE-RÄTSEL KNACKEN";
    }

    protected BSI_Challenge() {
        company = "RECRUITING-MESSE BESUCHEN";
    }

    protected String getHiring() {
        return hiring.filter(s -> s.length() == 0b101).findFirst().orElse("RASPBERRY PI TOUCH");
    }

    @Override
    public String toString() {
        return task = company;
    }

    public static void main(String args[]) {
        // What this does:
        // class call causes toString, thus 'BSI'
        // .getHiring() looks for first string that has length 5, which is 'sucht'
        BSI_Challenge challenge = new BSI_Challenge("GEWINNEN");
        System.out.print(challenge + " " + challenge.getHiring());
    }

}

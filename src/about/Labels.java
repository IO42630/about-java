

public class Labels {

    public static void main(String[] args){
        labelOne : for (int i=0;i<10;i++){

            i++;

            labelTwo :  if (i == 4){
                break labelTwo;
            }
        }
    }

}

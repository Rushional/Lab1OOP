public class Number {
    public double number;

//    AFAIK there's no such thing as typedef in Java so I use a class
//    And boy is this annoying to work with!1!1!
//    In the original program Number was just a double in disguise, so I am leaving all the fields public
//    Also there is no operator overloading in Java
//    so I'm gonna have to shuffle from double to Number back and forth all the time
//    This is going to be amazing.
    public Number(double number) {
        this.number = number;
    }

    public void outputNumber() {
        System.out.println(number);
    }

    public String asString() {
        return String.valueOf(number);
    }
}

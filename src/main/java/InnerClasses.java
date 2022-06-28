public class InnerClasses {

    int outerVar = 100;
    public static void main(String[] args) {
       new InnerClasses().caller();
        staticInner.hello();
    }

    private void caller() {
        inner i = new inner();
        i.hello();
    }

    //normal inner class
    class inner{

        void hello(){
            System.out.println("outer class variable " + outerVar);
        }
    }

    static class staticInner{
        static void hello(){
            System.out.println("hello from static inner class");
        }

    }

}


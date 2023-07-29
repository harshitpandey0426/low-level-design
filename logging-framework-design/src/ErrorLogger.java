public class ErrorLogger extends AbstractLogger{
    public ErrorLogger(int level){
        super(level);
    }
    @Override
    protected void display(String msg) {
        System.out.println("ERROR: "+msg);
    }
}

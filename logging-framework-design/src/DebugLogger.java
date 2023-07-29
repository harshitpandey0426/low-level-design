public class DebugLogger extends AbstractLogger{
    public DebugLogger(int level){
        super(level);
    }
    @Override
    protected void display(String msg) {
        System.out.println("DEBUG: "+msg);
    }
}

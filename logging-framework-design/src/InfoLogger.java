public class InfoLogger extends AbstractLogger{
    public InfoLogger(int level){
        super(level);
    }
    @Override
    protected void display(String msg) {
        System.out.println("INFO: "+msg);
    }
}

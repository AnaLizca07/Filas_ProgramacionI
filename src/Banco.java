import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Banco {
    private BlockingQueue<String> prioritariosBanco=new LinkedBlockingQueue<>();
    private BlockingQueue<String> normalesBanco = new LinkedBlockingQueue<>();

    public void agregarClientePrioritario(String usuario){
        prioritariosBanco.add(usuario);
    }

    public void agregarClienteNormal(String usuario){
        normalesBanco.add(usuario);
    }

    public BlockingQueue<String> getPrioritariosBanco() {
        return prioritariosBanco;
    }

    public void setPrioritariosBanco(BlockingQueue<String> prioritariosBanco) {
        this.prioritariosBanco = prioritariosBanco;
    }

    public BlockingQueue<String> getNormalesBanco() {
        return normalesBanco;
    }

    public void setNormalesBanco(BlockingQueue<String> normalesBanco) {
        this.normalesBanco = normalesBanco;
    }
}

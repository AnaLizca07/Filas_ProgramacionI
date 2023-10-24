public class MainBanco {
    public static void main(String[] args) {
        Banco banco = new Banco();

        Thread prioritarios = new Thread(() ->{
            while (true){
                String usuario = null;
                try {
                    usuario = banco.getPrioritariosBanco().take();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Usuario prioritario en proceso:"+ usuario);
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e) {}
            }
        });

        Thread normales = new Thread(() ->{
            while (true){
                if(banco.getPrioritariosBanco().isEmpty()){
                    String usuario=null;
                    try{
                        usuario = banco.getNormalesBanco().take();
                    }catch (InterruptedException e){
                        throw new RuntimeException(e);
                    }
                    System.out.println("Usuario normal en proceso:"+usuario);
                    try {
                        Thread.sleep(1000);
                    }catch (InterruptedException e ){}
                }
            }
        });
        prioritarios.start();
        normales.start();

        banco.agregarClienteNormal("Juan");
        banco.agregarClientePrioritario("Sebastian");
        banco.agregarClienteNormal("Isabella");
        banco.agregarClientePrioritario("Ana");
        banco.agregarClientePrioritario("Esteban");
    }
}

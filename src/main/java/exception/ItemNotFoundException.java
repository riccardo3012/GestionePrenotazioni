package exception;

public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(Long id) {
        super("L'oggeto con " + id + "non è stato trovato");
    }

    public ItemNotFoundException(String name) {
        super("Il nome" + name + "non è stato trovato");
    }
}
package bimap;

public class DamagedMapsException extends Exception{
    public DamagedMapsException(){
        super("Maps are damaged! it is recommended to re-init");
    }
}

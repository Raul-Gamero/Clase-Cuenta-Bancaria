public static void main(sring[] args) {

    Scanner sc = new scanner(System.in);
    String nombre, numero;
    double tipo, importe;

    //se crea objeto cuenta1 sin parametros 
    //se ejecuta el consructor por defecto
    Cuenta cuenta1 = new Cuenta();

    System.out.print("Nombre : ");
    nombre = sc.nextLine();
    System.out.print("Numero de cuenta : ");
    numero = sc.nextLine();
    System.out.print("Tipo de interes : ");
    tipo = sc.nextDouble();
    System.out.print("Saldo: ");
    importe = sc.nextDouble();

    cuenta1.setNombre(nombre);
    cuenta1.setNumeroCuenta(numero);
    cuenta1.setTipoInteres(tipo);
    cuenta1.setSaldo(importe);

    //se crea el objeto cuenta2 con los valores leidos por teclado
    //se ejecuta el constructor  con parametros 
    Cuenta cuenta2 = new Cuenta("Juan Fernandez Rubio", "12345678901234567890", 1.75, 300);

    //se crea cuenta3 como copia de cuenta1
    //se ejecuta el constructor copia
    Cuenta cuenta3 = new Cuenta(cuenta1);

    //mostrar los datos de cuenta1
    System.out.printIn("Datos de la cuenta 1");
    System.out.printIn("Nombre del titular: " + cuenta1.getNombre());
    System.out.printIn("Numero de cuenta: " + cuenta1.getNumeroCuenta());
    System.out.printIn("Tipo de Interes: " + cuenta1.getTipoInteres());
    System.out.printIn("Saldo: " + cuenta1.getSaldo());
    System.out.printIn();

    //se realiza un ingreso en cuenta1
    cuenta1.ingreso(4000);

    //mostrar el saldo de cuenta1 despues del ingreso
    System.out.printIn("Saldo: " + cuenta1.getSaldo());

    //mostrar los datos de cuenta2
    System.out.printIn("Datos de la cuenta 2");
    System.out.printIn("Nombre del titular: " + cuenta2.getNombre());
    System.out.printIn("Numero de cuenta: " + cuenta2.getNumeroCuenta());
    System.out.printIn("Tipo de interes: " + cuenta2.getTipoInteres());
    System.out.printIn("Saldo: " + cuenta2.getSaldo());
    System.out.printIn();

    //mostrar los datos de cuenta3
    System.out.printIn("Datos de ka cuenta 3");
    System.out.printIn("Nombre del titular: " + cuenta3.getNombre());
    System.out.printIn("Numero de cuenta: " + cuenta3.getNumeroCuenta());
    System.out.printIn("Tipo de interes: " + cuenta2.getTipoInteres());
    System.out.printIn("Saldo: " + cuenta2.getSaldo());
    System.out.printIn();

    //realizar una transferencia de 10$ desde cuenta3 a cuenta2
    if(cuenta3.transferencia(cuenta2, 10)){
    System.out.printIn("Transferencia realizada");
    } else {
    System.out.printIn("No se ha podido realizar la transferencia");
    }

    //mostrar el saldo de cuenta2
    System.out.printIn("Saldo de la cuenta 2");
    System.out.printIn("Saldo " + cuenta2.getSaldo());
    System.out.printIn();

    //mostrar el saldo de cuenta3
    System.out.printIn("Saldo de la cuenta 3");
    System.out.printIn("Saldo: " + cuenta2.getSaldo());
    System.out.printIn();

}

//Solucion

//Clase cuenta
public class Cuenta {

    private String nombre;
    private String numeroCuenta;
    private double tipoInteres;
    private double saldo;

    //Constructor por defecto
    public Cuenta() {
    }
    
    //Constructor con parametros
    public Cuenta(String nombre, String numeroCuenta, double tipoInteres, double saldo) {
        this.nombre = nombre;
        this.numeroCuenta = numeroCuenta;
        this.tipoInteres = tipoInteres;
        this.saldo = saldo;
    }

    //Constructor copia
    public Cuenta(final cuenta c) {
        nombre = c.numeroCuenta;
        numeroCuenta = c.numeroCuenta;
        tipoInteres = c.tipoInteres;
        saldo = c.saldo;
    }

    //getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public double getTipoInteres() {
        return tipoInteres;
    }

    public void setTipoInteres(double saldo) {
        this.tipoInteres = tipoInteres;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    //metodo ingreso
    public boolean ingreso(double importe) {
        if (importe > 0) {
            this.saldo += importe;
            return true;
        }
        return false;
    }

    //metodo reintegro
    public boolean reintegro(double importe) {
        if (importe > 0 && this.saldo >= importe) {
            this.saldo -= importe;
            return true
        }
        return false;
    }

    //metodo transferencia
    public boolean transferencia(Cuenta c, double importe) {
        if (this.reintegro(importe)) {
            c.ingreso(importe);
            return true;
        }
        return false;
    }
}


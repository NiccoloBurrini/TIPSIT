package esercizio_03_thread;

public class Fattoriale extends Thread {
    private int val;

    public Fattoriale(String name, int val) {
        super(name);
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public int fact(int num) throws NumeroNegativo {
        if (num == 0)
            val = 1;
        else if (num > 0)
            val = num * fact(num - 1);
        else
            throw new NumeroNegativo();
        return val;
    }

    public void run() {
        try {
            System.out.println("Thread: " + getName() + " : " + fact(val));
        } catch (NumeroNegativo e) {
            System.out.println(
                    "ERRORE Thread: " + "(" + getName() + ")");
        }
    }
}
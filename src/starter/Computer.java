package starter;

// вложенные классы
public class Computer {
    class Processor {
        private boolean isRun = false;

        public void start() {
            isRun = true;
            System.out.println("Processor started");
        }

        public void stop() {
            isRun = false;
            System.out.println("Processor stopped");
        }
    }

    class Memory {
        private boolean isData = false;

        public void add() {
            isData = true;
            System.out.println("Data added to memory");
        }

        public void clear() {
            isData = false;
            System.out.println("Memory cleaned");
        }
    }

    // создаем свойства, где хранятся истансы
    Processor i7 = new Processor();
    Memory ddr4 = new Memory();

    // rest оператор в java, для переменного количества аргументов
    public void printInts(int ... ints) {
        for (int i : ints) System.out.println(i);
    }
}

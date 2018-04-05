package ch.hslu.ad.sw05.ex02;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public final class AdditionTask implements Runnable {
    private static Logger LOG = LogManager.getLogger(AdditionTask.class);

    private int[] checksumNumber;
    private volatile Thread runThread;
    private int realChecksum;

    //hilfsvariablen für interrupt wiedereinstig
    private int interruptCount = 0;

    /*variable um zu prüfen wie weit die arbeit ist
    wenn über 50% --> go on, ansonsten real quit
     */
    private int percentrageDone;
    private volatile boolean isStopped = false;

    /**
     * Checksum numbe
     *
     * @param checksumNumber as int array
     */
    public AdditionTask(final int[] checksumNumber) {
        this.checksumNumber = checksumNumber;

        //initialisieren
        realChecksum = 0;
        percentrageDone = 0;
    }

    /**
     * Interrupt Methode
     */
    public void stopRequest() {
        this.isStopped = true;
        if (this.runThread != null) {
            this.runThread.interrupt();
        }
    }

    public boolean isStopped() {
        return this.isStopped;
    }


    /**
     * Berechnet die checksumme
     */
    @Override
    public void run() {
        this.runThread = Thread.currentThread();

        //Arbeitsphase
        try {
            while (this.interruptCount < checksumNumber.length && (Thread.currentThread().isInterrupted() == false)) {
                this.realChecksum += this.checksumNumber[this.interruptCount];
                percentrageDone = (int) (((float) this.interruptCount / this.checksumNumber.length) * 100);
                this.interruptCount++;
                Thread.sleep(50);
            }
            LOG.info(runThread.getName() + ": Quersumme" + Arrays.toString(this.checksumNumber) + " -> " + this.realChecksum);

        } catch (InterruptedException iex) {
            //Thread wurde in den Wartemodus gebracht
            LOG.info("[INTERRUPT]: " + this.runThread.getName());

            //Entscheiden ob Thread beenden oder nicht
            if (this.percentrageDone <= 50) {
                LOG.info(this.runThread.getName() + "[percentageDone]: " + this.percentrageDone + "-> force Interrupt");
                Thread.currentThread().interrupt();
            } else {
                //sonst einfach nochmals starten
                LOG.info(runThread.getName() + "[percentageDone]: " + this.percentrageDone + "-> no Interrupt");
                this.isStopped = false;
                this.run();
            }
        }
        //Aufräumphase
        finally {
            this.realChecksum = 0;
            this.checksumNumber = null;
            this.isStopped = false;
            this.percentrageDone = 0;

            LOG.info(runThread.getName() + " cleanup done");
        }


    }
}

package com.epam.threading;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.Clinic;

public class Patient extends Thread {

	private static final Logger LOG = LogManager.getLogger("Patient");

	private int number;

	private boolean healed = false;
	private boolean bored = false;

	private Clinic clinic;

	public Patient(int number, Clinic clinic) {
		super("Patient" + number);
		this.number = number;
		this.clinic = clinic;
	}

	@Override
	public void run() {
		synchronized (this) {

			try {
				tryToGetDocktorHelp();

				if (!healed) {

					wait(250);

					if (!healed) {
						bored = true;
					}
				}

				if (bored) {
					goAway();
				}
			} catch (InterruptedException e) {
				LOG.error("Patient " + number + " was killed", e);
			}
		}
	}

	public synchronized void heal() throws InterruptedException {
		healed = true;
		sleep(100);
		notify();
		LOG.info("Patient " + number + " healed after waiting in queue");
	}

	private void goAway() {
		LOG.info("Patient " + number + " bored with waitig and goes home to die ill");
		clinic.patientQueue().remove(this);
	}

	private void tryToGetDocktorHelp() throws InterruptedException {
		for (Doctor doc : clinic.getDoctors()) {
			if (doc.tryHeal(number)) {
				LOG.info("Patient " + number + " healed and goes away");
				healed = true;
				break;
			}
		}
		if (!healed) {
			LOG.info("Patient " + number + " couldn't get doctors help and goes to the queue");
			boolean offer = clinic.patientQueue().offer(this);
			if (!offer) {
				Thread.interrupted();
				throw new InterruptedException();
			}
		}
	}

	public int getNumber() {
		return number;
	}

}

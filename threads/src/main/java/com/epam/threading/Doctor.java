package com.epam.threading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.Clinic;

public class Doctor extends Thread {

	private static final Logger LOG = LogManager.getLogger("Doctor");

	private int number;
	private Clinic clinic;

	private int patientsHealed = 0;

	private static final int MAX_PATIENTS_HEALED = 5;

	private Lock doctorBusiness = new ReentrantLock();

	public Doctor(int number, Clinic clinic) {
		super("Doctor-" + number);
		this.number = number;
		this.clinic = clinic;
	}

	@Override
	public void run() {
		try {

			synchronized (this) {
				while (canHealMore()) {
					wait();

					while (canHealMore()) {
						Patient poll = clinic.patientQueue().poll();

						if (poll == null) {
							LOG.info("Doctor " + number + " got nobody from queue and going to wait");
							break;
						}

						healPatient(poll);
					}
				}
			}
		} catch (InterruptedException e) {
			LOG.error("Docktor " + number + " was killed", e);
		}
		LOG.info("Docktor " + number + " exausted and goes home");
	}

	private void healPatient(Patient poll) throws InterruptedException {
		LOG.info("Doctor " + number + " got patient" + poll.getNumber() + " from queue and going to wait");
		poll.heal();
		patientsHealed++;
		LOG.info("Doctor " + number + " healed patient" + poll.getNumber() + " taken from the queue");
	}

	private boolean canHealMore() {
		return patientsHealed < MAX_PATIENTS_HEALED;
	}

	public boolean tryHeal(int patientNumber) throws InterruptedException {

		if (getState().equals(State.WAITING) && doctorBusiness.tryLock()) {
			synchronized (this) {
				LOG.info("Doctor " + number + " started healing patient " + patientNumber);
				sleep(100);
				LOG.info("Doctor " + number + " healed patient " + patientNumber);
				patientsHealed++;
				notify();
				doctorBusiness.unlock();
				return true;
			}
		}
		return false;
	}

}

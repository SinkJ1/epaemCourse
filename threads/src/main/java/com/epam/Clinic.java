package com.epam;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import com.epam.threading.Doctor;
import com.epam.threading.Patient;

public class Clinic {

	static List<Doctor> doctors = new ArrayList<Doctor>();
	static BlockingQueue<Patient> patientQueue = new ArrayBlockingQueue<Patient>(20, true);

	public static void main(String[] args) throws InterruptedException {

		Clinic clinic = new Clinic();

		for (int i = 1; i <= 2; i++) {
			doctors.add(new Doctor(i, clinic));
		}

		doctors.forEach(Thread::start);

		Thread.sleep(100);

		for (int i = 1; i <= 10; i++) {
			new Patient(i, clinic).start();
		}

		Thread.sleep(500);

		for (int i = 11; i <= 20; i++) {
			new Patient(i, clinic).start();
		}
	}

	public List<Doctor> getDoctors() {
		return doctors;
	}

	public BlockingQueue<Patient> patientQueue() {
		return patientQueue;
	}

}

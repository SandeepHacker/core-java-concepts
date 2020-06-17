package sun.containers.queue;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import sun.containers.array.filler.Generator;
import sun.containers.array.filler.RandomGenerator;

public class Passenger implements Serializable,Comparable<Passenger> {
	
	private final String pnr;

	private final String flightNumber;
	
	private final String name;
	
	private final LocalDate time;
	
	public Passenger(String name) {
		Generator<String> gen = new RandomGenerator.String();
		Generator<LocalDate> gen1 = new RandomGenerator.LocalDate();
	this.name=name;
	pnr=gen.next();
	flightNumber=gen.next();
	time=gen1.next();
	}
	

	@Override
	public int compareTo(Passenger o) {
		if(o.pnr.equals(this.pnr))
			throw new DuplicatePNR(" PNR "+this.pnr+" already generated:::");
		int flag = o instanceof Passenger && this.time.isBefore(o.time)?-11:this.time.isAfter(o.time)?11:0;
		return flag;
	}


	@Override
	public String toString() {
		return "[PNR ::: " + pnr + " <--> FlightNumber ::: " + flightNumber
				+ " <--> Name ::: " + name + " <--> Journey Time ::: " + time + "]";
	}
	public String getPnr() {
		return pnr;
	}


	public String getFlightNumber() {
		return flightNumber;
	}


	public String getName() {
		return name;
	}


	public LocalDate getTime() {
		return time;
	}

	
	static class DuplicatePNR extends RuntimeException{
		
		 public DuplicatePNR(String msf) {
			super(msf);
		}
		
	}
	
}

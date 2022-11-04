package types;

import socket.Response;

public class WaitingFor {
	
	private volatile Response goal;
	private volatile Response actualState;
	
	public WaitingFor() {
		
	}
	
	public void waitFor(Response goal) {
		this.goal = goal;
		
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Waiting for "+goal);
				while (goal!=actualState) {
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {}
				}
				System.out.println("Not waiting anymore");
			}
		});
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
		}
	}
	
	public void setActualState(Response actualState) {
		this.actualState = actualState;
	}
	

}

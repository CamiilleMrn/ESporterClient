package types;

import socket.Response;

public class WaitingFor {
	
	private volatile Response[] goal;
	private volatile Response actualState;
	
	public WaitingFor() {
		
	}
	
	public void waitFor(Response[] goal) {
		this.goal = goal;
		
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Waiting for "+goal);
				while (continueWaiting()) {
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
	
	public boolean continueWaiting() {
		for (Response r : goal) {
			if (actualState == r) {
				return false;
			}
		}
		return true;
	}
	
	public void setActualState(Response actualState) {
		this.actualState = actualState;
	}
	
	public Response getActualState() {
		return actualState;
	}
	
	
	

}

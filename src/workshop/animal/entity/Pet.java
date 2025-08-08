package workshop.animal.entity;

public interface Pet {
	String getName(); 	// public abstract가 생략되어있음
	void setName(String name);
	
	public abstract void play(); 
}

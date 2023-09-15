package com.arnavmangla.lab4;

class Record extends AbstractRecord {
	private Object valueObject; // Concreting
	public Record(Object val) { // Concreting
		valueObject=val;
		// String s = "-100";
		// Integer.parseInt("ke");
	}
	
	
	
	public Object key() { // Can you generalize or abstract this further away?
		
		try {
			return Long.parseLong(value().toString());
		} catch(NumberFormatException e_int){
			try{
				return Math.round(Double.parseDouble(value().toString()));
			} catch (NumberFormatException ignored){}
		}
		return (long) (value().toString()).charAt(0);
	}
	
	public Object value() {
		return valueObject;
	}
	
	public Comparison compare(AbstractRecord another) {
		// TODO: Suggested by Jayanth KVR to change the typecast from long to int, because key() returns int/long (or something like that)
		Long k1 = (Long) key(), k2 = (Long) another.key(); // The same ad-hoc arrangement
		boolean b1 = k1 <= k2, b2 = k1 >= k2; // All this should be evident
		if(b1 && b2) return Comparison.MATCHING;
		if(b1 && !b2) return Comparison.PREDECESSOR;
		if(!b1 && b2) return Comparison.SUCCESSOR;
		return Comparison.INCOMPARABLE;
	}
	public void show() {
		System.out.print(" [Key: " + key() + "] [Value: "+value()+"] ");
	}
}

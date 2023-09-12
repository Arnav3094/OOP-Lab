package com.arnavmangla.lab4;

class Record extends AbstractRecord {
	private Object valueObject = 0; // Concreting
	public Record(Object val) { // Concreting
		valueObject=val;
		// String s = "-100";
		// Integer.parseInt("ke");
	}
	
	
	
	public Object key() { // Can you generalize or abstract this further away?
		
		try {
			return Integer.parseInt((String)value());
		} catch(NumberFormatException e_int){
			try{
				return Math.round(Double.parseDouble((String) value()));
			} catch (NumberFormatException ignored){}
		}
		return (int) ((String)value()).charAt(0);
	}
	public Object value() {
		return valueObject;
	}
	public Comparison compare(AbstractRecord another) {
		long k1=(long)key(), k2=(long)(another.key()); // The same ad-hoc arrangement
		boolean b1=k1<=k2, b2=k1>=k2; // All this should be evident
		if(b1 && b2) return Comparison.MATCHING;
		if(b1 && !b2) return Comparison.PREDECESSOR;
		if(!b1 && b2) return Comparison.SUCCESSOR;
		return Comparison.INCOMPARABLE;
	}
	public void show() {
		System.out.print(" [Key: " + key() + "] [Value: "+value()+"] ");
	}
}

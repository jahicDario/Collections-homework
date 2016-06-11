package main;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Bigram {

	public void ispisiFrekPojavljivanjaBigrama(String s) {
		Map<String, Integer> m = new HashMap<>();
		for (int i = 0; i < s.length()-2; i++) {
			String s2 = s.substring(i, i+2);
			if (m.containsKey(s2)) {
				Iterator entries = m.entrySet().iterator();
				while (entries.hasNext()) {
					Entry thisEntry = (Entry) entries.next();
					String key = (String) thisEntry.getKey();
					int value = (int) thisEntry.getValue();
					if (key.equals(s2)) {
						thisEntry.setValue(value + 1);
						break;
					}
				}
			} else {
				m.put(s2, 1);
			}
		}
		ispisiElementeMape(m);
	}
	public void ispisiElementeMape(Map<String, Integer> m ){
		Iterator entries = m.entrySet().iterator();
		while (entries.hasNext()) {
		  Entry thisEntry = (Entry) entries.next();
		  Object key = thisEntry.getKey();
		  Object value = thisEntry.getValue();
		  System.out.println(key + ": " + value);
		}
	}

	public static void main(String[] args) {
		Bigram b = new Bigram();
		b.ispisiFrekPojavljivanjaBigrama("abbcceeeeeeabcc");

	}

}

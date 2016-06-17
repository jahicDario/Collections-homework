package main;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Bigram {

	public Map<String, Integer> ispisiFrekPojavljivanjaBigrama(String s) {
		Map<String, Integer> m = new HashMap<>();
		for (int i = 0; i < s.length()-1; i++) {
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
		//koristimo return da bi mogli da iskoristimo datu mapu za sledeci zadatak predvidjanja 3 karaktera.
		return m;
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
	public void predvidiNarednaTriKaraktera(String s, Map<String, Integer> m){
		int a = 0;
		String s2 = s.substring(s.length()-1);
		while(a <3 ){
		Iterator entries = m.entrySet().iterator();
		//Map<String, Integer> m2  = new HashMap<>();
		int [] frekvencije = new int[100];
		int i = 0;
		//Iterator entries2 = m2.entrySet().iterator();
		while (entries.hasNext()) {
		  Entry thisEntry = (Entry) entries.next();
		  String key = (String) thisEntry.getKey();
		  int value = (int) thisEntry.getValue();
		  if(key.startsWith(s2)){
			  frekvencije[i] = value;
			  i++;
		  }
		}
		//i je brEl
		int max = nadjiNajveci(frekvencije, i);
		entries = m.entrySet().iterator();
		while (entries.hasNext()) {
			  Entry thisEntry = (Entry) entries.next();
			  String key = (String) thisEntry.getKey();
			  int value = (int) thisEntry.getValue();
			  if(value == max && key.startsWith(s2)){
				  s2 = key.substring(key.length()-1);
				  System.out.println(s2);
				  a++;
				  break;
			  }
			}
		
		}
	}
	private int nadjiNajveci(int[] frekvencije, int i) {
		int max = frekvencije[0];
		for (int j = 0; j< frekvencije[j]; j++) {
			if(frekvencije[j]>max){
				max = frekvencije[j];
			}
		}
		return max;
	}
	public static void main(String[] args) {
		Bigram b = new Bigram();
		Map<String, Integer> m = b.ispisiFrekPojavljivanjaBigrama("abbcceeeeeeabcc");
		b.predvidiNarednaTriKaraktera("ja", m);
		
	
	}

}

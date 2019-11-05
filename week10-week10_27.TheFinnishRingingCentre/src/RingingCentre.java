
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author slier
 */
public class RingingCentre {

	private Map<Bird, List<String>> observations;

	public RingingCentre() {
		this.observations = new HashMap<Bird, List<String>>();
	}

	public void observe(Bird bird, String place) {
		if (!this.observations.containsKey(bird)) {
			this.observations.put(bird, new ArrayList<String>());
		}

		this.observations.get(bird).add(place);
	}

	public void observations(Bird bird) {
		if (this.observations.containsKey(bird)) {
			for (Bird b : this.observations.keySet()) {
				if (b.equals(bird)) {
					System.out.println(b + " observations: " + this.observations.get(b).size());

					for (String place : this.observations.get(b)) {
						System.out.println(place);
					}
				}
			}
		} else {
			System.out.println(bird + " observations: 0");
		}
	}

}

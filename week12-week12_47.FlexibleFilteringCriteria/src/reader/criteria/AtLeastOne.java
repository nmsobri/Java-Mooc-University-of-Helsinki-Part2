/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reader.criteria;

/**
 *
 * @author slier
 */
public class AtLeastOne implements Criterion {

	private Criterion[] c;

	public AtLeastOne(Criterion... c) {
		this.c = c;
	}

	@Override
	public boolean complies(String line) {
		for (int i = 0; i < this.c.length; i++) {
			if (this.c[i].complies(line)) {
				return true;
			}
		}

		return false;
	}

}

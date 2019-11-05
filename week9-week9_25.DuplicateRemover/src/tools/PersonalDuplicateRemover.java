/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author slier
 */
public class PersonalDuplicateRemover implements DuplicateRemover {

	private Set<String> sets;
	private int duplicateDetected;

	public PersonalDuplicateRemover() {
		this.sets = new HashSet<String>();
		this.duplicateDetected = 0;
	}

	@Override
	public void add(String characterString) {
		if (!this.sets.add(characterString)) {
			this.duplicateDetected++;
		}
	}

	@Override
	public int getNumberOfDetectedDuplicates() {
		return this.duplicateDetected;
	}

	@Override
	public Set<String> getUniqueCharacterStrings() {
		return this.sets;
	}

	@Override
	public void empty() {
		this.duplicateDetected = 0;
		this.sets.clear();
	}

}

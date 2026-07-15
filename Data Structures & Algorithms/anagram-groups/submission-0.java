class StringGroup {
	String str;
	int group;

	public StringGroup(String str, int group) {
		this.str = str;
		this.group = group;
	}
}

class Solution {

	public List<List<String>> groupAnagrams(String[] strs) {
		StringGroup[] stringGroups = new StringGroup[strs.length];
		for (int i=0; i<strs.length; i++) {
			stringGroups[i] = new StringGroup(strs[i], -1);
		}
		StringGroup strGroup1, strGroup2;
		int groupIdx = 0;
		for (int i=0; i<stringGroups.length; i++) {
			strGroup1 = stringGroups[i];
			if (strGroup1.group != -1)
				continue;
			strGroup1.group = groupIdx;
			for (int j=i+1; j<stringGroups.length; j++) {
				strGroup2 = stringGroups[j];
				if (strGroup2.group != -1)
					continue;
				if (isAnagram(strGroup1.str, strGroup2.str)) {
					strGroup2.group = groupIdx;
				}
			}
			groupIdx++;
		}

		List<List<String>> anagramGroups = new ArrayList<>(groupIdx);
		for (int i=0; i<groupIdx; i++) {
			anagramGroups.add(new ArrayList<>());
		}

		for (int i=0; i<stringGroups.length; i++) {
			anagramGroups.get(stringGroups[i].group).add(stringGroups[i].str);
		}

		return anagramGroups;

	}

	private boolean isAnagram(String str1, String str2) {
		if (str1.length() != str2.length())
			return false;

		int[] charCount = new int[26];
		for (int i=0; i<str1.length(); i++) {
			charCount[str1.charAt(i) - 'a']++;
			charCount[str2.charAt(i) - 'a']--;
		}
		for (int i=0; i<26; i++) {
			if (charCount[i] != 0)
				return false;
		}
		return true;
	}
}
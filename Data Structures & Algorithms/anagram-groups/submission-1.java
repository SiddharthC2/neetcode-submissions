class Solution {

	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> stringAnagramMap = new HashMap<>();
		String strSorted;
		char[] strSortedArr;
		for (int i=0; i<strs.length; i++) {
			strSortedArr = strs[i].toCharArray();
			Arrays.sort(strSortedArr);
			strSorted = new String(strSortedArr);
			if (!stringAnagramMap.containsKey(strSorted)) {
				stringAnagramMap.put(strSorted, new ArrayList<>());
			}
			stringAnagramMap.get(strSorted).add(strs[i]);
		}

		List<List<String>> anagramGroup = new ArrayList();
		for (String str: stringAnagramMap.keySet()) {
			anagramGroup.add(stringAnagramMap.get(str));
		}

		return anagramGroup;
	}
}
class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        Map<String, Boolean> folderHashMap = new HashMap<>();
        List<String> listAnswer = new ArrayList<>();
        for (int i = 0; i < folder.length; i++) {
            if (!isSubfolder(folder[i], folderHashMap)) {
                folderHashMap.put(folder[i], true);
                listAnswer.add(folder[i]);
            }
        }
        return listAnswer;
    }
    private boolean isSubfolder (String folder, Map<String, Boolean> folderHashMap) {
        int slashIndex = 0;
        int nextSlashIndex = 0;
        while (slashIndex <  folder.length() && slashIndex >= 0) {
            slashIndex = folder.indexOf('/', slashIndex);
            nextSlashIndex = folder.indexOf('/', slashIndex + 1);
            String subStr = folder.substring(0, nextSlashIndex < 0 ? folder.length() : nextSlashIndex);
            if (folderHashMap.containsKey(subStr)) return true;
            slashIndex = nextSlashIndex;
        }
        return false;
    }
}


// I need to iterate over all the input folder and will need to check whether that particular folder
// is a sub folder or not.

// If folder[i] is a sub folder then will need to remove that folder means I should not add that folder into
// the answer folder list else will need to add that folder into the answer folder list.
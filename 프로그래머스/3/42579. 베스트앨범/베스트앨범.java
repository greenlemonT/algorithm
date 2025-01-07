import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {

        Map<String, Integer> genrePlayCount = new HashMap<>();
        Map<String, List<int[]>> genreSongs = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            genrePlayCount.put(genres[i], genrePlayCount.getOrDefault(genres[i], 0) + plays[i]);
            //genreSongs.putIfAbsent(genres[i], new ArrayList<>());
            if (!genreSongs.containsKey(genres[i])) {
                genreSongs.put(genres[i], new ArrayList<>());
            }
            genreSongs.get(genres[i]).add(new int[] {i, plays[i]});
        }

        List<String> sortedGenres = new ArrayList<>(genrePlayCount.keySet());
        sortedGenres.sort((g1, g2) -> Integer.compare(genrePlayCount.get(g2), genrePlayCount.get(g1)));
        List<Integer> bestAlbum = new ArrayList<>();

        for (String genre : sortedGenres) {
            List<int[]> songs = genreSongs.get(genre);
            songs.sort((s1, s2) -> s2[1] == s1[1] ? s1[0] - s2[0] : s2[1] - s1[1]);

            for (int i = 0; i < Math.min(2, songs.size()); i++) {
                bestAlbum.add(songs.get(i)[0]);
            }
        }

        return bestAlbum.stream().mapToInt(Integer::intValue).toArray();
    }
}
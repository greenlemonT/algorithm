
import java.util.*;



    class Solution {

        static int[][] scoreBoard;

        public int solution(int[] picks, String[] minerals) {
            int answer = 0;

            // 피로도 테이블
            scoreBoard = new int[][]{{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};

            int totalPicks = Arrays.stream(picks).sum();

            // 광물 정보 저장 (다이아, 철, 돌 피로도를 각각 저장)
            List<int[]> mineralGroups = new ArrayList<>();

            for (int i = 0; i < minerals.length; i += 5) {
                if (totalPicks == 0) break;

                int dia = 0, iron = 0, stone = 0;

                for (int j = i; j < i + 5; j++) {
                    if (j == minerals.length) break;

                    String mineral = minerals[j];
                    int val = mineral.equals("iron") ? 1 : mineral.equals("stone") ? 2 : 0;

                    dia += scoreBoard[0][val];
                    iron += scoreBoard[1][val];
                    stone += scoreBoard[2][val];
                }

                // 각 그룹의 피로도 저장
                mineralGroups.add(new int[]{dia, iron, stone});
                totalPicks--;
            }

            // 돌 피로도가 높은 순서로 정렬
            mineralGroups.sort((o1, o2) -> o2[2] - o1[2]);

            // 최적의 곡괭이 사용 순서대로 피로도 계산
            for (int[] group : mineralGroups) {
                int dia = group[0];
                int iron = group[1];
                int stone = group[2];

                if (picks[0] > 0) {
                    answer += dia;
                    picks[0]--;
                    continue;
                }
                if (picks[1] > 0) {
                    answer += iron;
                    picks[1]--;
                    continue;
                }
                if (picks[2] > 0) {
                    answer += stone;
                    picks[2]--;
                    continue;
                }
            }

            return answer;
        }
    }



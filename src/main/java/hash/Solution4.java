package main.java.hash;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * 베스트앨범 알고리즘 클래스
 * 
 * @author RWB
 *
 * @since 2020.08.03 Sun 00:52
 */
public class Solution4
{
	/**
	 * 메인 함수
	 * 
	 * @param {String[]} args: 파라미터
	 * 
	 * @return {Active}: 프로그램 동작
	 */
	public static void main(String[] args)
	{
		// case 1: [4, 1, 3, 0] ()
		String[] genres1 = { "classic", "pop", "classic", "classic", "pop" };
		int[] plays1 = { 500, 600, 150, 800, 2500 };
		
		int[] result1 = solution(genres1, plays1);
		
		System.out.println(result1);
	}
	
	/**
	 * 베스트앨범 알고리즘
	 * 
	 * 1. 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
	 * 2. 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
	 * 3. 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
	 * 
	 * gernes[i]는 고유번호가 i인 노래의 장르입니다.
	 * plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
	 * gernes와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
	 * 장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
	 * 모든 장르는 재생된 횟수가 다릅니다.
	 * 
	 * @param {String[]} genres: 장르 리스트
	 * @param {int[]} plays: 재생 횟수 리스트
	 * 
	 * @return {int[]} answer: 노래 수록 기준
	 */
	private static int[] solution(String[] genres, int[] plays)
	{
		int[] answer = {};
		
		HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
		TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>();
		
		// 두 번째 조건에 의거하여 genres와 plays의 길이가 같으므로 성립
		for (int i = 0; i < genres.length; i++)
		{
			// 장르별 총 재생횟수를 map에 저장
			hashMap.put(genres[i], hashMap.getOrDefault(genres[i], 0) + plays[i]);
			treeMap.put(plays[i], genres[i]);
		}
		
		return answer;
	}
}

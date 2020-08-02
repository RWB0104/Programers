package main.java.hash;

import java.util.HashMap;

/**
 * 위장 알고리즘 클래스
 * 
 * @author RWB
 *
 * @since 2020.08.02 Sat 23:58
 */
public class Solution3
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
		// case 1: 5 (headgear 두 개, eyewear 한 개이므로 5가지 조합이 가능)
		String[][] clothes1 = { { "yellow_hat", "headgear" }, { "blue_sunglasses", "eyewear" }, { "green_turban", "headgear" } };
		
		// case 2: 3 (face 세 개이므로 3가지 조합이 가능)
		String[][] clothes2 = { { "crow_mask", "face" }, { "blue_sunglasses", "face" }, { "smoky_makeup", "face" } };
		
		int result1 = solution(clothes1);
		int result2 = solution(clothes2);
		
		System.out.println(result1);
		System.out.println(result2);
	}
	
	/**
	 * 위장 알고리즘
	 * 
	 * clothes의 각 행은 [의상의 이름, 의상의 종류]로 이루어져 있습니다.
	 * 스파이가 가진 의상의 수는 1개 이상 30개 이하입니다.
	 * 같은 이름을 가진 의상은 존재하지 않습니다.
	 * clothes의 모든 원소는 문자열로 이루어져 있습니다.
	 * 모든 문자열의 길이는 1 이상 20 이하인 자연수이고 알파벳 소문자 또는 '_'로만 이루어져 있습니다.
	 * 스파이는 하루에 최소 한 개의 의상은 입습니다.
	 * 
	 * @param {String[][]} clothes: 의상 목록
	 * 
	 * @return {int} answer: 서로 다른 의상 조합의 수
	 */
	private static int solution(String[][] clothes)
	{
		int answer = 1;
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		for (String[] cloth : clothes)
		{
			// 의상의 종류를 기준으로 map에 넣음 (의상 이름은 중요하지 않음)
			map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
		}
		
		for (String key : map.keySet())
		{
			// value에 옷을 입지 않는 경우 1을 더하고 전체를 곱함
			answer *= map.get(key) + 1;
		}
		
		// 6번 째 조건에 의거 아예 옷을 입지않는 경우를 제외함.
		answer--;
		
		return answer;
	}
}

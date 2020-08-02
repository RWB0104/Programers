package main.java.hash;

import java.util.HashMap;

/**
 * 완주하지 못한 선수 알고리즘 클래스
 * 
 * @author RWB
 *
 * @since 2020.08.02 Sat 16:49
 */
public class Solution1
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
		// case 1: leo (참여자 명단에는 있지만, 완주자 명단에는 없음)
		String[] participant1 = { "leo", "kiki", "eden" };
		String[] completion1 = { "eden", "kiki" };
		
		// case 2: vinko (참여자 명단에는 있지만, 완주자 명단에는 없음)
		String[] participant2 = { "marina", "josipa", "nikola", "vinko", "filipa" };
		String[] completion2 = { "josipa", "filipa", "marina", "nikola" };
		
		// case 3: mislav (참여자 명단에는 동명이인 두 명이 있지만, 완주자 명단엔 한 명만 있음)
		String[] participant3 = { "mislav", "stanko", "mislav", "ana" };
		String[] completion3 = { "stanko", "ana", "mislav" };
		
		String result1 = solution(participant1, completion1);
		String result2 = solution(participant2, completion2);
		String result3 = solution(participant3, completion3);
		
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
	}
	
	/**
	 * 완주하지 못한 선수 알고리즘
	 * 
	 * 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
	 * completion의 길이는 participant의 길이보다 1 작습니다.
	 * 참자가의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
	 * 참가자 중에는 동명이인이 있을 수 있습니다.
	 * 
	 * @param {String[]} participant: 참가자
	 * @param {String[]} completion: 완주자
	 * 
	 * @return {String} answer: 완주하지 못한 선수의 이름
	 */
	private static String solution(String[] participant, String[] completion)
	{
		String answer = "";
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		for (String name : participant)
		{
			// 참가자의 이름을 HashMap에 넣고 value에 1을 더함
			map.put(name, map.getOrDefault(name, 0) + 1);
		}
		
		for (String name : completion)
		{
			// 참가자의 이름이 완주자에 있다면 value에 1을 뺌
			map.put(name, map.get(name) - 1);
		}
		
		for (String key : map.keySet())
		{
			if (map.get(key) != 0)
			{
				answer = key;
			}
		}
		
		return answer;
	}
}

package main.java.hash;

import java.util.Arrays;

/**
 * 전화번호 목록 알고리즘 클래스
 * 
 * @author RWB
 *
 * @since 2020.08.02 Sat 23:36
 */
public class Solution2
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
		// case 1: false (1번 째 번호가 3번 째 번호의 접두사)
		String[] phone_book1 = { "119", "97674223", "1195524421" };
		
		// case 2: true (번호 목록 중 한 번호가 다른 번호의 접두사로 시작되는 경우가 없음)
		String[] phone_book2 = { "123", "456", "789" };
		
		// case 3: false (1번 째 번호가 두 번째 번호의 접두사)
		String[] phone_book3 = { "12", "123", "1235", "567", "88" };
		
		boolean result1 = solution(phone_book1);
		boolean result2 = solution(phone_book2);
		boolean result3 = solution(phone_book3);
		
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
	}
	
	/**
	 * 전화번호 목록 알고리즘
	 * 
	 * phone_book의 길이는 1 이상, 1,000,000 이하입니다.
	 * 각 전화번호의 길이는 1 이상 20 이하입니다.
	 * 
	 * @param {String[]} phone_book: 전화번호 배열
	 * 
	 * @return {boolean} answer: 어떤 번호가 다른 번호의 접두어인 경우의 유무
	 */
	private static boolean solution(String[] phone_book)
	{
		boolean answer = true;
		
		// 빠른 검색을 위해 배열 정렬
		Arrays.sort(phone_book);
		
		for (int i = 0; i < phone_book.length - 1; i++)
		{
			// 접두사를 찾는 것이 조건이므로, 정렬된 배열에서 서로 옆에 위치함을 이용하여 자신 기준 오른쪽의 값만 비교
			boolean hasStart = phone_book[i + 1].startsWith(phone_book[i]);
			
			if (hasStart)
			{
				answer = false;
				break;
			}
		}
		
		return answer;
	}
}

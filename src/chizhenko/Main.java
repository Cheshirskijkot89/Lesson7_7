package chizhenko;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String text;
		int min = -1;
		int temp = 0;
		int halphLength = 0;
		int textLength = 0;
		boolean ident = true;
		ArrayList<String> list = new ArrayList<String>();

		System.out.println("Введите строку цифр");
		text = sc.nextLine();
		sc.close();

		textLength = text.length();
		halphLength = textLength / 2;

		for (int lengthTemp = 1; lengthTemp <= halphLength; lengthTemp++) {
			for (int startTemp = 0; startTemp < textLength; startTemp = startTemp + lengthTemp) {
				list.add(text.substring(startTemp, Math.min(startTemp + lengthTemp, textLength)));
			}
			//System.out.println(list.toString());

			ident = true;

			for (int i = 1; i < list.size(); i++) {

				if (list.get(i).equals(list.get(i - 1)) == false) {
					ident = false;
					break;
				}
			}

			if (ident) {
				if (min == -1) {
					min = Integer.parseInt(list.get(0));
				} else {
					temp = Integer.parseInt(list.get(0));
					min = Math.min(min, temp);
				}
			}

			list.clear();
		}

		System.out.println(min);

	}
}

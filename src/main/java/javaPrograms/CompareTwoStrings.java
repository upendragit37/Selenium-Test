package javaPrograms;

public class CompareTwoStrings {

	public static void main(String args[]) {
		String string1 = "https://teams.microsoft.com/l/meetup-join/19%3ameeting_MGM4OWZkZGUtMGNmYy00NGUyLTlhYzQtY2YxNmRiOWYwNjIx%40thread.v2/0?context=%7b%22Tid%22%3a%"
				+ "22982035bb-0c38-4f2e-8ce0-49e49bd4ee04%22%2c%22Oid%22%3a%22f2a8dbf4-1bd9-4fb5-8f2e-f17688e9301a%22%7d";
		String string2 = "https://teams.microsoft.com/l/meetup-join/19%3ameeting_MWVjOTI4ZmUtOTA0MS00MzFhLWEyZjItODE4ZmYyYjQyZTEz%40thread.v2/0?context=%7b%22Tid%22%3a%22982035b"
				+ "b-0c38-4f2e-8ce0-49e49bd4ee04%22%2c%22Oid%22%3a%22446aafc7-7bd2-481c-98ed-fac23fbdd660%22%7d";
		String string3="https://teams.microsoft.com/l/meetup-join/19%3ameeting_YWU2OGQ0MjUtNWU1OS00MTZkLWFiMTgtZDVhN2Q1ZjgwZDFj%40thread.v2/0?context=%7b%22Tid%22%3a%22982035bb"
				+ "-0c38-4f2e-8ce0-49e49bd4ee04%22%2c%22Oid%22%3a%22d48fa619-44d4-4b18-897c-2f3d9cf96ac7%22%7d";
		char split1[] = string1.toCharArray();
		char split2[] = string1.toCharArray();

		if (string1.equals(string3)) {
			System.out.println("Equal");
		} else {
			System.out.println("Not Equal");
		}
	}
}

package codiceFiscale;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CodiceFiscale {

	private static final String COMMA_DELIMITER = ",";
	public static String vocalsString = "[AEIOUaeiou]";
	public static String consonantsString = "[BCDFGHJKLMNPQRSTVWYXZ]";

	@SuppressWarnings("rawtypes")
	private static ArrayList leggiCsv() {
		List<String> datiComune = new ArrayList<>();
		String filePath = "yourFilePath";
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] values = line.split(COMMA_DELIMITER);
				datiComune.addAll(Arrays.asList(values));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return (ArrayList) datiComune;

	}

	public static String findAndGetCatastalCode(ArrayList<String> listaCatasto, String cityToFind) {
		String catCode = "XXXXX";
		String cityTemp = "";
		for (int i = 0; i < listaCatasto.size(); i++) {

			if ((listaCatasto.get(i).split(";")[1].equals(cityToFind.toUpperCase()))) {

				String catCodeTemp = listaCatasto.get(i);

				int iend = catCodeTemp.indexOf(';');
				if (iend != -1) {
					cityTemp = catCodeTemp.substring(iend + 1);
				}

				if (cityTemp.equals(cityToFind.toUpperCase())) {
					if (iend != -1) {
						catCode = catCodeTemp.substring(0, iend);
					}
				} else
					break;

			}
		}

		return catCode;
	}

	public static String deleteSpaces(String strWithSpaces) {
		String strWithoutSpace = strWithSpaces.replaceAll(" ", "");
		return strWithoutSpace;
	}

	public static String getThreeLettersSurname(String surname) {

		String surnameF = surname.toUpperCase().replaceAll(vocalsString, "");
		String surnameF2 = surname.toUpperCase().replaceAll(consonantsString, "");
		String threeLetters = "";
		if (surnameF.length() == 1) {
			threeLetters = surnameF.substring(0, 1) + surname.substring(1, 2) + "x";
		}

		else if (surnameF.length() < 3) {
			surnameF = surname.toUpperCase().replaceAll(vocalsString, "").substring(0, surnameF.length());
			threeLetters = surnameF + surnameF2.substring(0, 1);

		} else if (surnameF.length() >= 3) {
			threeLetters = surnameF.substring(0, 3);
		}

		return threeLetters.toUpperCase();
	}

	public static String getThreeLettersName(String name) {

		String threeLetters = "";
		String nameF = name.toUpperCase().replaceAll(vocalsString, "");
		String nameF2 = name.toUpperCase().replaceAll(consonantsString, "");

		if (nameF.length() < 2) {
			nameF = name.toUpperCase().replaceAll(vocalsString, "").substring(0, nameF.length());
			threeLetters = nameF + nameF2.substring(0, 2);

		} else if (nameF.length() < 3) {
			nameF = name.toUpperCase().replaceAll(vocalsString, "").substring(0, nameF.length());
			threeLetters = nameF + nameF2.substring(0, 1);

		} else if (nameF.length() > 3) {
			threeLetters = nameF.substring(0, 1) + nameF.substring(2, 4);

		} else {
			threeLetters = nameF.substring(0, 3);

		}

		return threeLetters.toUpperCase();
	}

	public static String getTwoYearDigits(Integer anno) {

		String year = anno.toString();
		char[] yearChar = year.toCharArray();
		String twoYearDigits = "";
		for (int i = 0; i < year.length(); i++) {
			if (i > 1) {
				twoYearDigits += yearChar[i];
			}
		}

		return twoYearDigits.toUpperCase();

	}

	public static String getOneMonthDigit(Integer mese) {

		String month = "";
		switch (mese) {
		case 1:
			month = "A";
			break;
		case 2:
			month = "B";
			break;
		case 3:
			month = "C";
			break;
		case 4:
			month = "D";
			break;
		case 5:
			month = "E";
			break;
		case 6:
			month = "H";
			break;
		case 7:
			month = "L";
			break;
		case 8:
			month = "M";
			break;
		case 9:
			month = "P";
			break;
		case 10:
			month = "R";
			break;
		case 11:
			month = "S";
			break;
		case 12:
			month = "T";
			break;

		}

		return month.toUpperCase();

	}

	public static String getDayAndGenderDigits(Integer giorno, String sesso) {

		String twoDigits = "";

		if (sesso.toLowerCase() == "m") {
			if (giorno < 10) {
				twoDigits = "0" + giorno.toString();
			} else
				twoDigits = giorno.toString();
		}
		if (sesso.toLowerCase() == "f") {
			Integer femaleDigits = giorno + 40;
			twoDigits = femaleDigits.toString();
		}

		return twoDigits.toUpperCase();
	}

	public static Integer calcValueEvenArr(char[] EvenArr) {
		Integer EvenValue = 0;

		for (int i = 0; i < EvenArr.length; i++) {
			switch (EvenArr[i]) {
			case '0':
				EvenValue += 0;
				break;
			case '1':
				EvenValue += 1;
				break;
			case '2':
				EvenValue += 2;
				break;
			case '3':
				EvenValue += 3;
				break;
			case '4':
				EvenValue += 4;
				break;
			case '5':
				EvenValue += 5;
				break;
			case '6':
				EvenValue += 6;
				break;
			case '7':
				EvenValue += 7;
				break;
			case '8':
				EvenValue += 8;
				break;
			case '9':
				EvenValue += 9;
				break;
			case 'A':
				EvenValue += 0;
				break;
			case 'B':
				EvenValue += 1;
				break;
			case 'C':
				EvenValue += 2;
				break;
			case 'D':
				EvenValue += 3;
				break;
			case 'E':
				EvenValue += 4;
				break;
			case 'F':
				EvenValue += 5;
				break;
			case 'G':
				EvenValue += 6;
				break;
			case 'H':
				EvenValue += 7;
				break;
			case 'I':
				EvenValue += 8;
				break;
			case 'J':
				EvenValue += 9;
				break;
			case 'K':
				EvenValue += 10;
				break;
			case 'L':
				EvenValue += 11;
				break;
			case 'M':
				EvenValue += 12;
				break;
			case 'N':
				EvenValue += 13;
				break;
			case 'O':
				EvenValue += 14;
				break;
			case 'P':
				EvenValue += 15;
				break;
			case 'Q':
				EvenValue += 16;
				break;
			case 'R':
				EvenValue += 17;
				break;
			case 'S':
				EvenValue += 18;
				break;
			case 'T':
				EvenValue += 19;
				break;
			case 'U':
				EvenValue += 20;
				break;
			case 'V':
				EvenValue += 21;
				break;
			case 'W':
				EvenValue += 22;
				break;
			case 'X':
				EvenValue += 23;
				break;
			case 'Y':
				EvenValue += 24;
				break;
			case 'Z':
				EvenValue += 25;
				break;
			}
		}

		return EvenValue;
	}

	public static Integer calcValueOddArr(char[] oddArr) {
		Integer oddValue = 0;

		for (int i = 0; i < oddArr.length; i++) {
			switch (oddArr[i]) {
			case '0':
				oddValue += 1;
				break;
			case '1':
				oddValue += 0;
				break;
			case '2':
				oddValue += 5;
				break;
			case '3':
				oddValue += 7;
				break;
			case '4':
				oddValue += 9;
				break;
			case '5':
				oddValue += 13;
				break;
			case '6':
				oddValue += 15;
				break;
			case '7':
				oddValue += 17;
				break;
			case '8':
				oddValue += 19;
				break;
			case '9':
				oddValue += 21;
				break;
			case 'A':
				oddValue += 1;
				break;
			case 'B':
				oddValue += 0;
				break;
			case 'C':
				oddValue += 5;
				break;
			case 'D':
				oddValue += 7;
				break;
			case 'E':
				oddValue += 9;
				break;
			case 'F':
				oddValue += 13;
				break;
			case 'G':
				oddValue += 15;
				break;
			case 'H':
				oddValue += 17;
				break;
			case 'I':
				oddValue += 19;
				break;
			case 'J':
				oddValue += 21;
				break;
			case 'K':
				oddValue += 2;
				break;
			case 'L':
				oddValue += 4;
				break;
			case 'M':
				oddValue += 18;
				break;
			case 'N':
				oddValue += 20;
				break;
			case 'O':
				oddValue += 11;
				break;
			case 'P':
				oddValue += 3;
				break;
			case 'Q':
				oddValue += 6;
				break;
			case 'R':
				oddValue += 8;
				break;
			case 'S':
				oddValue += 12;
				break;
			case 'T':
				oddValue += 14;
				break;
			case 'U':
				oddValue += 16;
				break;
			case 'V':
				oddValue += 10;
				break;
			case 'W':
				oddValue += 22;
				break;
			case 'X':
				oddValue += 25;
				break;
			case 'Y':
				oddValue += 24;
				break;
			case 'Z':
				oddValue += 23;
				break;
			}
		}

		return oddValue;
	}

	public static String getControlCharFromRest(Integer findRestDiv) {

		String controlChar = "";

		switch (findRestDiv) {
		case 0:
			controlChar = "A";
			break;
		case 1:
			controlChar = "B";
			break;
		case 2:
			controlChar = "C";
			break;
		case 3:
			controlChar = "D";
			break;
		case 4:
			controlChar = "E";
			break;
		case 5:
			controlChar = "F";
			break;
		case 6:
			controlChar = "G";
			break;
		case 7:
			controlChar = "H";
			break;
		case 8:
			controlChar = "I";
			break;
		case 9:
			controlChar = "J";
			break;
		case 10:
			controlChar = "K";
			break;
		case 11:
			controlChar = "L";
			break;
		case 12:
			controlChar = "M";
			break;
		case 13:
			controlChar = "N";
			break;
		case 14:
			controlChar = "O";
			break;
		case 15:
			controlChar = "P";
			break;
		case 16:
			controlChar = "Q";
			break;
		case 17:
			controlChar = "R";
			break;
		case 18:
			controlChar = "S";
			break;
		case 19:
			controlChar = "T";
			break;
		case 20:
			controlChar = "U";
			break;
		case 21:
			controlChar = "V";
			break;
		case 22:
			controlChar = "W";
			break;
		case 23:
			controlChar = "X";
			break;
		case 24:
			controlChar = "Y";
			break;
		case 25:
			controlChar = "Z";
			break;
		}

		return controlChar;
	}

	public static String getControlChar(String codFTemp) {

		String controlChar = "";
		char[] codFTempArray = new char[codFTemp.length()];
		codFTempArray = codFTemp.toCharArray();

		int evenCharsCounter = 0;
		int oddCharsCounter = 0;

		for (int i = 0; i < codFTemp.length(); i++) {

			if (i == 0) {
				oddCharsCounter++;
			} else if (i % 2 == 0) {
				oddCharsCounter++;
			} else
				evenCharsCounter++;
		}

		char[] evenCharsArray = new char[evenCharsCounter];
		char[] oddCharsArray = new char[oddCharsCounter];

		for (int i = 0; i < evenCharsCounter; i++) {
			evenCharsArray[i] = 0;
		}

		for (int i = 0; i < oddCharsCounter; i++) {
			oddCharsArray[i] = 0;
		}

		int evnCnt = 0;
		int oddCnt = 0;

		for (int i = 0; i < codFTemp.length(); i++) {

			if (i == 0) {
				oddCharsArray[oddCnt] = codFTempArray[i];
				oddCnt++;
			} else if (i % 2 == 0) {
				oddCharsArray[oddCnt] = codFTempArray[i];
				oddCnt++;
			} else {
				evenCharsArray[evnCnt] = codFTempArray[i];
				evnCnt++;
			}

		}

		Integer oddAndEvenSum = calcValueOddArr(oddCharsArray) + calcValueEvenArr(evenCharsArray);
		Integer findRestDiv = oddAndEvenSum % 26;

		controlChar = getControlCharFromRest(findRestDiv);

		return controlChar;
	}

	public static void main(String[] args) {


		Identity person = new Identity();
		person.setNome("yourname");
		person.setCognome("yoursurname");
		person.setDataNascita("01/12/1900");
		person.setLuogoNascita("roma");
		person.setGender("m");

		SimpleDateFormat utente = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat cfDataM = new SimpleDateFormat("MM");
		SimpleDateFormat cfDataA = new SimpleDateFormat("yyyy");
		SimpleDateFormat cfDataG = new SimpleDateFormat("dd");

		String cfDataMese = "";
		String cfDataAnno = "";
		String cfDataGiorno = "";

		try {
			cfDataMese = cfDataM.format(utente.parse(person.getDataNascita()));
			cfDataAnno = cfDataA.format(utente.parse(person.getDataNascita()));
			cfDataGiorno = cfDataG.format(utente.parse(person.getDataNascita()));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		ArrayList<String> codiciCatastali = new ArrayList<>();

		codiciCatastali = leggiCsv();

		String codFTemp = getThreeLettersSurname(deleteSpaces(person.getCognome()))
				+ getThreeLettersName(deleteSpaces(person.getNome())) + getTwoYearDigits(Integer.parseInt(cfDataAnno))
				+ getOneMonthDigit(Integer.parseInt(cfDataMese))
				+ getDayAndGenderDigits(Integer.parseInt(cfDataGiorno), person.getGender())
				+ findAndGetCatastalCode(codiciCatastali, person.getLuogoNascita());

		String fiscalCode = getThreeLettersSurname(deleteSpaces(person.getCognome()))
				+ getThreeLettersName(deleteSpaces(person.getNome())) + getTwoYearDigits(Integer.parseInt(cfDataAnno))
				+ getOneMonthDigit(Integer.parseInt(cfDataMese))
				+ getDayAndGenderDigits(Integer.parseInt(cfDataGiorno), person.getGender())
				+ findAndGetCatastalCode(codiciCatastali, person.getLuogoNascita()) + getControlChar(codFTemp);
		
		System.out.println(fiscalCode);
	}

}

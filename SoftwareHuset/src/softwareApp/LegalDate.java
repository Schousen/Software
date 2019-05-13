package softwareApp;

public class LegalDate {

	// Udarbejdet af Chritian
	public static boolean checkEndLaterThanStartDate(int startDay, int startMonth, int startYear, int endDay
			, int endMonth, int endYear) {
		assert true;
		if (endYear > startYear)
		{
			assert(endYear > startYear ==  true); //postconditon
			return true;
		}
		else if(endYear==startYear)
		{
			assert(endYear==startYear); //precondtion
			if (endMonth>startMonth)
			{
				assert (endMonth>startMonth && endYear==startYear == true); //postconditon
				return true;
			}
			else if (endMonth==startMonth)
			{
				assert(endMonth==startMonth && endYear==startYear); //preconditon
				if (endDay>=startDay)
				{
					assert (endDay>=startDay == true); // postcondition
					return true;
				}
			}
		}
			throw new IllegalArgumentException("End date cannot be before start date");
	}
	//Udarbejdet af Anton
	public static boolean checkLegalDateFormat(String Day, String Month, String Year) {
		return (checkDay(Day) && checkMonth(Month) && checkYear(Year));
	
	}

	//Udarbejdet af Anton
	private static boolean checkYear(String startYear) {
		assert startYear !=null; //precondition
		if (startYear.matches("^[0-9]*$") && startYear.length() == 4) {
			assert((startYear.matches("^[0-9]*$") &&
					startYear.length() == 4) == true); //postCondition
			return true;
		}
		else
			throw new IllegalArgumentException("Years should only consist of numbers");
	}
	//Udarbejdet af Anton
	private static boolean checkMonth(String startMonth) {
		if (startMonth.matches("^[0-9]*$") && startMonth.length() == 2)
			if ( Integer.parseInt(startMonth) < 13 )
			return true;
			else
				throw new IllegalArgumentException("Illegal month input");
		else
			throw new IllegalArgumentException("Months should only consist of numbers");
	}
	//Udarbejdet af Anton
	private static boolean checkDay(String startDay) {
		if (startDay.matches("^[0-9]*$") && startDay.length() == 2)
			if (Integer.parseInt(startDay) < 32 )
			return true;
			else
				throw new IllegalArgumentException("Illegal day input");
		else
			throw new IllegalArgumentException("Days should only consist of numbers");
	}
}

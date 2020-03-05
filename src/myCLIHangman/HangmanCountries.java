package myCLIHangman;

public class HangmanCountries {
	public String[] countriesABC = {"Afghanistan","Aland Islands", "Albania","Algeria","American Samoa","Andorra","Angola","Anguilla","Antarctica",
			"Antigua and Barbuda","Argentina","Armenia","Aruba","Australia","Austria","Azerbaijan",
			"Bahrain","Bahamas","Bangladesh","Barbados","Belarus","Belgium","Belize","Benin","Bermuda","Bhutan","Bolivia, Plurinational State of Bonaire, Sint Eustatius and Saba",
			"Bosnia and Herzegovina","Botswana","Bouvet Island","Brazil","British Indian Ocean Territory","Brunei Darussalam","Bulgaria","Burkina Faso","Burundi",
			"Cambodia","Cameroon","Canada","Cape Verde","Cayman Islands","Central African Republic","Chad","Chile","China","Christmas Island","Cocos (Keeling) Islands","Colombia",
			"Comoros","Congo","Congo, the Democratic Republic of the","Cook Islands","Costa Rica","Côte d'Ivoire","Croatia","Cuba","Curacao","Cyprus","Czech Republic"};
		
	public HangmanCountries() {};
	
	public String getCountry() {
		
		String country = "";
		myRandom randomCountryIndex = new myRandom ();
		
		country = this.countriesABC[randomCountryIndex.randomIndex(this.countriesABC.length)];
		//System.out.println("TEST: Selected random country: " + country);
		return country;
	}
	
	public String getCountry(int index) {
		
		String country = "";
		
		if (index >= 0 && index <= countriesABC.length) {
			country = countriesABC[index];
		}
		//System.out.println("TEST: Selected a country: " + country);
		return country;
	}
	
}
